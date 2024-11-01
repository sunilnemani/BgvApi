/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fsuite.BgvApi.act.dto.ActCandidateDetailsDTO;
import com.fsuite.BgvApi.act.dto.ClientDetailsDTO;
import com.fsuite.BgvApi.act.models.ActCandidateDetails;
import com.fsuite.BgvApi.act.models.ClientDetails;
import com.fsuite.BgvApi.dao.IBgvActDao;
import com.fsuite.BgvApi.dto.SettingsDTO;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class BgvActDaoImpl extends BaseDAO implements IBgvActDao
{
	
	private static final String GET_CLIENT_DETAILS = "select client from ClientDetails client where clientId=:clientId";
	private static final String GET_PROCESSED_CANDIDATE_LIST="select act from ActCandidateDetails act where api_stat='N' and (status='Verified Clear' or status='Unable To Verify' or status='Closed Insufficiency' or status='Verified Discrepancy' or status='Stop Check') and submtby='API'";

	@Autowired
	private SettingsDTO settingDTO;
	
	@Override
	public ClientDetailsDTO getClientDetails(String client_id)
	{
		TypedQuery<ClientDetails> query = this.actManager.createQuery(GET_CLIENT_DETAILS, ClientDetails.class).setParameter("clientId", client_id);
		return this.copyPropertiesWithNullCheck(ClientDetailsDTO.class, this.getCustomSingleResult(query));
	}

	@Override
	public List<ActCandidateDetailsDTO> getProcessedList()
	{
		TypedQuery<ActCandidateDetails> query = this.actManager.createQuery(GET_PROCESSED_CANDIDATE_LIST, ActCandidateDetails.class).setMaxResults(settingDTO.getBatchSize());
		return this.toList(query.getResultList(), ActCandidateDetailsDTO.class);
	}

	@Override
	public void updateProcessedStatus(ActCandidateDetailsDTO actCandDetails)
	{
		actManager.joinTransaction();
		String queryStr = "update ActCandidateDetails act set act.api_stat=:stat where act.id=:id";
		Query query=this.actManager.createQuery(queryStr).setParameter("id", actCandDetails.getId()).setParameter("stat", actCandDetails.getApi_stat());
		query.executeUpdate();
	}
	
}
