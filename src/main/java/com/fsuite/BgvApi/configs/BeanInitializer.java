/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.configs;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fsuite.BgvApi.dto.SettingsDTO;
import com.fsuite.BgvApi.utils.Commons;

@Configuration
public class BeanInitializer
{
	private static final Logger log = LoggerFactory.getLogger(BeanInitializer.class);
	
	private static final String PROPERTIES_PROPERTIES="properties.properties";
	
	@Autowired
	private CanditateDetailsLoader candLoader;
	
	@Autowired
	private CandidateProcessScheduler processScheduler;

    @Bean
    SettingsDTO loadSettingsProperties()
	{
    	
		SettingsDTO settingsDTO=null;
		Properties props = new Properties();
	    InputStream in=null;
	    Map<String, String> propsMap=null;
	    try
	    {
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_PROPERTIES);
			props.load(in);
	    }
	    catch (Exception e) 
	    {
			log.error("Unable to load properties.properties");
			throw new RuntimeException("Unable to load properties.properties");
		}
	    try
	    {
	    	settingsDTO=new SettingsDTO();
	    	String value = null;
	    	propsMap=new HashMap<String, String>();
	    	for(String key : props.stringPropertyNames())
			{
	    		value = props.getProperty(key);
	    		propsMap.put(key, value);
			}
	    	Commons.readAndFillValues(settingsDTO, propsMap);
	    	Commons.readAndFillValues(settingsDTO.getKekaSettingsDTO(), propsMap);
	    	
	    	this.startUpSchedulers(settingsDTO);
	    }
	    catch (Exception e) 
	    {
	    	log.error("Unable to load properties.properties");
			throw new RuntimeException("Unable to load SettingsDTO class");
		}
		return settingsDTO;
	}

    @Bean
    RestClient getRestClient(@Autowired SettingsDTO settingsDTO) throws Exception
	{
    	log.info("[BeanInitializer][getRestClient] - "+"Initializing RestClient");
    	RestClient restClient;
    	try
    	{
    		restClient=new RestClient(settingsDTO.getConnectionTimeout(), settingsDTO.getConnectionReqTimeout(), settingsDTO.getSocketTimeout());
    	}
    	catch(Exception e)
    	{
    		log.error("[BeanInitializer][getRestClient] - "+"Unable to load RestClient.");
    		throw new RuntimeException("Unable to load RestClient.");
    	}
		return restClient;
	}
	
    
    private void startUpSchedulers(SettingsDTO settingsDTO)
    {
    	ScheduledExecutorService stp = Executors.newScheduledThreadPool(1);
		stp.scheduleWithFixedDelay(this.candLoader, settingsDTO.getInitialDelay(), settingsDTO.getDelay(), TimeUnit.SECONDS);
		
		stp.scheduleWithFixedDelay(this.processScheduler, settingsDTO.getInitialDelay(), settingsDTO.getDelay(), TimeUnit.SECONDS);
    }

}
