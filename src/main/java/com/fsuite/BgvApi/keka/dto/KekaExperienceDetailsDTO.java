/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.keka.dto;

public class KekaExperienceDetailsDTO
{

	private String id;
	
	private String companyName;
	
	private String jobTitle;
	
	private String location;
	
	private String description;
	
	private String dateOfJoining;
	
	private String dateOfRelieving;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getJobTitle()
	{
		return jobTitle;
	}

	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDateOfJoining()
	{
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining)
	{
		this.dateOfJoining = dateOfJoining;
	}

	public String getDateOfRelieving()
	{
		return dateOfRelieving;
	}

	public void setDateOfRelieving(String dateOfRelieving)
	{
		this.dateOfRelieving = dateOfRelieving;
	}

	@Override
	public String toString()
	{
		return "KekaExperienceDetailsDTO [id=" + id + ", companyName="
				+ companyName + ", jobTitle=" + jobTitle + ", location="
				+ location + ", description=" + description + ", dateOfJoining="
				+ dateOfJoining + ", dateOfRelieving=" + dateOfRelieving + "]";
	}
	
	
}
