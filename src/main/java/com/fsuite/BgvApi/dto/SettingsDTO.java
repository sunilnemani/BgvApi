/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.dto;

import com.fsuite.BgvApi.keka.dto.KekaSettingsDTO;
import com.fsuite.BgvApi.utils.Value;

public class SettingsDTO
{
	
	public SettingsDTO()
	{
		kekaSettingsDTO = new KekaSettingsDTO();
	}
	
	@Value("${CONNECTION_REQUEST_TIMEOUT}")
	private Integer connectionReqTimeout;
	
	@Value("${CONNECT_TIMEOUT}")
	private Integer connectionTimeout;
	
	@Value("${SOCKET_TIMEOUT}")
	private Integer socketTimeout;
	
	@Value("${RETRY_COUNT}")
	private Integer retryCount;
	
	@Value("${INITIAL_DELAY}")
	private Integer initialDelay;
	
	@Value("${DELAY}")
	private Integer delay;
	
	@Value("${BATCH_SIZE}")
	private Integer batchSize;
	
	@Value("${AUTH_USERNAME}")
	private String authUserName;
	
	@Value("${AUTH_PASSWORD}")
	private String authPassword;
	
	@Value("${BASE_FILE_PATH}")
	private String baseFilePath;
	
	private KekaSettingsDTO kekaSettingsDTO;

	public Integer getConnectionReqTimeout()
	{
		return connectionReqTimeout;
	}

	public void setConnectionReqTimeout(Integer connectionReqTimeout)
	{
		this.connectionReqTimeout = connectionReqTimeout;
	}

	public Integer getConnectionTimeout()
	{
		return connectionTimeout;
	}

	public void setConnectionTimeout(Integer connectionTimeout)
	{
		this.connectionTimeout = connectionTimeout;
	}

	public Integer getSocketTimeout()
	{
		return socketTimeout;
	}

	public void setSocketTimeout(Integer socketTimeout)
	{
		this.socketTimeout = socketTimeout;
	}

	public Integer getRetryCount()
	{
		return retryCount;
	}

	public void setRetryCount(Integer retryCount)
	{
		this.retryCount = retryCount;
	}

	public Integer getInitialDelay()
	{
		return initialDelay;
	}

	public void setInitialDelay(Integer initialDelay)
	{
		this.initialDelay = initialDelay;
	}

	public Integer getDelay()
	{
		return delay;
	}

	public void setDelay(Integer delay)
	{
		this.delay = delay;
	}

	public Integer getBatchSize()
	{
		return batchSize;
	}

	public void setBatchSize(Integer batchSize)
	{
		this.batchSize = batchSize;
	}

	public String getAuthUserName()
	{
		return authUserName;
	}

	public void setAuthUserName(String authUserName)
	{
		this.authUserName = authUserName;
	}

	public String getAuthPassword()
	{
		return authPassword;
	}

	public void setAuthPassword(String authPassword)
	{
		this.authPassword = authPassword;
	}

	public String getBaseFilePath()
	{
		return baseFilePath;
	}

	public void setBaseFilePath(String baseFilePath)
	{
		this.baseFilePath = baseFilePath;
	}

	public KekaSettingsDTO getKekaSettingsDTO()
	{
		return kekaSettingsDTO;
	}

	public void setKekaSettingsDTO(KekaSettingsDTO kekaSettingsDTO)
	{
		this.kekaSettingsDTO = kekaSettingsDTO;
	}

	@Override
	public String toString()
	{
		return "SettingsDTO [connectionReqTimeout=" + connectionReqTimeout
				+ ", connectionTimeout=" + connectionTimeout
				+ ", socketTimeout=" + socketTimeout + ", retryCount="
				+ retryCount + ", initialDelay=" + initialDelay + ", delay="
				+ delay + ", batchSize=" + batchSize + ", authUserName="
				+ authUserName + ", authPassword=" + authPassword
				+ ", baseFilePath=" + baseFilePath + ", kekaSettingsDTO="
				+ kekaSettingsDTO + "]";
	}
}
