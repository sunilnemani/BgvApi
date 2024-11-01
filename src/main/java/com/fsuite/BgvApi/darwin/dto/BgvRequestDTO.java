/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.darwin.dto;

public class BgvRequestDTO
{
	
	private String api_key;
	
    private String bgv_id;
    
    private String unique_id;
    
    private String application_form_updated_from;
    
    private String application_form_updated_to;
    
    private String bgv_status;
    
    private String employee_status;
    
    private String get_all_bgv_approved_list;
    
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

	public String getApplication_form_updated_from()
	{
		return application_form_updated_from;
	}

	public void setApplication_form_updated_from(
			String application_form_updated_from)
	{
		this.application_form_updated_from = application_form_updated_from;
	}

	public String getApplication_form_updated_to()
	{
		return application_form_updated_to;
	}

	public void setApplication_form_updated_to(String application_form_updated_to)
	{
		this.application_form_updated_to = application_form_updated_to;
	}

	public String getBgv_status()
	{
		return bgv_status;
	}

	public void setBgv_status(String bgv_status)
	{
		this.bgv_status = bgv_status;
	}

	public String getEmployee_status()
	{
		return employee_status;
	}

	public void setEmployee_status(String employee_status)
	{
		this.employee_status = employee_status;
	}

	public String getGet_all_bgv_approved_list()
	{
		return get_all_bgv_approved_list;
	}

	public void setGet_all_bgv_approved_list(String get_all_bgv_approved_list)
	{
		this.get_all_bgv_approved_list = get_all_bgv_approved_list;
	}

	@Override
	public String toString()
	{
		return "BgvRequest [api_key=" + api_key + ", bgv_id=" + bgv_id
				+ ", unique_id=" + unique_id
				+ ", application_form_updated_from="
				+ application_form_updated_from
				+ ", application_form_updated_to=" + application_form_updated_to
				+ ", bgv_status=" + bgv_status + ", employee_status="
				+ employee_status + ", get_all_bgv_approved_list="
				+ get_all_bgv_approved_list + "]";
	}
	

}
