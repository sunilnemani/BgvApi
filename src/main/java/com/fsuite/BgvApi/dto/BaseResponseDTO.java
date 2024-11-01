package com.fsuite.BgvApi.dto;

public class BaseResponseDTO
{

	public static final String SUCCESS_STATUS = "0";
	public static final String FAILURE_STATUS = "1";
	public static final int SESSION_EXPIRED = 1;

	private String status;
	private String respCode;
	private String respMessage;

	public BaseResponseDTO()
	{
		super();
	}

	public BaseResponseDTO(String status, String respCode, String respMessage)
	{
		super();
		this.status = status;
		this.respCode = respCode;
		this.respMessage = respMessage;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getRespCode()
	{
		return respCode;
	}

	public void setRespCode(String respCode)
	{
		this.respCode = respCode;
	}

	public String getRespMessage()
	{
		return respMessage;
	}

	public void setRespMessage(String respMessage)
	{
		this.respMessage = respMessage;
	}

	@Override
	public String toString()
	{
		return "BaseResponseDTO [status=" + status + ", respCode=" + respCode
				+ ", respMessage=" + respMessage + "]";
	}

	public boolean isSuccess()
	{
		return this.status == null ? false : this.status.equals(SUCCESS_STATUS);
	}
}
