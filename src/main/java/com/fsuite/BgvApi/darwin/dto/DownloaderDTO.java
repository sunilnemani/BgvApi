/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.darwin.dto;

public class DownloaderDTO
{

	private String api_key;
	
	private String file_key;
	
	// File Downloader res
	private Integer status;
	
	private String message;
	
	private String file;

	public String getApi_key()
	{
		return api_key;
	}

	public void setApi_key(String api_key)
	{
		this.api_key = api_key;
	}

	public String getFile_key()
	{
		return file_key;
	}

	public void setFile_key(String file_key)
	{
		this.file_key = file_key;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getFile()
	{
		return file;
	}

	public void setFile(String file)
	{
		this.file = file;
	}

	@Override
	public String toString()
	{
		return "DownloaderRequestDTO [api_key=" + api_key + ", file_key="
				+ file_key + ", status=" + status + ", message=" + message
				+ ", file=" + file + "]";
	}
}
