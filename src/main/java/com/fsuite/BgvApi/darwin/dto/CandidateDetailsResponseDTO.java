/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.darwin.dto;

public class CandidateDetailsResponseDTO
{
	private int status;
    private String message;
    private CandidateDataDTO candidate_data;
    
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
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
	public CandidateDataDTO getCandidate_data()
	{
		return candidate_data;
	}
	public void setCandidate_data(CandidateDataDTO candidate_data)
	{
		this.candidate_data = candidate_data;
	}
	@Override
	public String toString()
	{
		return "CandidateData [status=" + status + ", message=" + message
				+ ", candidate_data=" + candidate_data + "]";
	}

    
}
