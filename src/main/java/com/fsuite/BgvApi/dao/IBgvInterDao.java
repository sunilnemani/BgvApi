/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.dao;

import java.util.List;

import com.fsuite.BgvApi.darwin.dto.AddressDetailsDTO;
import com.fsuite.BgvApi.darwin.dto.BgvFormDataDTO;
import com.fsuite.BgvApi.darwin.dto.CandidateDataDTO;
import com.fsuite.BgvApi.darwin.dto.EducationDetailsDTO;
import com.fsuite.BgvApi.darwin.dto.PastWorkExperienceDTO;

public interface IBgvInterDao
{
	
	public void addCandidateData(CandidateDataDTO candidateData);
	
	public List<CandidateDataDTO> getPendingCanditateList();
	
	public void updateCandidateData(CandidateDataDTO canditateData);
	
	public void addBgvFormData(BgvFormDataDTO bgvFormDataDTO);
	
	public void addEducationDetails(EducationDetailsDTO educationDetailsDTO);
	
	public void addPastWorkingDetails(PastWorkExperienceDTO pastWorkingDetails);
	
	public void addAddressDetails(AddressDetailsDTO addressDetailsDTO);
	
	public CandidateDataDTO getCandidateData(String unique_id, String clientId);

}
