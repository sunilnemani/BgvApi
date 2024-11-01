/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.darwin.dto;

public class VisaDetailsDTO
{
	
	private String visa_country;
	
    private String visa_type;
    
    private String visa_no;
    
    private String visa_issue_date;
    
    private String visa_valid_till;

	public String getVisa_country()
	{
		return visa_country;
	}

	public void setVisa_country(String visa_country)
	{
		this.visa_country = visa_country;
	}

	public String getVisa_type()
	{
		return visa_type;
	}

	public void setVisa_type(String visa_type)
	{
		this.visa_type = visa_type;
	}

	public String getVisa_no()
	{
		return visa_no;
	}

	public void setVisa_no(String visa_no)
	{
		this.visa_no = visa_no;
	}

	public String getVisa_issue_date()
	{
		return visa_issue_date;
	}

	public void setVisa_issue_date(String visa_issue_date)
	{
		this.visa_issue_date = visa_issue_date;
	}

	public String getVisa_valid_till()
	{
		return visa_valid_till;
	}

	public void setVisa_valid_till(String visa_valid_till)
	{
		this.visa_valid_till = visa_valid_till;
	}

	@Override
	public String toString()
	{
		return "VisaDetails [visa_country=" + visa_country + ", visa_type="
				+ visa_type + ", visa_no=" + visa_no + ", visa_issue_date="
				+ visa_issue_date + ", visa_valid_till=" + visa_valid_till
				+ "]";
	}
    
	
    
}
