/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.dao;

import java.util.List;

import com.fsuite.BgvApi.act.dto.ActCandidateDetailsDTO;
import com.fsuite.BgvApi.act.dto.ClientDetailsDTO;

public interface IBgvActDao
{
	
	public ClientDetailsDTO getClientDetails(String client_id);

	public List<ActCandidateDetailsDTO> getProcessedList();
	
	public void updateProcessedStatus(ActCandidateDetailsDTO actCandDetails);

}
