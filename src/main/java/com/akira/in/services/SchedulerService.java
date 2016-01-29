package com.akira.in.services;

import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.akira.in.model.AuiSummary;
import com.akira.in.repository.AuiSummaryRepository;

@Service
@Transactional
public class SchedulerService {
	@Resource
AuiSummaryRepository auisr;
	
	public void addtosum(){
		AuiSummary auis=new AuiSummary();
		auis.setAverageTimeInMicro(1);
		auis.setDate(new Date());
		auis.setFailureStatusCode(1);
		auis.setSuccessStatusCode(6);
		auis.setUrlRequested("hbgv");
		auisr.saveAndFlush(auis);
	}
}
