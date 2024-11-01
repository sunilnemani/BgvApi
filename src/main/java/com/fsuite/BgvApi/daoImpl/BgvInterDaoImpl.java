/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.daoImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fsuite.BgvApi.dao.IBgvInterDao;
import com.fsuite.BgvApi.darwin.dto.AddressDetailsDTO;
import com.fsuite.BgvApi.darwin.dto.BgvFormDataDTO;
import com.fsuite.BgvApi.darwin.dto.CandidateDataDTO;
import com.fsuite.BgvApi.darwin.dto.EducationDetailsDTO;
import com.fsuite.BgvApi.darwin.dto.PastWorkExperienceDTO;
import com.fsuite.BgvApi.dto.SettingsDTO;
import com.fsuite.BgvApi.inter.models.AddressDetails;
import com.fsuite.BgvApi.inter.models.BgvFormData;
import com.fsuite.BgvApi.inter.models.CandidateData;
import com.fsuite.BgvApi.inter.models.EducationDetails;
import com.fsuite.BgvApi.inter.models.PastWorkExperience;

import jakarta.persistence.TypedQuery;

@Repository
public class BgvInterDaoImpl extends BaseDAO implements IBgvInterDao
{
	private static final Logger log = LoggerFactory.getLogger(BgvInterDaoImpl.class);
	
	private static final String GET_CAND_LIST = "select cand from CandidateData cand where status='P' and retry_count<:retryCount";
	private static final String GET_CANDIDATE_DETAILS="select cand from CandidateData cand where cand.unique_id=:uniqueId and cand.client_id=:clientId";
	
	@Autowired
	private SettingsDTO settingDTO;
	
	public void addCandidateData(CandidateDataDTO candidateDataDto)
	{
		log.info("[BgvDaoImpl][addCandidateData]");
		CandidateData data = this.copyProperties(CandidateData.class, candidateDataDto);
		this.interManager.persist(data);
		candidateDataDto.setCase_id(data.getCase_id());
	}

	@Override
	public List<CandidateDataDTO> getPendingCanditateList()
	{
		TypedQuery<CandidateData> typedQuery= this.interManager.createQuery(GET_CAND_LIST, CandidateData.class).setParameter("retryCount", settingDTO.getRetryCount()).setMaxResults(settingDTO.getBatchSize());
		return toList(typedQuery.getResultList(), CandidateDataDTO.class);
	}
	
	@Override
	public void updateCandidateData(CandidateDataDTO canditateData)
	{
		CandidateData data=this.copyProperties(CandidateData.class, canditateData);
		this.interManager.merge(data);
	}
	
	@Override
	public void addBgvFormData(BgvFormDataDTO bgvFormDataDTO)
	{
		BgvFormData data = this.copyProperties(BgvFormData.class, bgvFormDataDTO);
		this.interManager.persist(data);
		bgvFormDataDTO.setId(data.getId());
	}
	
	@Override
	public void addEducationDetails(EducationDetailsDTO educationDetailsDTO)
	{
		EducationDetails educationDetails = this.copyProperties(EducationDetails.class, educationDetailsDTO);
		this.interManager.persist(educationDetails);
		educationDetailsDTO.setId(educationDetails.getId());
	}

	@Override
	public void addPastWorkingDetails(PastWorkExperienceDTO pastWorkingExp)
	{
		PastWorkExperience data = this.copyProperties(PastWorkExperience.class, pastWorkingExp);
		this.interManager.persist(data);
		pastWorkingExp.setId(data.getId());
		
	}

	@Override
	public void addAddressDetails(AddressDetailsDTO addressDetailsDTO)
	{
		
		AddressDetails data = this.copyProperties(AddressDetails.class, addressDetailsDTO);
		this.interManager.persist(data);
		addressDetailsDTO.setId(data.getId());
	}
	
	@Override
	public CandidateDataDTO getCandidateData(String unique_id, String clientId)
	{
		TypedQuery<CandidateData> typedQuery= this.interManager.createQuery(GET_CANDIDATE_DETAILS, CandidateData.class).setParameter("uniqueId", unique_id).setParameter("clientId", clientId);
		return this.copyProperties(CandidateDataDTO.class, this.getCustomSingleResult(typedQuery));
	}
	
}
