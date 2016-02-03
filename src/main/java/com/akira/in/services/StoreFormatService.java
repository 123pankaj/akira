package com.akira.in.services;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.joda.time.Days;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.akira.in.model.AuiCurrent;
import com.akira.in.model.AuiSummary;
import com.akira.in.repository.AuiCurrentRepository;
import com.akira.in.repository.AuiSummaryRepository;
import com.akira.in.repository.ProcessFormats;
import com.akira.in.util.Constant;

@Service
@Transactional
public class StoreFormatService {

	@Resource
	ProcessFormats processFormats;

	@Resource
	AuiCurrentRepository auiRepo;

	@Resource
	AuiSummaryRepository auisr;
	
	public void analysisFormat(String format, String testStr) {
		format = format.trim();
		List<String> nameList = new ArrayList<String>();
		Map<String, String> resultMap = new HashMap<String, String>();
		Map<String, String> filter = processFormats.getFilterMap(format,
				nameList);
		// After above call , we have all field name in name List, and
		// termination filter in filter map.
		String logLine[] = testStr.split("\\r?\\n");
		int index = 0;
		while (index < logLine.length) {
			String log = logLine[index];
			System.out.println("Analysing line : " + log);
			resultMap = processFormats.getValuesFromString(log, filter,
					nameList);
			System.out.println("------------------------------------\n"
					+ resultMap + "\n-------------------------------------");
			saveLogDataInModel(resultMap);

			index++;
		}
	}

	private void saveLogDataInModel(Map<String, String> resultMap) {
		AuiCurrent auiLogModel = new AuiCurrent();
		auiLogModel.setByteSent(Integer.parseInt(resultMap.get("BytesSent")));
		auiLogModel.setEndpoint(resultMap.get("ServerName") + ":"
				+ resultMap.get("CanonicalPort"));
		auiLogModel.setProcessId(resultMap.get("ProcessIdChild"));
		auiLogModel.setReferHead(resultMap.get("Referer"));
		auiLogModel.setRemoteHostName(resultMap.get("RemoteHostName"));
		auiLogModel.setRequestMethod(resultMap.get("RequestMethod"));
		auiLogModel.setTimeInMicro(Integer.parseInt(resultMap
				.get("ResponseTimeMicroSecond")));
		auiLogModel.setUrlRequested(resultMap.get("URLPathRequested"));
		auiLogModel.setQueryString(resultMap.get("QueryString"));
		auiLogModel.setUserAgent(resultMap.get("User-Agent"));
		auiLogModel.setStatusCode(resultMap.get("FinalStatus"));
		Date dateOfRequest = null;
		try {
			dateOfRequest = Constant.formatter.parse(resultMap.get(
					"TimeOfRequest").replaceAll("\"", ""));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		auiLogModel.setTime(dateOfRequest);
		auiRepo.saveAndFlush(auiLogModel);
	}

	public List<AuiCurrent> getAUILog(String d,int pagenumber, int pSize, String order,String sortBy) {
		
		PageRequest pageRequest = new PageRequest(pagenumber, pSize,order.equals("DESC")?Sort.Direction.DESC:Sort.Direction.ASC,sortBy);
		Pageable p=pageRequest;
		List<AuiCurrent> list = new ArrayList<>();
		try {
			DateFormat dateformat=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.S");
			Date dayStart=dateformat.parse(d+" 00:00:00.0");
			Date dayEnd=dateformat.parse(d+" 23:59:59.9");
			list.addAll(auiRepo.findByTimeBetween(dayStart,dayEnd, p).getContent());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	
	public int getTotalPages(String d, int pSize) {

		DateFormat dateformat=new SimpleDateFormat("yyyy-mm-dd");
		Date dayEnd=new Date();
		try {

			 dayEnd=new Date((dateformat.parse(d).getTime()+24*60*60*1000));
			System.out.println(auiRepo.totalLogsBetween(d,dateformat.format(dayEnd)));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return auiRepo.totalLogsBetween(d,dateformat.format(dayEnd));
	}
	



}
