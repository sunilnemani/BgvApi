/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.darwin.dto;

public class DarwinBgvClientRequestDTO
{
	
	private String candListUrl;
	private String details_url;
	private String downloadUrl;
	private String verification_url;
	private String clientId;
	private String password;
	private String auth_username;
	private String auth_password;
	private BgvRequestDTO bgvRequest;
	
	public String getCandListUrl()
	{
		return candListUrl;
	}
	public void setCandListUrl(String candListUrl)
	{
		this.candListUrl = candListUrl;
	}
	public String getDetails_url()
	{
		return details_url;
	}
	public void setDetails_url(String details_url)
	{
		this.details_url = details_url;
	}
	public String getDownloadUrl()
	{
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl)
	{
		this.downloadUrl = downloadUrl;
	}
	public String getVerification_url()
	{
		return verification_url;
	}
	public void setVerification_url(String verification_url)
	{
		this.verification_url = verification_url;
	}
	public String getClientId()
	{
		return clientId;
	}
	public void setClientId(String clientId)
	{
		this.clientId = clientId;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getAuth_username()
	{
		return auth_username;
	}
	public void setAuth_username(String auth_username)
	{
		this.auth_username = auth_username;
	}
	public String getAuth_password()
	{
		return auth_password;
	}
	public void setAuth_password(String auth_password)
	{
		this.auth_password = auth_password;
	}
	public BgvRequestDTO getBgvRequest()
	{
		return bgvRequest;
	}
	public void setBgvRequest(BgvRequestDTO bgvRequest)
	{
		this.bgvRequest = bgvRequest;
	}
	@Override
	public String toString()
	{
		return "BgvClientRequestDTO [candListUrl=" + candListUrl
				+ ", details_url=" + details_url + ", downloadUrl="
				+ downloadUrl + ", verification_url=" + verification_url
				+ ", clientId=" + clientId + ", password=" + password
				+ ", auth_username=" + auth_username + ", auth_password="
				+ auth_password + ", bgvRequest=" + bgvRequest + "]";
	}
	
}
