/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.inter.models;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import com.fsuite.BgvApi.constants.SequenceConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//import com.fsuite.BgvApi.dto.BgvFormData;


@Entity
@Table(name="cand_data")
public class CandidateData implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = SequenceConstants.NATIVE)
	@GenericGenerator(name = SequenceConstants.NATIVE, strategy = SequenceConstants.NATIVE)
	@Id
	@Column(name = "case_id")
	private Integer case_id;
	
	@Column(name = "unique_id")
	private String unique_id;
	
	@Column(name = "bgv_id")
	private String bgv_id;
	
	@Column(name = "api_key")
	private String api_key;
	
	@Column(name = "candidate_id")
	private String candidate_id;
	
	@Column(name = "employee_id")
	private String employee_id;
	
	@Column(name = "employee_status")
    private String employee_status;
	
	@Column(name = "client_id")
	private String client_id;
	
	@Column(name = "details_url")
	private String details_url;
	
	@Column(name = "download_url")
	private String downloadUrl;
    
	@Column(name = "verification_url")
    private String verification_url;
    
	@Column(name = "auth_username")
    private String auth_username;
    
	@Column(name = "auth_password")
	private String auth_password;
	
	@Column(name = "retry_count")
	private Integer retry_count;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "operation_time")
	private Date operation_time;

	public Integer getCase_id()
	{
		return case_id;
	}

	public void setCase_id(Integer case_id)
	{
		this.case_id = case_id;
	}

	public String getUnique_id()
	{
		return unique_id;
	}

	public void setUnique_id(String unique_id)
	{
		this.unique_id = unique_id;
	}

	public String getBgv_id()
	{
		return bgv_id;
	}

	public void setBgv_id(String bgv_id)
	{
		this.bgv_id = bgv_id;
	}
	
	public String getApi_key()
	{
		return api_key;
	}

	public void setApi_key(String api_key)
	{
		this.api_key = api_key;
	}

	public String getCandidate_id()
	{
		return candidate_id;
	}

	public void setCandidate_id(String candidate_id)
	{
		this.candidate_id = candidate_id;
	}

	public String getEmployee_id()
	{
		return employee_id;
	}

	public void setEmployee_id(String employee_id)
	{
		this.employee_id = employee_id;
	}

	public String getEmployee_status()
	{
		return employee_status;
	}

	public void setEmployee_status(String employee_status)
	{
		this.employee_status = employee_status;
	}

	public String getClient_id()
	{
		return client_id;
	}

	public void setClient_id(String client_id)
	{
		this.client_id = client_id;
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

	public Integer getRetry_count()
	{
		return retry_count;
	}

	public void setRetry_count(Integer retry_count)
	{
		this.retry_count = retry_count;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public Date getOperation_time()
	{
		return operation_time;
	}

	public void setOperation_time(Date operation_time)
	{
		this.operation_time = operation_time;
	}

	@Override
	public String toString()
	{
		return "CandidateData [case_id=" + case_id + ", unique_id=" + unique_id
				+ ", candidate_id=" + candidate_id + ", employee_id="
				+ employee_id + ", employee_status=" + employee_status
				+ ", client_id=" + client_id + ", details_url=" + details_url
				+ ", status=" + status + "]";
	}
    
}
