package com.springmongodbademely;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/** Component with methods scheduled to execute hourly and quarterly
 * @author Intelma
 *
 */
@Component
public class ProcessAlarms {
	
	//@Autowired
	//private ProcessServiceImpl processService;
	private static final Logger LOG = LoggerFactory.getLogger(ProcessAlarms.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		LOG.info("The time is now {}", dateFormat.format(new Date()));
	}
	/**
	 * Method scheduled to execute every 60 minutes
	 */
	@Scheduled(cron = "${schedule.hourly}")
	public void proccessSoftAlarms60(){
		LOG.debug("****And Hour****");
		//processService.processAlarms("60");
    }
	
	/**
	 * Method scheduled to execute every 15 minutes
	 */
	@Scheduled(cron = "${schedule.quarterly}")
	public void proccessSoftAlarms15(){
		LOG.debug("****And quarterly****");
		//processService.processAlarms("15");
    }
    
}