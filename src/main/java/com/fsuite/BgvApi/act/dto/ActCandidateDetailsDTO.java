/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.act.dto;

import java.io.Serializable;

public class ActCandidateDetailsDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String caseid;
	
	private String candidate;
	
	private String employeeid;
	
	private String email;
	
	private String birthdate;
	
	private String client;
	
	private String clientid;
	
	private String status;
	
	private String submtby;
	
	private String api_stat;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getCaseid()
	{
		return caseid;
	}

	public void setCaseid(String caseid)
	{
		this.caseid = caseid;
	}

	public String getCandidate()
	{
		return candidate;
	}

	public void setCandidate(String candidate)
	{
		this.candidate = candidate;
	}

	public String getEmployeeid()
	{
		return employeeid;
	}

	public void setEmployeeid(String employeeid)
	{
		this.employeeid = employeeid;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getBirthdate()
	{
		return birthdate;
	}

	public void setBirthdate(String birthdate)
	{
		this.birthdate = birthdate;
	}

	public String getClient()
	{
		return client;
	}

	public void setClient(String client)
	{
		this.client = client;
	}

	public String getClientid()
	{
		return clientid;
	}

	public void setClientid(String clientid)
	{
		this.clientid = clientid;
	}
	
	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getSubmtby()
	{
		return submtby;
	}

	public void setSubmtby(String submtby)
	{
		this.submtby = submtby;
	}

	public String getApi_stat()
	{
		return api_stat;
	}

	public void setApi_stat(String api_stat)
	{
		this.api_stat = api_stat;
	}

	@Override
	public String toString()
	{
		return "ActCandidateDetailsDTO [id=" + id + ", caseid=" + caseid
				+ ", candidate=" + candidate + ", employeeid=" + employeeid
				+ ", email=" + email + ", birthdate=" + birthdate + ", client="
				+ client + ", submtby=" + submtby + ", clientid=" + clientid
				+ ", api_stat=" + api_stat + "]";
	}
	
	

}
