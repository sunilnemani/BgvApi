/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.darwin.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fsuite.BgvApi.dto.BaseDTO;

public class CandidateDataDTO implements BaseDTO
{
	
	private static final String CASE_ID = "caseId";
	private static final String CLIENT_ID = "clientId";
	private static final String FILE_NAME = "fileName";	
	
	private Integer case_id;
	
	private String unique_id;
	
	private String bgv_id;
	
	private String api_key;
	
    private String candidate_id;
    
    private String employee_id;
    
    private String employee_status;
    
    private String client_id;
    
    private String password;
    
    private String details_url;
    
    private String downloadUrl;
    
    private String verification_url;
    
    private String auth_username;
    
	private String auth_password;
    
    private Integer retry_count;
    
    private String status;
    
    private Date operation_time;
    
    private BgvFormDataDTO bgv_form_data;
    

    //
    private String fileName;
	

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
	
	public String getClient_id()
	{
		return client_id;
	}

	public void setClient_id(String client_id)
	{
		this.client_id = client_id;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmployee_status()
	{
		return employee_status;
	}

	public void setEmployee_status(String employee_status)
	{
		this.employee_status = employee_status;
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

	public BgvFormDataDTO getBgv_form_data()
	{
		return bgv_form_data;
	}

	public void setBgv_form_data(BgvFormDataDTO bgv_form_data)
	{
		this.bgv_form_data = bgv_form_data;
	}

	//
	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	@Override
	public String toString()
	{
		return "CandidateDataDTO [case_id=" + case_id + ", unique_id="
				+ unique_id + ", bgv_id=" + bgv_id + ", api_key=" + api_key
				+ ", candidate_id=" + candidate_id + ", employee_id="
				+ employee_id + ", employee_status=" + employee_status
				+ ", client_id=" + client_id + ", password=" + password
				+ ", details_url=" + details_url + ", downloadUrl="
				+ downloadUrl + ", verification_url=" + verification_url
				+ ", auth_username=" + auth_username + ", auth_password="
				+ auth_password + ", retry_count=" + retry_count + ", status="
				+ status + ", operation_time=" + operation_time
				+ ", bgv_form_data=" + bgv_form_data + "]";
	}

	@Override
	public Map<String, String> processVariables()
	{
		Map<String,	String> map = new HashMap<String, String>();
		map.put(CASE_ID, unique_id);
		map.put(CLIENT_ID, client_id);
		map.put(FILE_NAME, fileName);
		return map;
	}

}
