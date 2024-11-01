package com.fsuite.BgvApi.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.fsuite.*")
public class BgvApiApplication extends SpringBootServletInitializer 
{

	private static final Logger log=LoggerFactory.getLogger(BgvApiApplication.class);
	
	public static void main(String[] args) 
	{
		log.info("Application is starting");
		SpringApplication.run(BgvApiApplication.class, args);
		log.info("Application is started");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
	{
		return application.sources(BgvApiApplication.class);
	}

}
