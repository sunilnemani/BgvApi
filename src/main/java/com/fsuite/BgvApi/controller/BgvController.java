/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsuite.BgvApi.constants.AppExceptionConstants;
import com.fsuite.BgvApi.constants.PathConstants;
import com.fsuite.BgvApi.darwin.dto.CandidateDataDTO;
import com.fsuite.BgvApi.darwin.dto.DarwinBgvClientRequestDTO;
import com.fsuite.BgvApi.dto.BaseResponseDTO;
import com.fsuite.BgvApi.exception.AppException;
import com.fsuite.BgvApi.keka.dto.KekaBgvClientRequestDTO;
import com.fsuite.BgvApi.service.IBgvService;
import com.fsuite.BgvApi.utils.Commons;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = PathConstants.BGV)
public class BgvController
{
	
	private static final Logger log=LoggerFactory.getLogger(BgvController.class);
	
	@Autowired
	private IBgvService iBgvService;
	
	@RequestMapping(value = PathConstants.LOAD_CAND_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO loadCanditateList(HttpServletRequest request, @RequestBody DarwinBgvClientRequestDTO bgvClientRequest)
	{
		log.info("[BgvController][loadCanditateList] "+bgvClientRequest.toString());
		BaseResponseDTO resp=null;
		try
		{
			resp=this.iBgvService.loadCanditateList(bgvClientRequest);
		}
		catch(AppException e)
		{
			log.error("[BgvController][loadCanditateList] ",e);
			resp = Commons.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, e.getErrMsg());
		}
		catch(Exception e)
		{
			log.error("[BgvController][loadCanditateList] ",e);
			resp = Commons.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, "Internal Server Error.");
		}
		return resp;
	}
	
	@RequestMapping(value = PathConstants.REQ_CANDIDATE_VERIFICATION, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO addCandidateDetails(HttpServletRequest request, @RequestBody CandidateDataDTO candidateDataDTO, @RequestParam(name = "unique_id") String unique_id, @RequestParam(name = "client_id") String client_id)
	{
		BaseResponseDTO resp=null;
		try
		{
			if(candidateDataDTO!=null)
			{
				log.info("[BgvController][addCandidateDetails] - "+candidateDataDTO.toString());
				if(unique_id!=null && !unique_id.isEmpty())
				{
					candidateDataDTO.setUnique_id(unique_id);
				}
				if(client_id!=null && !client_id.isEmpty())
				{
					candidateDataDTO.setClient_id(client_id);
				}
				if(candidateDataDTO.getUnique_id()==null || candidateDataDTO.getUnique_id().isEmpty())
				{
					throw new AppException(BaseResponseDTO.FAILURE_STATUS, "Unique ID Cannot be Empty.");
				}
				else if(candidateDataDTO.getClient_id()==null || candidateDataDTO.getClient_id().isEmpty() || candidateDataDTO.getPassword()==null || candidateDataDTO.getPassword().isEmpty())
				{
					throw new AppException(BaseResponseDTO.FAILURE_STATUS, "Client ID or Password Cannot be Empty.");
				}
				else
				{
					resp=this.iBgvService.addCandidateDetails(candidateDataDTO);
				}
			}
			else
			{
				throw new AppException(BaseResponseDTO.FAILURE_STATUS, "Insufficient Data");
			}
		}
		catch(AppException e)
		{
			log.error("[BgvController][addCandidateDetails] ",e);
			resp = Commons.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, e.getErrMsg());
		}
		catch(Exception e)
		{
			log.error("[BgvController][addCandidateDetails] ",e);
			resp = Commons.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, "Internal Server Error.");
		}
		return resp;
	}
	
	@RequestMapping(value = PathConstants.LOAD_CANDIDATE_DETAILS_FOR_KEKA, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO loadCandidateDetailsForKeka(@RequestBody KekaBgvClientRequestDTO kekaRequestDTO)
	{
		BaseResponseDTO resp = null;
		try
		{
			if(kekaRequestDTO!=null)
			{
				if(kekaRequestDTO.getTokenUrl()==null || kekaRequestDTO.getTokenUrl().isEmpty())
				{
					throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.ERR_TOKEN_URL_CANNOT_BE_EMPTY);
				}
				else if(kekaRequestDTO.getDetailsUrl()==null || kekaRequestDTO.getDetailsUrl().isEmpty())
				{
					throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.ERR_DETAIL_URL_CANNOT_BE_EMPTY);
				}
				else if(kekaRequestDTO.getBgvClientId()==null || kekaRequestDTO.getBgvClientId().isEmpty())
				{
					throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.ERR_BGV_CLIENT_ID_CANNOT_BE_EMPTY);
				}
				else if(kekaRequestDTO.getBgvPassword()==null || kekaRequestDTO.getBgvPassword().isEmpty())
				{
					throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.ERR_BGV_PASSWORD_CANNOT_BE_EMPTY);
				}
				else if(kekaRequestDTO.getKekaClientId()==null || kekaRequestDTO.getKekaClientId().isEmpty())
				{
					throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.ERR_KEKA_CLIENT_ID_CANNOT_BE_EMPTY);
				}
				else if(kekaRequestDTO.getKekaClientSecret()==null || kekaRequestDTO.getKekaClientSecret().isEmpty())
				{
					throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.ERR_KEKA_CLIENT_SECRET_KEY_CANNOT_BE_EMPTY);
				}
				else if(kekaRequestDTO.getApiKey()==null || kekaRequestDTO.getApiKey().isEmpty())
				{
					throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.ERR_KEKA_API_KEY);
				}
				else
				{
					resp = this.iBgvService.loadCandidateDetailsForKeka(kekaRequestDTO);
				}
			}
			else
			{
				throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.INVALID_DATA);
			}
		}
		catch(AppException e)
		{
			log.error("[BgvController][addCandidateDetails] ",e);
			resp = Commons.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, e.getErrMsg());
		}
		catch(Exception e)
		{
			log.error("[BgvController][addCandidateDetails] ",e);
			resp = Commons.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, "Internal Server Error.");
		}
		return resp;
	}
	
}
