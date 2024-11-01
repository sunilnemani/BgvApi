/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.keka.dto;

import java.util.List;

public class KekaBgvDetailsResponseDTO
{
	
	private boolean succeeded;
	
    private String message;
    
    private List<String> errors;
    
    private KekaCandidateDetailsDTO data;
    
    
	public boolean isSucceeded()
	{
		return succeeded;
	}

	public void setSucceeded(boolean succeeded)
	{
		this.succeeded = succeeded;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public List<String> getErrors()
	{
		return errors;
	}

	public void setErrors(List<String> errors)
	{
		this.errors = errors;
	}

	public KekaCandidateDetailsDTO getData()
	{
		return data;
	}

	public void setData(KekaCandidateDetailsDTO data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return "KekaBgvDetailsResponseDTO [succeeded=" + succeeded
				+ ", message=" + message + ", errors=" + errors + ", data="
				+ data + "]";
	}
	
}
