package com.caida.quartz;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.newJob;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Myjob implements org.quartz.Job {
	

	public Myjob() {
	}

	public static void main(String[] args) {
		
		
		Scheduler scheduler;
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			
			JobDetail job = newJob(Myjob.class).withIdentity("job1", "group1")
				      .build();
			 
			Trigger trigger = org.quartz.TriggerBuilder.newTrigger()
				      .withIdentity("trigger1", "group1")
				      .startNow()
				      .withSchedule(org.quartz.SimpleScheduleBuilder.simpleSchedule()
				              .withIntervalInSeconds(5)
				              .repeatForever())
				      .build();
		    
			
			scheduler.scheduleJob(job, trigger);
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		DateFormat emailformat = new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
		String emailTime = emailformat.format(System.currentTimeMillis());
		System.err.println("Hello World!  MyJob is executing. " + emailTime);
	}


	

}
