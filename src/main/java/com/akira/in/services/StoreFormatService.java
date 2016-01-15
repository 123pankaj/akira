package com.akira.in.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.akira.in.model.AuiCurrent;
import com.akira.in.repository.AuiCurrentRepository;
import com.akira.in.util.Constant;

@Service
@Transactional
public class StoreFormatService {

	@Resource
	AuiCurrentRepository auiRepo;

	public void analysisFormat(String format, String testStr) {
		format = format.trim();
		List<String> nameList = new ArrayList<String>();
		Map<String, String> resultMap = new HashMap<String, String>();
		Map<String, String> filter = getFilterMap(format, nameList);
		// After above call , we have all field name in name List, and
		// termination filter in filter map.
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
				System.out.println(name + " : " + value);
				resultMap.put(name, value);
			}
			//saveAuiObject(resultMap);
			AuiCurrent auiLogModel = new AuiCurrent();
			auiLogModel.setByteSent(resultMap.get("BytesSent"));
			auiLogModel.setEndpoint(resultMap.get("ServerName")+":"+resultMap.get("CanonicalPort"));
			auiLogModel.setProcessId(resultMap.get("ProcessIdChild"));
			auiLogModel.setReferHead(resultMap.get("Referer"));
			auiLogModel.setRemoteHostName(resultMap.get("RemoteHostName"));
			auiLogModel.setRequestMethod(resultMap.get("RequestMethod"));
			auiLogModel.setTimeInMicro(Integer.parseInt(resultMap.get("ResponseTimeMicroSecond")));
			auiLogModel.setUrlRequested(resultMap.get("URLPathRequested")+resultMap.get("QueryString"));
			auiLogModel.setUserAgent(resultMap.get("User-Agent"));
			auiLogModel.setStatusCode(resultMap.get("FinalStatus"));
			Date dateOfRequest =null;
			try {
				dateOfRequest = Constant.formatter.parse(resultMap.get("TimeOfRequest").replaceAll("\"", ""));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			auiLogModel.setTime(dateOfRequest);
			auiRepo.saveAndFlush(auiLogModel);
		}
	}

	public Map<String, String> verifyFormat(String format, String testStr) {
		format = format.trim();
		List<String> nameList = new ArrayList<String>();
		Map<String, String> resultMap = new HashMap<String, String>();
		Map<String, String> filter = getFilterMap(format, nameList);
		// After above call , we have all field name in name List, and
		// termination filter in filter map.
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
	
	public List<AuiCurrent> getAUILog(){
		
		List<AuiCurrent> list=auiRepo.findAll();
		System.out.println("****Total Number of list are *** "+ list.size());
		return list;
	}
	
	private Map<String, String> getFilterMap(String format,
			List<String> nameList) {
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
