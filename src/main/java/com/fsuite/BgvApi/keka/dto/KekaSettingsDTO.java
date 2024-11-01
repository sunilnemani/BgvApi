/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.keka.dto;

import com.fsuite.BgvApi.utils.Value;

public class KekaSettingsDTO
{
	
	@Value("${KEKA_GRANT_TYPE}")
	private String kekaGrantType;
	
	@Value("${KEKA_SCOPE}")
	private String kekaScope;

	public String getKekaGrantType()
	{
		return kekaGrantType;
	}

	public void setKekaGrantType(String kekaGrantType)
	{
		this.kekaGrantType = kekaGrantType;
	}
	
	public String getKekaScope()
	{
		return kekaScope;
	}

	public void setKekaScope(String kekaScope)
	{
		this.kekaScope = kekaScope;
	}

	@Override
	public String toString()
	{
		return "KekaSettingsDTO [kekaGrantType=" + kekaGrantType
				+ ", kekaScope=" + kekaScope + "]";
	}

}
