package com.akira.Schedules;

import javax.annotation.PostConstruct;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

public class SummarizerCronTrigger {
	
	@PostConstruct
	public void start() throws Exception {
		JobDetail job = new JobDetail();
		job.setName("SummarizeJob");
		job.setJobClass(SummarizeSchedule.class);

		CronTrigger trigger = new CronTrigger();
		trigger.setName("CronSummarizeJob");
		trigger.setCronExpression("0/1 * * * * ?");

		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}
}
