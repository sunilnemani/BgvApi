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
public class CanditateDetailsLoader implements Runnable	
{
	
	private static final Logger log = LoggerFactory.getLogger(CanditateDetailsLoader.class);
	
	@Autowired
	private ApplicationContext context;

	@Override
	public void run()
	{
		try
		{
			IBgvService iBgvService = context.getBean(IBgvService.class);
			iBgvService.loadCanditateDetails();
		}
		catch (Exception e) 
		{
			log.error("Error ",e);
		}
		
	}

}
