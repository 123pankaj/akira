package com.akira.in.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.akira.in.util.Constant;

@Service
public class StoreFormatService {

	public void analysisFormat(String format, String testStr) {

		System.out.println("Format given to us is " + format);
		Map<String, String> filter = new HashMap<String, String>();
		List<String> nameList = new ArrayList<String>();
		
		String[] arra = format.split(Constant.percentage);
		
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

		} // end of for loop
		for(String name : nameList){
			System.out.println("for " + name + " You have to cut till next '" + filter.get(name)+"'") ;
			
		}
		
		for(String name : nameList){
			String value = testStr.substring(0,testStr.indexOf(filter.get(name)));
			testStr = testStr.substring(testStr.indexOf(filter.get(name))+1);
			System.out.println( name+ " : " + value);
		}
		  
		
	}
}
