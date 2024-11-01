/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsuite.BgvApi.act.dto.ActCandidateDetailsDTO;
import com.fsuite.BgvApi.act.dto.ClientDetailsDTO;
import com.fsuite.BgvApi.configs.RestClient;
import com.fsuite.BgvApi.constants.AppConstants;
import com.fsuite.BgvApi.constants.AppExceptionConstants;
import com.fsuite.BgvApi.dao.IBgvActDao;
import com.fsuite.BgvApi.dao.IBgvInterDao;
import com.fsuite.BgvApi.darwin.dto.AddressDetailsDTO;
import com.fsuite.BgvApi.darwin.dto.BgvFormDataDTO;
import com.fsuite.BgvApi.darwin.dto.BgvRequestDTO;
import com.fsuite.BgvApi.darwin.dto.BgvVerificationRequestDTO;
import com.fsuite.BgvApi.darwin.dto.BgvVerirficationResponseDTO;
import com.fsuite.BgvApi.darwin.dto.CandidateDataDTO;
import com.fsuite.BgvApi.darwin.dto.CandidateDetailsResponseDTO;
import com.fsuite.BgvApi.darwin.dto.CandidatesDataResponseDTO;
import com.fsuite.BgvApi.darwin.dto.ContactDetailsDTO;
import com.fsuite.BgvApi.darwin.dto.DarwinBgvClientRequestDTO;
import com.fsuite.BgvApi.darwin.dto.DownloaderDTO;
import com.fsuite.BgvApi.darwin.dto.EducationDetailsDTO;
import com.fsuite.BgvApi.darwin.dto.PastWorkExperienceDTO;
import com.fsuite.BgvApi.dto.BaseResponseDTO;
import com.fsuite.BgvApi.dto.HttpResponseDTO;
import com.fsuite.BgvApi.dto.SettingsDTO;
import com.fsuite.BgvApi.exception.AppException;
import com.fsuite.BgvApi.keka.dto.KekaAddressDetailsDTO;
import com.fsuite.BgvApi.keka.dto.KekaBgvClientRequestDTO;
import com.fsuite.BgvApi.keka.dto.KekaBgvDetailsResponseDTO;
import com.fsuite.BgvApi.keka.dto.KekaBgvTokenResponseDTO;
import com.fsuite.BgvApi.keka.dto.KekaCandidateDetailsDTO;
import com.fsuite.BgvApi.keka.dto.KekaEducationalDetailsDTO;
import com.fsuite.BgvApi.keka.dto.KekaSettingsDTO;
import com.fsuite.BgvApi.service.IBgvService;
import com.fsuite.BgvApi.utils.Commons;
import com.google.gson.Gson;


@Service
public class BgvServiceImpl implements IBgvService
{
	
	private static final Logger log=LoggerFactory.getLogger(BgvServiceImpl.class);
	
	private static final Gson gson = new Gson();
	
	private static final Map<String, String> darwinHeaderMap = new HashMap<String, String>();
	
	private static final Map<String, String> tokenKekaHeaderMap = new HashMap<String, String>();
	
	private static final Map<String, String> detailsKekaHeaderMap = new HashMap<String, String>();
	
	
	
	@Autowired
	private RestClient restClient;
	
	@Autowired
	private IBgvInterDao iBgvInterDao;
	
	@Autowired
	private IBgvActDao iBgvActDao;
	
	@Autowired
	private SettingsDTO settingsDTO;
	
	static 
	{
		darwinHeaderMap.put(AppConstants.CONTENT_TYPE, AppConstants.APPLICATION_JSON);
		darwinHeaderMap.put(AppConstants.ACCEPT, AppConstants.APPLICATION_JSON);
		
		tokenKekaHeaderMap.put(AppConstants.CONTENT_TYPE, AppConstants.APPLICATION_URLENCODED);
		tokenKekaHeaderMap.put(AppConstants.ACCEPT, AppConstants.APPLICATION_JSON);
		
		detailsKekaHeaderMap.put(AppConstants.ACCEPT, AppConstants.APPLICATION_JSON);

	}
	
	@Override
	@Transactional
	public BaseResponseDTO loadCanditateList(DarwinBgvClientRequestDTO bgvClientRequest)
	{
		log.info("[BgvServiceImpl][loadCanditateList]");
		HttpResponseDTO httpResponse = null;
		BaseResponseDTO response = null;
		try
		{
			String url=bgvClientRequest.getCandListUrl();
			BgvRequestDTO bgvRequest = bgvClientRequest.getBgvRequest();
			darwinHeaderMap.put("Authorization", "Basic "+Commons.encodeHeaders(bgvClientRequest.getAuth_username(), bgvClientRequest.getAuth_password()));
			httpResponse = this.restClient.sendRequest(url, gson.toJson(bgvRequest), darwinHeaderMap, null);
			if(httpResponse.getResponseCode().equals(HttpResponseDTO.REQUEST_SUCCESS))
			{
				CandidatesDataResponseDTO cdResponse = gson.fromJson(httpResponse.getResponseXml(), CandidatesDataResponseDTO.class);
				if(cdResponse!=null && cdResponse.getCandidate_data()!=null)
				{
					log.info(cdResponse.toString());
					for(CandidateDataDTO cand : cdResponse.getCandidate_data())
					{
						log.info(cand.toString());
						cand.setApi_key(bgvRequest.getApi_key());
						cand.setBgv_id(bgvRequest.getBgv_id());
						cand.setClient_id(bgvClientRequest.getClientId());
						cand.setDetails_url(bgvClientRequest.getDetails_url());
						cand.setDownloadUrl(bgvClientRequest.getDownloadUrl());
						cand.setVerification_url(bgvClientRequest.getVerification_url());
						cand.setAuth_username(bgvClientRequest.getAuth_username());
						cand.setAuth_password(bgvClientRequest.getAuth_password());
						cand.setRetry_count(0);
						cand.setStatus(AppConstants.P);
						this.iBgvInterDao.addCandidateData(cand);
					}
				}
				response = Commons.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS ,"Candiate List fetched Successfully");
			}
			else
			{
				log.info(httpResponse.toString());
				response = Commons.getFailureResponse(httpResponse.getResponseCode(),"Candiate List fetching Failed");
			}
		}
		catch(AppException e)
		{
			log.error("[BgvServiceImpl][loadCanditateList]",e);
			throw new AppException(BaseResponseDTO.FAILURE_STATUS, e.getErrMsg());
		}
		catch(Exception e)
		{
			log.error("[BgvServiceImpl][loadCanditateList]",e);
			throw new AppException(BaseResponseDTO.FAILURE_STATUS, "Internal Server Error.");
		}
		return response;
	}

	@Override
	@Transactional
	public void loadCanditateDetails()
	{
		log.info("[BgvServiceImpl][loadCanditateDetails]");
		try
		{
			List<CandidateDataDTO> list = this.iBgvInterDao.getPendingCanditateList();
			if(list!=null)
			{
				for(CandidateDataDTO cand : list)
				{
					log.info("cand : "+cand.toString());
					String url= cand.getDetails_url();
					BgvRequestDTO bgvRequest=new BgvRequestDTO();
					bgvRequest.setApi_key(cand.getApi_key());
					bgvRequest.setBgv_id(cand.getBgv_id());
					bgvRequest.setUnique_id(cand.getUnique_id());
					darwinHeaderMap.put("Authorization", "Basic "+Commons.encodeHeaders(cand.getAuth_username(), cand.getAuth_password()));
					HttpResponseDTO httpResponse = this.restClient.sendRequest(url, gson.toJson(bgvRequest), darwinHeaderMap, null);
					if(httpResponse.getResponseCode().equals(HttpResponseDTO.REQUEST_SUCCESS))
					{
						CandidateDetailsResponseDTO candDetails = gson.fromJson(httpResponse.getResponseXml(), CandidateDetailsResponseDTO.class);
						cand.setBgv_form_data(candDetails.getCandidate_data().getBgv_form_data());
						this.addCandidateDetails(cand,cand.getCase_id(), true);
						cand.setStatus(AppConstants.N);
						cand.setOperation_time(new Date());
					}
					else
					{
						Integer count=cand.getRetry_count();
						cand.setRetry_count(count++);
					}
					this.iBgvInterDao.updateCandidateData(cand);
				}
			}
		}
		catch(Exception e)
		{
			log.error("[BgvServiceImpl][loadCanditateDetails]",e);
			throw e;
		}
	}
	
	@Override
	@Transactional
	public BaseResponseDTO addCandidateDetails(CandidateDataDTO candidateData) throws NoSuchAlgorithmException
	{
		BaseResponseDTO resp = null;
		ClientDetailsDTO clientDetailsDTO = null;
		try
		{
			clientDetailsDTO = this.iBgvActDao.getClientDetails(candidateData.getClient_id());
			if(clientDetailsDTO==null)
			{
				throw new AppException(BaseResponseDTO.FAILURE_STATUS, "Client Details not found.");
			}
			else
			{
				String pass = clientDetailsDTO.getPassword();
				String base64Pass = Base64.encodeBase64String(pass.getBytes());
				if(base64Pass.equals(candidateData.getPassword()))
				{
					candidateData.setStatus(AppConstants.N);
					candidateData.setRetry_count(0);
					candidateData.setOperation_time(new Date());
					this.iBgvInterDao.addCandidateData(candidateData);
					this.addCandidateDetails(candidateData, candidateData.getCase_id(), false);
				}
				else
				{
					throw new AppException(BaseResponseDTO.FAILURE_STATUS, "Incorrect Password");
				}
			}
			resp=Commons.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS, "Candidate Details Added Successfully.");
		}
		catch(AppException e)
		{
			log.error("[BgvServiceImpl][addCandidateDetails]",e);
			throw e;
		}
		catch(Exception e)
		{
			log.error("[BgvServiceImpl][addCandidateDetails]",e);
			throw e;
		}
		return resp;
	}
	
	@Override
	@Transactional
	public void sendProcessStatus()
	{
		Boolean cond = false;
		try
		{
			List<ActCandidateDetailsDTO> actList = this.iBgvActDao.getProcessedList();
			if(actList!=null && !actList.isEmpty())
			{
				for(ActCandidateDetailsDTO actDTO : actList)
				{
					log.debug(actDTO.toString());
					CandidateDataDTO candidateDTO = this.iBgvInterDao.getCandidateData(actDTO.getCaseid(), actDTO.getClientid());
					if(candidateDTO!=null)
					{
						if(candidateDTO.getVerification_url()!=null && !candidateDTO.getVerification_url().isEmpty())
						{
							cond = true;
						}
					}
					
					if(cond)
					{
						BgvVerificationRequestDTO bgvVeriRequest = new BgvVerificationRequestDTO();
						bgvVeriRequest.setApi_key(candidateDTO.getApi_key());
						bgvVeriRequest.setBgv_id(candidateDTO.getBgv_id());
						bgvVeriRequest.setUnique_id(candidateDTO.getUnique_id());
						bgvVeriRequest.setAction("Complete");
						bgvVeriRequest.setBgv_status("Completed");
						bgvVeriRequest.setBgv_comments("");
						darwinHeaderMap.put("Authorization", "Basic "+Commons.encodeHeaders(candidateDTO.getAuth_username(), candidateDTO.getAuth_password()));
						HttpResponseDTO httpResponse = this.restClient.sendRequest(candidateDTO.getVerification_url(), gson.toJson(bgvVeriRequest), darwinHeaderMap, null);
						if(httpResponse.getResponseCode().equals(HttpResponseDTO.REQUEST_SUCCESS))
						{
							BgvVerirficationResponseDTO bgvVeriRes = gson.fromJson(httpResponse.getResponseXml(), BgvVerirficationResponseDTO.class);
							if(bgvVeriRes.getStatus()==1)
							{
								actDTO.setApi_stat(AppConstants.C);
							}
							else
							{
								actDTO.setApi_stat(AppConstants.R);
							}
						}
						else
						{
							actDTO.setApi_stat(AppConstants.R);
						}
					}
					else
					{
						actDTO.setApi_stat(AppConstants.R);
					}
					this.iBgvActDao.updateProcessedStatus(actDTO);
				}
			}
		}
		catch (AppException e) 
		{
			log.error("[BgvServiceImpl][sendProcessStatus]",e);
		}
		catch(Exception e)
		{
			log.error("[BgvServiceImpl][sendProcessStatus]",e);
		}
	}
	
	private void addCandidateDetails(CandidateDataDTO candidateData,Integer caseId, Boolean cond)
	{
		// BgvFormData
		BgvFormDataDTO bgvFormDataDTO = candidateData.getBgv_form_data();
		bgvFormDataDTO.setCase_id(caseId);
		if(!cond)
		{
			bgvFormDataDTO.setCv_document(this.downloadFilesFromDarwin(candidateData, bgvFormDataDTO.getCv_document(), null, cond));
		}
		this.iBgvInterDao.addBgvFormData(bgvFormDataDTO);
		
		//EducationDetailsDTO
		Map<String, EducationDetailsDTO> eduMap=bgvFormDataDTO.getEducation_details();
		if(eduMap!=null && !eduMap.isEmpty())
		{
			for(String key : eduMap.keySet())
			{
				int i=1;
				EducationDetailsDTO educationDetailsDTO = eduMap.get(key);
				if(i==1)
				{
					educationDetailsDTO.setEducation_category("Highest Education");
				}
				else
				{
					educationDetailsDTO.setEducation_category("Under Graduate Education");
				}
				educationDetailsDTO.setCase_id(caseId);
				candidateData.setFileName("education_"+i++);
				educationDetailsDTO.setEducational_documents_proofs(this.downloadFilesFromDarwin(candidateData,educationDetailsDTO.getEducational_documents_proofs(), candidateData.getApi_key(), cond));
				this.iBgvInterDao.addEducationDetails(educationDetailsDTO);
			}
		}
		
		//PastWorkingExprience
		Map<String, PastWorkExperienceDTO> workingMap = bgvFormDataDTO.getPast_work_experience();
		if(workingMap!=null && !workingMap.isEmpty())
		{
			for(String key : workingMap.keySet())
			{
				int i=1;
				PastWorkExperienceDTO past = workingMap.get(key);
				past.setCase_id(caseId);
				candidateData.setFileName("work_"+i);
				past.setWork_experience_proof(this.downloadFilesFromDarwin(candidateData, past.getWork_experience_proof(),candidateData.getApi_key(), cond));
				this.iBgvInterDao.addPastWorkingDetails(past);
			}
		}
		
		//Contact Details
		ContactDetailsDTO contactDetailsDTO = bgvFormDataDTO.getContact_details();
		
		if(contactDetailsDTO!=null)
		{
			AddressDetailsDTO permanent_address = contactDetailsDTO.getAddress().getPermanent_address();
			AddressDetailsDTO current_address = contactDetailsDTO.getAddress().getCurrent_address();
			
			if(permanent_address!=null)
			{
				permanent_address.setCase_id(caseId);
				candidateData.setFileName("permanent_address");
				permanent_address.setAddress_proof(this.downloadFilesFromDarwin(candidateData, contactDetailsDTO.getPermanent_address_proof(),candidateData.getApi_key(), cond));
				permanent_address.setAddress_period_of_stay_from(contactDetailsDTO.getPermanent_address_period_of_stay_from());
				permanent_address.setAddress_period_of_stay_to(contactDetailsDTO.getPermanent_address_period_of_stay_to());
				permanent_address.setAddress_type(AppConstants.P);
				this.iBgvInterDao.addAddressDetails(permanent_address);
			}
			
			if(current_address!=null)
			{
				current_address.setCase_id(caseId);
				candidateData.setFileName("current_address");
				current_address.setAddress_proof(this.downloadFilesFromDarwin(candidateData, contactDetailsDTO.getCurrent_address_proof(), candidateData.getApi_key(), cond));
				current_address.setAddress_period_of_stay_from(contactDetailsDTO.getCurrent_address_period_of_stay_from());
				current_address.setAddress_period_of_stay_to(contactDetailsDTO.getCurrent_address_period_of_stay_to());
				current_address.setAddress_type(AppConstants.C);
				this.iBgvInterDao.addAddressDetails(current_address);
			}
		}
	}
	
	private String downloadFilesFromDarwin(CandidateDataDTO candidateData, String data, String api_key, Boolean cond)
	{
		String outputPath = null;
		Boolean condVal = false;
		try 
		{
			if(cond && candidateData.getDownloadUrl()!=null && !candidateData.getDownloadUrl().isEmpty() && data!=null && !data.isEmpty())
			{
				DownloaderDTO downloader = new DownloaderDTO();
				downloader.setFile_key(data);
				downloader.setApi_key(api_key);
				darwinHeaderMap.put("Authorization", "Basic "+Commons.encodeHeaders(candidateData.getAuth_username(), candidateData.getAuth_password()));
				HttpResponseDTO httpResponse = this.restClient.sendRequest(candidateData.getDownloadUrl(), gson.toJson(downloader), darwinHeaderMap, null);
				if(httpResponse.getResponseCode().equals(HttpResponseDTO.REQUEST_SUCCESS))
				{
					downloader = gson.fromJson(httpResponse.getResponseXml(), DownloaderDTO.class);
					if(downloader!=null && downloader.getStatus()==1)
					{
						data = downloader.getFile();
						condVal=true;
					}
					else
					{
						outputPath="Failed to Download";
					}
				}
				else
				{
					outputPath="Failed to Download";
				}
			}
			else if(data!=null && !data.isEmpty())
			{
				condVal=true;
			}
			
			if(condVal && data!=null && Base64.isBase64(data))
			{
				byte[] decodedBytes = Base64.decodeBase64(data);
				outputPath = candidateData.processTemplateData(settingsDTO.getBaseFilePath(), candidateData)+getFileFormat(decodedBytes);
				Path filePath = Paths.get(outputPath);
				Files.createDirectories(filePath.getParent());
	            Files.write(filePath, decodedBytes);
			}
			else
			{
				outputPath="Unsupported data";
			}
        } 
		catch (IOException e) 
        {
			log.error("[BgvServiceImpl][addCandidateDetails]",e);
            outputPath="Unable to download";
        }
		catch(Exception e)
		{
			log.error("[BgvServiceImpl][addCandidateDetails]",e);
            outputPath="Unable to download";
		}
		return outputPath;
	}
	
	private static String getFileFormat(byte[] data) 
	{
		if (data.length >= 2)
		{
            if (data[0] == (byte) 0xFF && data[1] == (byte) 0xD8) 
            {
                return "JPEG";
            } 
            else if (data[0] == (byte) 0x89 && data[1] == (byte) 0x50) 
            {
                return "PNG";
            }
            else if (data.length >= 4 && data[0] == (byte) 0x25 && data[1] == (byte) 0x50 
            		&& data[2] == (byte) 0x44 && data[3] == (byte) 0x46) 
            {
                return "PDF";
            }
            else if (data.length >= 4 && data[0] == (byte) 0x50 && data[1] == (byte) 0x4B 
                    && data[2] == (byte) 0x03 && data[3] == (byte) 0x04) 
            {
                // This is a ZIP file header, which could indicate a .docx file
                return "DOCX";
            } 
            else if (data.length > 512) 
            {
                return "DOC";
            }
        }
		return "PNG";
    }
	
	@Override
	public BaseResponseDTO loadCandidateDetailsForKeka(KekaBgvClientRequestDTO kekaRequestDTO)
	{
		log.info("[BgvServiceImpl][loadCandidateDetailsForKeka] - "+kekaRequestDTO);
		BaseResponseDTO resp = null;
		KekaSettingsDTO kekaSettingsDTO = null;
		HttpResponseDTO tokenHttpResponseDTO = null;
		HttpResponseDTO detailsHttpResponseDTO = null;
		KekaBgvTokenResponseDTO tokenResponse = null;
		ClientDetailsDTO clientDetailsDTO = null;
		try
		{
			clientDetailsDTO = this.iBgvActDao.getClientDetails(kekaRequestDTO.getBgvClientId());
			if(clientDetailsDTO!=null)
			{
				String pass = clientDetailsDTO.getPassword();
				String base64Pass = Base64.encodeBase64String(pass.getBytes());
				if(base64Pass.equals(kekaRequestDTO.getBgvPassword()))
				{
					kekaSettingsDTO = settingsDTO.getKekaSettingsDTO();
					Map<String, String> paramMap = new HashMap<String, String>();
					paramMap.put(AppConstants.KEKA_GRANT_TYPE, kekaSettingsDTO.getKekaGrantType());
					paramMap.put(AppConstants.KEKA_SCOPE, kekaSettingsDTO.getKekaScope());
					paramMap.put(AppConstants.KEKA_CLIENT_ID, kekaRequestDTO.getKekaClientId());
					paramMap.put(AppConstants.KEKA_CLIENT_SECRET, kekaRequestDTO.getKekaClientSecret());
					paramMap.put(AppConstants.KEKA_API_KEY, kekaRequestDTO.getApiKey());
					
					tokenHttpResponseDTO = this.restClient.sendRequest(kekaRequestDTO.getTokenUrl(), null, tokenKekaHeaderMap, paramMap);
					if(tokenHttpResponseDTO.getResponseStatus()==200 && tokenHttpResponseDTO.getResponseCode().equals(HttpResponseDTO.REQUEST_SUCCESS))
					{
						tokenResponse = gson.fromJson(tokenHttpResponseDTO.getResponseXml(), KekaBgvTokenResponseDTO.class);
						if(tokenResponse!=null)
						{
							if(tokenResponse.getAccess_token()!=null && !tokenResponse.getAccess_token().isEmpty())
							{
								Map<String, String> detailParamMap = new HashMap<String, String>();
								detailParamMap.put(AppConstants.KEKA_ID, kekaRequestDTO.getIds());
								detailsKekaHeaderMap.put("Authorization", tokenResponse.getToken_type()+" "+tokenResponse.getAccess_token());
								detailsHttpResponseDTO = this.restClient.getRequest(kekaRequestDTO.getDetailsUrl(), detailsKekaHeaderMap, detailParamMap);
								if(detailsHttpResponseDTO.getResponseStatus()==200 && detailsHttpResponseDTO.getResponseCode().equals(HttpResponseDTO.REQUEST_SUCCESS))
								{
									KekaBgvDetailsResponseDTO kekaResponse = gson.fromJson(detailsHttpResponseDTO.getResponseXml(), KekaBgvDetailsResponseDTO.class);
									if(kekaResponse != null && kekaResponse.isSucceeded() && kekaResponse.getData()!=null)
									{
										this.parseKekaResponseToDTO(kekaResponse.getData(),kekaRequestDTO);
									}
									else
									{
										log.debug("[BgvServiceImpl][loadCandidateDetailsForKeka] - "+kekaResponse);
										throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.ERR_UNABLE_TO_LOAD_CANDIDATE_DETAILS);
									}
								}
								else
								{
									log.debug("[BgvServiceImpl][loadCandidateDetailsForKeka] - "+detailsHttpResponseDTO);
									throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.ERR_UNABLE_TO_LOAD_CANDIDATE_DETAILS);
								}
							}
							else
							{
								log.debug("[BgvServiceImpl][loadCandidateDetailsForKeka] - "+tokenResponse);
								throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.ERR_UNABLE_TO_LOAD_TOKEN_ID_TO_FETCH_CANDIDATE_DETAILS);
							}
						}
						else
						{
							log.debug("[BgvServiceImpl][loadCandidateDetailsForKeka] - "+tokenResponse);
							throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.INTERNAL_SERVER_ERROR);
						}
					}
					else
					{
						log.debug("[BgvServiceImpl][loadCandidateDetailsForKeka] - "+tokenHttpResponseDTO);
						throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.FAILED_TO_LOAD_TOKEN);
					}
				}
				else
				{
					throw new AppException(BaseResponseDTO.FAILURE_STATUS, "Incorrect Password");
				}
			}
			else
			{
				throw new AppException(BaseResponseDTO.FAILURE_STATUS, AppExceptionConstants.ERR_CLIENT_DETAILS_NOT_FOUND);
			}
		}
		catch(AppException e)
		{
			log.error("[BgvServiceImpl][loadCandidateDetailsForKeka]",e);
			throw e;
		}
		catch(Exception e)
		{
			log.error("[BgvServiceImpl][loadCandidateDetailsForKeka]",e);
			throw e;
		}
		return resp;
	}
	
	private void parseKekaResponseToDTO(KekaCandidateDetailsDTO kekaCandidateDTO, KekaBgvClientRequestDTO kekaRequestDTO)
	{
		
		CandidateDataDTO candidateDTO = new CandidateDataDTO();
		candidateDTO.setUnique_id(kekaCandidateDTO.getId());
		candidateDTO.setEmployee_id(kekaCandidateDTO.getEmployeeNumber());
		candidateDTO.setCandidate_id("");
		candidateDTO.setClient_id(kekaRequestDTO.getBgvClientId());
		candidateDTO.setStatus(AppConstants.N);
		candidateDTO.setRetry_count(0);
		candidateDTO.setOperation_time(new Date());
		
		this.iBgvInterDao.addCandidateData(candidateDTO);
		
		
		BgvFormDataDTO bgvFormData = new BgvFormDataDTO();
		bgvFormData.setCase_id(candidateDTO.getCase_id());
		bgvFormData.setAdharcard(null);
		bgvFormData.setDate_of_birth(kekaCandidateDTO.getDateOfBirth());
		bgvFormData.setFirstname(kekaCandidateDTO.getFirstName()+" "+kekaCandidateDTO.getMiddleName());
		bgvFormData.setLastname(kekaCandidateDTO.getLastName());
		bgvFormData.setGender(kekaCandidateDTO.getGender()== 1? "Male":kekaCandidateDTO.getGender()==2?"Female":"Nonbinary");
		bgvFormData.setPersonal_email_id(kekaCandidateDTO.getPersonalEmail());
		bgvFormData.setPrimary_mobile(kekaCandidateDTO.getMobilePhone());
		this.iBgvInterDao.addBgvFormData(bgvFormData);
		
		EducationDetailsDTO education = null;
		for(KekaEducationalDetailsDTO kekaEducation : kekaCandidateDTO.getEducationDetails())
		{
			education = new EducationDetailsDTO();
			education.setCase_id(candidateDTO.getCase_id());
			education.setUniversity(kekaEducation.getUniversity());
//			edu.setInstitution_name(kekeEducation.get);
//			edu.setAddress_of_educational_institute(null);
			education.setCourse_type(kekaEducation.getDegree());
			education.setField_of_study(kekaEducation.getBranch());
			education.setFrom_date(kekaEducation.getYearOfJoining());
			education.setTo_date(kekaEducation.getYearOfCompletion());
			education.setGpa_percentage(kekaEducation.getCgpa()+"");
			education.setRegistration_number(kekaEducation.getId());
			this.iBgvInterDao.addEducationDetails(education);
		}
		
		KekaAddressDetailsDTO kekaCurrentAddress = kekaCandidateDTO.getCurrentAddress();
		AddressDetailsDTO addressDetails = new AddressDetailsDTO();
		addressDetails.setCase_id(candidateDTO.getCase_id());
		addressDetails.setAddress(kekaCurrentAddress.getAddressLine1()+" "+kekaCurrentAddress.getAddressLine2());
		addressDetails.setAddress_proof(kekaCurrentAddress.getZip());
		addressDetails.setAddress_type(AppConstants.C);
		addressDetails.setCountry(kekaCurrentAddress.getCountryCode());
		addressDetails.setCity(kekaCurrentAddress.getCity());
		addressDetails.setState(kekaCurrentAddress.getState());
		this.iBgvInterDao.addAddressDetails(addressDetails);
		
		KekaAddressDetailsDTO kekaPermanentAddress = kekaCandidateDTO.getPermanentAddress();
		addressDetails = new AddressDetailsDTO();
		addressDetails.setCase_id(candidateDTO.getCase_id());
		addressDetails.setAddress(kekaPermanentAddress.getAddressLine1()+" "+kekaPermanentAddress.getAddressLine2());
		addressDetails.setAddress_proof(kekaPermanentAddress.getZip());
		addressDetails.setAddress_type(AppConstants.P);
		addressDetails.setCountry(kekaPermanentAddress.getCountryCode());
		addressDetails.setCity(kekaPermanentAddress.getCity());
		addressDetails.setState(kekaPermanentAddress.getState());
		this.iBgvInterDao.addAddressDetails(addressDetails);
		
	}
}
