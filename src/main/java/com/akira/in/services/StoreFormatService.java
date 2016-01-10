package com.akira.in.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.akira.in.util.Constant;

@Service
public class StoreFormatService {

	public void analysisFormat(String format, String testStr) {

		System.out.println("Format given to us is " + format);
		format= format.trim();
		String token = format.replaceAll(".*/([^/]+)/.*", "$1");
		//System.out.println(token); 
		Map<String, String> filter = new HashMap<String, String>();
		List<String> nameList = new ArrayList<String>();
		//String pattern = "%\\{(.*)\\}.*";
		String pattern="%\\{(.*)\\}.{1}\"?\\s{1}";
		// Create a Pattern object
	      Pattern r = Pattern.compile(pattern);
	      Matcher m = r.matcher(format);
	      if (m.find( )) {
	         System.out.println("Found value: " + m.group(1) );
	      } else {
	         System.out.println("NO MATCH");
	      }
		
		
		/*String[] arra = format.split(Constant.percentage);
		
		for (int i = 0; i < arra.length; i++) {
			System.out.println(" Playing with ' "+ arra[i]+"'");
			if(arra[i].length() ==0)
				continue;
			System.out.println(" After cehck Playing with ' "+ arra[i]+"'");
			String fieldName = Constant.apacheDefaultSettings
					.get(Constant.percentage + arra[i].charAt(0));
			if (arra[i].trim().length() > 1) {
				filter.put(fieldName, arra[i].substring(1, arra[i].length()));
			} else {
				filter.put(fieldName, " ");
			}
			nameList.add(fieldName);

		} // end of for loopssh ubuntu
		for(String name : nameList){
			System.out.println("for " + name + " You have to cut till next '" + filter.get(name)+"'") ;
			
		}
		
		for(String name : nameList){
			String value = testStr.substring(0,testStr.indexOf(filter.get(name)));
			testStr = testStr.substring(testStr.indexOf(filter.get(name))+1);
			System.out.println( name+ " : " + value);
		}*/
	}
	
	public void storeLogsInDB(String logStr){
		StringTokenizer st = new StringTokenizer(logStr, " ");
		
	}
}
