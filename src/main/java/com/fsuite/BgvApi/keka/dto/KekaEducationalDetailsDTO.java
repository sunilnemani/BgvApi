/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.keka.dto;

public class KekaEducationalDetailsDTO
{
	
	private String id;
	
	private String degree;
	
	private String branch;
	
	private String university;
	
	private Integer cgpa;
	
	private String yearOfJoining;
	
	private String yearOfCompletion;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getDegree()
	{
		return degree;
	}

	public void setDegree(String degree)
	{
		this.degree = degree;
	}

	public String getBranch()
	{
		return branch;
	}

	public void setBranch(String branch)
	{
		this.branch = branch;
	}

	public String getUniversity()
	{
		return university;
	}

	public void setUniversity(String university)
	{
		this.university = university;
	}

	public Integer getCgpa()
	{
		return cgpa;
	}

	public void setCgpa(Integer cgpa)
	{
		this.cgpa = cgpa;
	}

	public String getYearOfJoining()
	{
		return yearOfJoining;
	}

	public void setYearOfJoining(String yearOfJoining)
	{
		this.yearOfJoining = yearOfJoining;
	}

	public String getYearOfCompletion()
	{
		return yearOfCompletion;
	}

	public void setYearOfCompletion(String yearOfCompletion)
	{
		this.yearOfCompletion = yearOfCompletion;
	}

	@Override
	public String toString()
	{
		return "KekaEducationalDetailsDTO [id=" + id + ", degree=" + degree
				+ ", branch=" + branch + ", university=" + university
				+ ", cgpa=" + cgpa + ", yearOfJoining=" + yearOfJoining
				+ ", yearOfCompletion=" + yearOfCompletion + "]";
	}
	
}
