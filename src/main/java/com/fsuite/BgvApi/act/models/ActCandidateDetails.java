/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.act.models;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;

import com.fsuite.BgvApi.constants.SequenceConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cv_candidates")
public class ActCandidateDetails implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = SequenceConstants.NATIVE)
	@GenericGenerator(name = SequenceConstants.NATIVE, strategy = SequenceConstants.NATIVE)
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "caseid")
	private String caseid;
	
	@Column(name = "candidate")
	private String candidate;
	
	@Column(name = "employeeid")
	private String employeeid;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birthdate")
	private String birthdate;
	
	@Column(name = "client")
	private String client;
	
	@Column(name = "clientid")
	private String clientid;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "submtby")
	private String submtby;
	
	@Column(name = "api_stat")
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
		return "ActCandidateDetails [id=" + id + ", caseid=" + caseid
				+ ", candidate=" + candidate + ", employeeid=" + employeeid
				+ ", email=" + email + ", birthdate=" + birthdate + ", client="
				+ client + ", clientid=" + clientid + ", api_stat=" + api_stat
				+ "]";
	}
	
}
