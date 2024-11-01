/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.configs;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fsuite.BgvApi.dto.HttpResponseDTO;

@SuppressWarnings("deprecation")
public class RestClient
{

	private static final Logger log = LoggerFactory.getLogger(RestClient.class);
	
	private CloseableHttpClient client;
	private Integer connectionTimeout;
	private Integer connectionRequestTimeout;
	private Integer socketTimeout;

	public RestClient()
	{
		
	}
	
	public RestClient(Integer connectTimeout,Integer connectRequestTimeout,Integer sockTimeout) throws Exception
	{
		connectionTimeout = connectTimeout;
		connectionRequestTimeout = connectRequestTimeout;
		socketTimeout = sockTimeout;
		client = RestClient.getSslHttpClient(connectionTimeout,connectionRequestTimeout,socketTimeout);
	}
	
	private static CloseableHttpClient getSslHttpClient(Integer connectionTimeout,Integer connectionRequestTimeout,Integer socketTimeout) throws Exception
	{
		TrustStrategy acceptingTrustStrategy = new TrustStrategy()
		{
			@Override
			public boolean isTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws CertificateException
			{
				return true;
			}
		};
		SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
		//		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext,new String[]{"TLSv1.1", "TLSv1.2"},null,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext,null,null,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier()
		{
			@Override
			public boolean verify(String arg0, SSLSession arg1)
			{
				log.debug("verify(String arg0, SSLSession arg1)" + arg0+ " " + arg1);
				return true;
			}

			@Override
			public void verify(String arg0, String[] arg1, String[] arg2)throws SSLException
			{
				log.debug("verify(String arg0, String[] arg1, String[] arg2)");
			}

			@Override
			public void verify(String arg0, X509Certificate arg1) throws SSLException
			{
				log.debug("verify(String arg0, X509Certificate arg1)");
			}

			@Override
			public void verify(String arg0, SSLSocket arg1) throws IOException
			{
				log.debug("verify(String arg0, SSLSocket arg1)");
			}
		};

		Builder configBuilder = RequestConfig.custom();
		if(connectionTimeout != null)
		{
			configBuilder = configBuilder.setConnectTimeout(connectionTimeout*1000);
		}

		if(connectionRequestTimeout != null)
		{
			configBuilder = configBuilder.setConnectionRequestTimeout(connectionRequestTimeout*1000);
		}

		if(socketTimeout != null)
		{
			configBuilder = configBuilder.setSocketTimeout(socketTimeout*1000);
		}

		RequestConfig config = configBuilder.build();
		log.debug("config"+config);
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).setHostnameVerifier(hostnameVerifier).setDefaultRequestConfig(config).build();
		return httpClient;
	}
	
	public HttpResponseDTO getRequest(String url,Map<String, String> headers,Map<String, String> paramMap)
	{
		HttpResponseDTO responseDTO = new HttpResponseDTO();
		String responseReceived = null;
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = null;
		try
		{
			if(paramMap != null)
			{
				URIBuilder uriBuilder = new URIBuilder(httpGet.getURI());
				for(String key : paramMap.keySet())
				{
					uriBuilder.addParameter(key, paramMap.get(key));
				}
				URI uri = uriBuilder.build();
				HttpRequestBase base = httpGet;
				base.setURI(uri);
			}
			if((headers != null) && !headers.isEmpty())
			{
				for(String key : headers.keySet())
				{
					httpGet.setHeader(key, headers.get(key));
				}
			}
			try
			{
				response = client.execute(httpGet);
				responseDTO.setResponseStatus(response.getStatusLine().getStatusCode());
				responseReceived = EntityUtils.toString(response.getEntity());
				responseDTO.setResponseCode(HttpResponseDTO.REQUEST_SUCCESS);
				responseDTO.setResponseXml(responseReceived);
			}
			catch(Exception ex)
			{
				log.error("Error ",ex);
				if(ex instanceof SocketTimeoutException )
				{
					responseDTO.setResponseCode(HttpResponseDTO.ERR_SOCKET_TIMEOUT);
				}
				else if(ex instanceof org.apache.http.conn.ConnectTimeoutException )
				{
					responseDTO.setResponseCode(HttpResponseDTO.ERR_CONNECT_TIMEOUT);
				}
				else
				{
					responseDTO.setResponseCode(HttpResponseDTO.ERR_POSTING_REQUEST);
				}
			}
			finally
			{
				try
				{
					httpGet.releaseConnection();
				}
				catch (Exception ex)
				{
					log.error("Error closing connection",ex);
				}
			}
		}
		catch(Exception ex)
		{
			log.error("Error ",ex);
			if(ex instanceof SocketTimeoutException )
			{
				responseDTO.setResponseCode(HttpResponseDTO.ERR_SOCKET_TIMEOUT);
			}
			else if(ex instanceof org.apache.http.conn.ConnectTimeoutException )
			{
				responseDTO.setResponseCode(HttpResponseDTO.ERR_CONNECT_TIMEOUT);
			}
			else
			{
				responseDTO.setResponseCode(HttpResponseDTO.ERR_POSTING_REQUEST);
			}
		}
		return responseDTO;
	}
	
	public HttpResponseDTO sendRequest(String url,String data,Map<String, String> headers,Map<String, String> paramsMap)
	{
		HttpResponseDTO responseDTO = new HttpResponseDTO();
		try
		{
			String response = postRequest(url, data, headers,paramsMap,responseDTO);
			responseDTO.setResponseCode(HttpResponseDTO.REQUEST_SUCCESS);
			responseDTO.setResponseXml(response);
		}
		catch(Exception ex)
		{
			log.warn("Error - ",ex);
			if(ex instanceof SocketTimeoutException )
			{
				responseDTO.setResponseCode(HttpResponseDTO.ERR_SOCKET_TIMEOUT);
			}
			else if(ex instanceof org.apache.http.conn.ConnectTimeoutException )
			{
				responseDTO.setResponseCode(HttpResponseDTO.ERR_CONNECT_TIMEOUT);
			}
			else
			{
				responseDTO.setResponseCode(HttpResponseDTO.ERR_POSTING_REQUEST);
			}
		}
		return responseDTO;
	}
	
	public String postRequest(String url,String data,Map<String, String> headers,Map<String, String> paramMap,HttpResponseDTO responseDTO) throws ClientProtocolException, IOException, URISyntaxException
	{
		String responseReceived = null;
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
//		httpPost.setHeader(CONTENT_TYPE, APPLICATION_JSON);
		if((headers != null) && !headers.isEmpty())
		{
			for(String key : headers.keySet())
			{
				httpPost.setHeader(key, headers.get(key));
			}
		}

		if(paramMap != null)
		{
			URIBuilder uriBuilder = new URIBuilder(httpPost.getURI());
			for(String key : paramMap.keySet())
			{
				uriBuilder.addParameter(key, paramMap.get(key));
			}
			URI uri = uriBuilder.build();
			HttpRequestBase base = httpPost;
			base.setURI(uri);
		}
		if(data != null)
		{
			if(!data.isEmpty())
			{
				httpPost.setEntity(new StringEntity(data));
			}
		}

		try
		{
			response = client.execute(httpPost);
			responseDTO.setResponseStatus(response.getStatusLine().getStatusCode());
			responseReceived = EntityUtils.toString(response.getEntity());
		}
		catch (SocketTimeoutException soEx)
		{
			throw soEx;
		}
		catch(org.apache.http.conn.ConnectTimeoutException coEx)
		{
			throw coEx;
		}
		finally
		{
			try
			{
				httpPost.releaseConnection();
			}
			catch (Exception ex)
			{
				log.error("Error closing connection",ex);
			}
		}
		return responseReceived;
	}
}
