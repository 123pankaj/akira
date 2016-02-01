package com.akira.Schedules;


import javax.annotation.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.akira.in.services.SummaryService;

@EnableScheduling
@Component
public class SummarizerCronTrigger {
	@Resource
	SummaryService summaryservice;
	
	@Scheduled(cron="0 40 13 * * ?")
	public void start() throws Exception {
		System.out.println("hi");
		summaryservice.summarizeLogs();
	}
}
