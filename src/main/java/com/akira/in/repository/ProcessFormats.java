package com.akira.in.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.akira.in.util.Constant;

@Service
@Transactional
public class ProcessFormats {

	public Map<String, String> verifyFormat(String format, String testStr) {
		format = format.trim();
		List<String> nameList = new ArrayList<String>();
		Map<String, String> filter = getFilterMap(format, nameList);
		// After above call , we have all field name in name List, and
		// termination filter in filter map.
		return getValuesFromString(testStr, filter,nameList);

	}

	public Map<String, String> getValuesFromString(String testStr,
			Map<String, String> filter,List<String> nameList) {
		
		Map<String, String> resultMap = new HashMap<String, String>();
		StringTokenizer logLine = new StringTokenizer(testStr,
				Constant.NEXT_LINE);

		while (logLine.hasMoreTokens()) {
			String log = logLine.nextToken();
			for (String name : nameList) {
				String value = Constant.BLANK_SPACE;
				if (filter.get(name).equals("\""))
					log = log.substring(1);
				value = log.substring(0, log.indexOf(filter.get(name)));
				if ((log.indexOf(filter.get(name)) + 1) < log.length())
					log = log.substring(log.indexOf(filter.get(name)) + 1);
				log = log.trim();
				resultMap.put(name, value);
			}
		}
		return resultMap;
	}

	public Map<String, String> getFilterMap(String format, List<String> nameList) {
		Pattern fieldNamePattern = Pattern.compile(Constant.PattrenForFields);
		Map<String, String> filter = new HashMap<String, String>();
		List<String> formatExists = new ArrayList<String>();
		format = findBracesinFormat(format, formatExists);

		String[] arra = format.split(Constant.Percentage);
		for (int i = 0; i < arra.length; i++) {
			arra[i] = arra[i].trim();
			if (arra[i].length() == 0)
				continue;
			Matcher fieldMatcher = fieldNamePattern.matcher(arra[i]);
			String fieldName = new String();
			if (fieldMatcher.find()) {
				fieldName = Constant.apacheDefaultSettings
						.get(Constant.Percentage + fieldMatcher.group(1));
				if (fieldMatcher.group(2) == null) {
					if (formatExists.contains(Constant.Percentage
							+ fieldMatcher.group(1))) {
						filter.put(fieldName, "\"");
					} else
						filter.put(fieldName, " ");
				} else {
					filter.put(fieldName, fieldMatcher.group(2));
				}
			}
			nameList.add(fieldName);
		}
		return filter;
	}

	private String findBracesinFormat(String format, List<String> formatExists) {

		Pattern bracesPattern = Pattern.compile(Constant.PatternForBraces);
		Matcher bracesMatcher = bracesPattern.matcher(format);
		while (bracesMatcher.find()) {
			if (Constant.formaterHelper.get(bracesMatcher.group(1)) != null) {
				// If text inside the {} found as known helper, replace the
				// String with helper abbreviation
				format = format.replace(
						bracesMatcher.group(0),
						Constant.Percentage
								+ Constant.formaterHelper.get(bracesMatcher
										.group(1)));
				formatExists.add(Constant.Percentage
						+ Constant.formaterHelper.get(bracesMatcher.group(1)));
			} else {
				// If it is unknown then replace the {abc} with space
				format = format.replace(bracesMatcher.group(0),
						Constant.Percentage + bracesMatcher.group(2));
				formatExists.add(Constant.Percentage + bracesMatcher.group(2));
			}
		}
		return format;
	}

}
