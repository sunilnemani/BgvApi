/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.service;

import java.security.NoSuchAlgorithmException;

import com.fsuite.BgvApi.darwin.dto.CandidateDataDTO;
import com.fsuite.BgvApi.darwin.dto.DarwinBgvClientRequestDTO;
import com.fsuite.BgvApi.dto.BaseResponseDTO;
import com.fsuite.BgvApi.keka.dto.KekaBgvClientRequestDTO;

public interface IBgvService
{

	public BaseResponseDTO loadCanditateList(DarwinBgvClientRequestDTO bgvClientRequest);
	
	public void loadCanditateDetails();

	public BaseResponseDTO addCandidateDetails(CandidateDataDTO candidateDataDTO) throws NoSuchAlgorithmException;
	
	public void sendProcessStatus();

	public BaseResponseDTO loadCandidateDetailsForKeka(KekaBgvClientRequestDTO kekaRequestDTO);
	
}
