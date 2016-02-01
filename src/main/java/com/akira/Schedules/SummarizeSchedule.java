package com.akira.Schedules;



import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.akira.in.services.SummaryService;

@Component
public class SummarizeSchedule implements Job {
	@Resource
	SummaryService s;
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Hello Quartz!");
		s.summarizeLogs();
	
	}

}
