/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.dto;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;

@SuppressWarnings("deprecation")
public interface BaseDTO
{
	
	public Map<String, String> processVariables();
	
	public default String processTemplateData(String template,BaseDTO... baseDTOs)
	{
		String finalMessage=null;
		if(baseDTOs != null && baseDTOs.length > 0)
		{
			Map<String,String> valuesMap = new HashMap<String,String>();
			for(BaseDTO baseDTO : baseDTOs)
		  	{
				valuesMap.putAll(baseDTO.processVariables());
		  	}
			finalMessage = StrSubstitutor.replace(template,valuesMap);
		}
		return finalMessage;
	}

}
