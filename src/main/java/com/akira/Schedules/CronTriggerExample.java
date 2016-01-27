package com.akira.Schedules;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerExample {

	public void start() throws Exception {

		JobDetail job = new JobDetail();
		job.setName("SummarizeJob");
		job.setJobClass(HelloJob.class);

		CronTrigger trigger = new CronTrigger();
		trigger.setName("CronSummarizeJob");
		trigger.setCronExpression("0/1 * * * * ?");

		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}
}
