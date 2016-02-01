package com.akira.in.services;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.akira.in.model.AuiCurrent;
import com.akira.in.model.AuiSummary;
import com.akira.in.repository.AuiCurrentRepository;
import com.akira.in.repository.AuiSummaryRepository;

@Service
@Transactional
public class SummaryService {
	@Resource
	AuiSummaryRepository auisr;

	@Resource
	AuiCurrentRepository auiRepo;

	public void summarizeLogs() {
		System.out.println("in ssss");

		List<String> uniqueUrl = null;

		uniqueUrl = auiRepo.findDistinctUrl();

		AuiSummary auis;
		for (String url : uniqueUrl) {
			auis = new AuiSummary();
			auis.setAverageTimeInMicro(auiRepo.averageResponseTime(url));
			DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
			
			
			auis.setDate(dateformat.format(new Date()));
			
			auis.setFailureStatusCode(auiRepo.numberOfFailure(url));
			auis.setSuccessStatusCode(auiRepo.numberOfSuccess(url));
			auis.setUrlRequested(url);
			auisr.saveAndFlush(auis);

		}
		
		

	}
	public List<AuiSummary> getSummaryLog(String d,int pagenumber, int pSize, String order,String sortBy) {
			
			PageRequest pageRequest = new PageRequest(pagenumber, pSize,order.equals("DESC")?Sort.Direction.DESC:Sort.Direction.ASC,sortBy);
			Pageable p=pageRequest;
			List<AuiSummary> list = new ArrayList<>();
		
				
				list.addAll(auisr.findByDate(d, p).getContent());
	
			
		return list;
	}
}
