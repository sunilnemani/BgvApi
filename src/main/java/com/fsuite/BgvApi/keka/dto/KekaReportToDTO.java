/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.keka.dto;

public class KekaReportToDTO
{
	
	private String id;
	
	private String firstName;
	
	private String secondName;
	
	private String email;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getSecondName()
	{
		return secondName;
	}

	public void setSecondName(String secondName)
	{
		this.secondName = secondName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "KekaReportToDTO [id=" + id + ", firstName=" + firstName
				+ ", secondName=" + secondName + ", email=" + email + "]";
	}
	
}
