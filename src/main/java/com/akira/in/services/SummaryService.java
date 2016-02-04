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

	public void summarizeLogs(String date) {
		System.out.println("in ssss");

		List<String> uniqueUrl = null;

		uniqueUrl = auiRepo.findDistinctUrl(date);

		AuiSummary auis;
		for (String url : uniqueUrl) {
			auis = new AuiSummary();
			auis.setDate(date);	
			
			auis.setAverageTimeInMicro(auiRepo.averageResponseTime(url,date));
			auis.setFailureStatusCode(auiRepo.numberOfFailure(url,date));
			auis.setSuccessStatusCode(auiRepo.numberOfSuccess(url,date));
			auis.setRedirectStatusCode(auiRepo.numberOfRedirect(url, date));
			auis.setUrlRequested(url);
			auisr.saveAndFlush(auis);

		}

	}

	public List<AuiSummary> getSummaryLog(String d, int pagenumber, int pSize, String order, String sortBy) {

		PageRequest pageRequest = new PageRequest(pagenumber, pSize,
				order.equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC, sortBy);
		Pageable p = pageRequest;
		List<AuiSummary> list = new ArrayList<>();

		list.addAll(auisr.findByDate(d, p).getContent());
		return list;
	}

	public int getTotalPages(String d, int pSize) {
		return (int) Math.ceil((auisr.findByDate(d).size() / (float) pSize));

	}
	
	public List<Integer> successListByUrlBetweenDates(String url,String startDate,String endDate){
		return auisr.findSuccessListByUrlBetweenDates(url, startDate, endDate);
	}
	
	public List<Integer> failureListByUrlBetweenDates(String url,String startDate,String endDate){
		return auisr.findFailureListByUrlBetweenDates(url, startDate, endDate);
	}
	public List<Integer> redirectListByUrlBetweenDates(String url,String startDate,String endDate){
		return auisr.findRedirectListByUrlBetweenDates(url, startDate, endDate);
	}
	public List<String> dateListByUrlBetweenDates(String url,String startDate,String endDate){
		return auisr.findDateListByUrlBetweenDates(url, startDate, endDate);
	}
	
	
	
	

}
