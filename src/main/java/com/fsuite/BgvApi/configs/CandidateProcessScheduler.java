/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.fsuite.BgvApi.service.IBgvService;

@Component
public class CandidateProcessScheduler implements Runnable
{

	private static final Logger log = LoggerFactory.getLogger(CandidateProcessScheduler.class);
	
	@Autowired
	private ApplicationContext context;
	
	@Override
	public void run()
	{
		log.info("[CandidateProcessScheduler][run]");
		try
		{
			IBgvService iBgvService = context.getBean(IBgvService.class);
			iBgvService.sendProcessStatus();
		}
		catch(Exception e)
		{
			log.error("[CandidateProcessScheduler][run]", e);
		}
		
	}

}
