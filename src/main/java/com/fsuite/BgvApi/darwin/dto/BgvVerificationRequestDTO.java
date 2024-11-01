/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.darwin.dto;

public class BgvVerificationRequestDTO
{
	
	private String api_key;

    private String bgv_id;

    private String unique_id;

    private String action;

    private String bgv_status;

    private String bgv_report;

    private String bgv_comments;

	public String getApi_key()
	{
		return api_key;
	}

	public void setApi_key(String api_key)
	{
		this.api_key = api_key;
	}

	public String getBgv_id()
	{
		return bgv_id;
	}

	public void setBgv_id(String bgv_id)
	{
		this.bgv_id = bgv_id;
	}

	public String getUnique_id()
	{
		return unique_id;
	}

	public void setUnique_id(String unique_id)
	{
		this.unique_id = unique_id;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public String getBgv_status()
	{
		return bgv_status;
	}

	public void setBgv_status(String bgv_status)
	{
		this.bgv_status = bgv_status;
	}

	public String getBgv_report()
	{
		return bgv_report;
	}

	public void setBgv_report(String bgv_report)
	{
		this.bgv_report = bgv_report;
	}

	public String getBgv_comments()
	{
		return bgv_comments;
	}

	public void setBgv_comments(String bgv_comments)
	{
		this.bgv_comments = bgv_comments;
	}

	@Override
	public String toString()
	{
		return "BgvVerificationRequestDTO [api_key=" + api_key + ", bgv_id="
				+ bgv_id + ", unique_id=" + unique_id + ", action=" + action
				+ ", bgv_status=" + bgv_status + ", bgv_report=" + bgv_report
				+ ", bgv_comments=" + bgv_comments + "]";
	}
    
    

}
