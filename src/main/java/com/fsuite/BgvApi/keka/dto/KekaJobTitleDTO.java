/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.keka.dto;

public class KekaJobTitleDTO
{
	
	private String identifier;
	
	private String title;

	public String getIdentifier()
	{
		return identifier;
	}

	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	@Override
	public String toString()
	{
		return "KekaJobTitleDTO [identifier=" + identifier + ", title=" + title
				+ "]";
	}
	
	

}
