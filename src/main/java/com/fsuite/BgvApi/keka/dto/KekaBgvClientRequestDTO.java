/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.keka.dto;

public class KekaBgvClientRequestDTO
{

	private String tokenUrl;

	private String detailsUrl;

	private String bgvClientId;

	private String bgvPassword;

	private String kekaClientId;

	private String kekaClientSecret;

	private String apiKey;
	
	private String ids;

	public String getTokenUrl()
	{
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl)
	{
		this.tokenUrl = tokenUrl;
	}

	public String getDetailsUrl()
	{
		return detailsUrl;
	}

	public void setDetailsUrl(String detailsUrl)
	{
		this.detailsUrl = detailsUrl;
	}

	public String getBgvClientId()
	{
		return bgvClientId;
	}

	public void setBgvClientId(String bgvClientId)
	{
		this.bgvClientId = bgvClientId;
	}

	public String getBgvPassword()
	{
		return bgvPassword;
	}

	public void setBgvPassword(String bgvPassword)
	{
		this.bgvPassword = bgvPassword;
	}

	public String getKekaClientId()
	{
		return kekaClientId;
	}

	public void setKekaClientId(String kekaClientId)
	{
		this.kekaClientId = kekaClientId;
	}

	public String getKekaClientSecret()
	{
		return kekaClientSecret;
	}

	public void setKekaClientSecret(String kekaClientSecret)
	{
		this.kekaClientSecret = kekaClientSecret;
	}

	public String getApiKey()
	{
		return apiKey;
	}

	public void setApiKey(String apiKey)
	{
		this.apiKey = apiKey;
	}

	public String getIds()
	{
		return ids;
	}

	public void setIds(String ids)
	{
		this.ids = ids;
	}

	@Override
	public String toString()
	{
		return "KekaBgvClientRequestDTO [tokenUrl=" + tokenUrl + ", detailsUrl="
				+ detailsUrl + ", bgvClientId=" + bgvClientId + ", bgvPassword="
				+ bgvPassword + ", kekaClientId=" + kekaClientId
				+ ", kekaClientSecret=" + kekaClientSecret + ", apiKey="
				+ apiKey + "]";
	}

}
