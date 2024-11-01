/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.keka.dto;

import java.util.Map;

public class KekaImageDTO
{
	
	private String fileName;
	
    private Map<String, String> thumbs;

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public Map<String, String> getThumbs()
	{
		return thumbs;
	}

	public void setThumbs(Map<String, String> thumbs)
	{
		this.thumbs = thumbs;
	}

	@Override
	public String toString()
	{
		return "KekaImageDTO [fileName=" + fileName + ", thumbs=" + thumbs
				+ "]";
	}
    
}
