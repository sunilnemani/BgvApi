/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.darwin.dto;

public class DependentDetailsDTO
{
	
	private String dependent_first_name;
	
    private String dependent_middle_name;
    
    private String dependent_last_name;
    
    private String dependent_relation_type;
    
    private String dependent_dob;
    
    private String dependent_contact_details;
    
    private String dependent_nominated_for;
    
    private String dependent_phone_country_code;
    
    private String dependent_phone;
    
    private String dependent_nationality;
    
    private String updated_on;

	public String getDependent_first_name()
	{
		return dependent_first_name;
	}

	public void setDependent_first_name(String dependent_first_name)
	{
		this.dependent_first_name = dependent_first_name;
	}

	public String getDependent_middle_name()
	{
		return dependent_middle_name;
	}

	public void setDependent_middle_name(String dependent_middle_name)
	{
		this.dependent_middle_name = dependent_middle_name;
	}

	public String getDependent_last_name()
	{
		return dependent_last_name;
	}

	public void setDependent_last_name(String dependent_last_name)
	{
		this.dependent_last_name = dependent_last_name;
	}

	public String getDependent_relation_type()
	{
		return dependent_relation_type;
	}

	public void setDependent_relation_type(String dependent_relation_type)
	{
		this.dependent_relation_type = dependent_relation_type;
	}

	public String getDependent_dob()
	{
		return dependent_dob;
	}

	public void setDependent_dob(String dependent_dob)
	{
		this.dependent_dob = dependent_dob;
	}

	public String getDependent_contact_details()
	{
		return dependent_contact_details;
	}

	public void setDependent_contact_details(String dependent_contact_details)
	{
		this.dependent_contact_details = dependent_contact_details;
	}

	public String getDependent_nominated_for()
	{
		return dependent_nominated_for;
	}

	public void setDependent_nominated_for(String dependent_nominated_for)
	{
		this.dependent_nominated_for = dependent_nominated_for;
	}

	public String getDependent_phone_country_code()
	{
		return dependent_phone_country_code;
	}

	public void setDependent_phone_country_code(String dependent_phone_country_code)
	{
		this.dependent_phone_country_code = dependent_phone_country_code;
	}

	public String getDependent_phone()
	{
		return dependent_phone;
	}

	public void setDependent_phone(String dependent_phone)
	{
		this.dependent_phone = dependent_phone;
	}

	public String getDependent_nationality()
	{
		return dependent_nationality;
	}

	public void setDependent_nationality(String dependent_nationality)
	{
		this.dependent_nationality = dependent_nationality;
	}

	public String getUpdated_on()
	{
		return updated_on;
	}

	public void setUpdated_on(String updated_on)
	{
		this.updated_on = updated_on;
	}

	@Override
	public String toString()
	{
		return "DependentDetails [dependent_first_name=" + dependent_first_name
				+ ", dependent_middle_name=" + dependent_middle_name
				+ ", dependent_last_name=" + dependent_last_name
				+ ", dependent_relation_type=" + dependent_relation_type
				+ ", dependent_dob=" + dependent_dob
				+ ", dependent_contact_details=" + dependent_contact_details
				+ ", dependent_nominated_for=" + dependent_nominated_for
				+ ", dependent_phone_country_code="
				+ dependent_phone_country_code + ", dependent_phone="
				+ dependent_phone + ", dependent_nationality="
				+ dependent_nationality + ", updated_on=" + updated_on + "]";
	}
    
    

}
