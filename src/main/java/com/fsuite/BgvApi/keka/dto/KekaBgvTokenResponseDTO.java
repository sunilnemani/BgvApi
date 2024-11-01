/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.keka.dto;

public class KekaBgvTokenResponseDTO
{
	
	private String access_token;
	
	private Integer expires_in;
	
	private String token_type;
	
	private String scope;
	
	private String error;

	public String getAccess_token()
	{
		return access_token;
	}

	public void setAccess_token(String access_token)
	{
		this.access_token = access_token;
	}

	public Integer getExpires_in()
	{
		return expires_in;
	}

	public void setExpires_in(Integer expires_in)
	{
		this.expires_in = expires_in;
	}

	public String getToken_type()
	{
		return token_type;
	}

	public void setToken_type(String token_type)
	{
		this.token_type = token_type;
	}

	public String getScope()
	{
		return scope;
	}

	public void setScope(String scope)
	{
		this.scope = scope;
	}

	public String getError()
	{
		return error;
	}

	public void setError(String error)
	{
		this.error = error;
	}

	@Override
	public String toString()
	{
		return "KekaBgvTokenResponseDTO [access_token=" + access_token
				+ ", expires_in=" + expires_in + ", token_type=" + token_type
				+ ", scope=" + scope + ", error=" + error + "]";
	}

	

}
