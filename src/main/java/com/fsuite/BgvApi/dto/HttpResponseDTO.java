package com.fsuite.BgvApi.dto;

public class HttpResponseDTO
{
	public static final String ERR_SOCKET_TIMEOUT = "ERR_SOCKET_TIMEOUT";
	public static final String ERR_CONNECT_TIMEOUT = "ERR_CONNECT_TIMEOUT";
	public static final String ERR_POSTING_REQUEST = "ERR_POSTING_REQUEST";
	public static final String REQUEST_SUCCESS = "00";
	public static final int HTTP_SUCCESS = 200;
	private String responseCode;
	private String responseXml;
	private int responseStatus;

	public String getResponseCode()
	{
		return responseCode;
	}
	public void setResponseCode(String responseCode)
	{
		this.responseCode = responseCode;
	}
	public String getResponseXml()
	{
		return responseXml;
	}
	public void setResponseXml(String responseXml)
	{
		this.responseXml = responseXml;
	}

	public int getResponseStatus()
	{
		return responseStatus;
	}
	public void setResponseStatus(int responseStatus)
	{
		this.responseStatus = responseStatus;
	}
	public boolean isSuccess()
	{
		return responseCode == null ? false : responseCode.equalsIgnoreCase(REQUEST_SUCCESS);
	}

	public boolean isHttpSuccess()
	{
		return responseStatus == HTTP_SUCCESS;
	}

}
