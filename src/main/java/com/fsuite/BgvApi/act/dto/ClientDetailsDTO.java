/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.act.dto;

import java.io.Serializable;
import java.util.Date;

public class ClientDetailsDTO implements Serializable
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String company;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String industry;
	
	private String website;
	
	private String spocname;
	
	private String spocemail;
	
	private String spocphone;
	
	private String manager;
	
	private String manemail;
	
	private String manphone;
	
	private Date agrstart;
	
	private Date agrend;
	
	private String agrstatus;
	
	private String clientid;
	
	private String password;
	
	private String cpassword;
	
	private String status;
	
	private Date date;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getIndustry()
	{
		return industry;
	}

	public void setIndustry(String industry)
	{
		this.industry = industry;
	}

	public String getWebsite()
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}

	public String getSpocname()
	{
		return spocname;
	}

	public void setSpocname(String spocname)
	{
		this.spocname = spocname;
	}

	public String getSpocemail()
	{
		return spocemail;
	}

	public void setSpocemail(String spocemail)
	{
		this.spocemail = spocemail;
	}

	public String getSpocphone()
	{
		return spocphone;
	}

	public void setSpocphone(String spocphone)
	{
		this.spocphone = spocphone;
	}

	public String getManager()
	{
		return manager;
	}

	public void setManager(String manager)
	{
		this.manager = manager;
	}

	public String getManemail()
	{
		return manemail;
	}

	public void setManemail(String manemail)
	{
		this.manemail = manemail;
	}

	public String getManphone()
	{
		return manphone;
	}

	public void setManphone(String manphone)
	{
		this.manphone = manphone;
	}

	public Date getAgrstart()
	{
		return agrstart;
	}

	public void setAgrstart(Date agrstart)
	{
		this.agrstart = agrstart;
	}

	public Date getAgrend()
	{
		return agrend;
	}

	public void setAgrend(Date agrend)
	{
		this.agrend = agrend;
	}

	public String getAgrstatus()
	{
		return agrstatus;
	}

	public void setAgrstatus(String agrstatus)
	{
		this.agrstatus = agrstatus;
	}

	public String getClientid()
	{
		return clientid;
	}

	public void setClientid(String clientid)
	{
		this.clientid = clientid;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getCpassword()
	{
		return cpassword;
	}

	public void setCpassword(String cpassword)
	{
		this.cpassword = cpassword;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	@Override
	public String toString()
	{
		return "ClientDetailsDTO [id=" + id + ", company=" + company
				+ ", address=" + address + ", city=" + city + ", state=" + state
				+ ", industry=" + industry + ", website=" + website
				+ ", spocname=" + spocname + ", spocemail=" + spocemail
				+ ", spocphone=" + spocphone + ", manager=" + manager
				+ ", manemail=" + manemail + ", manphone=" + manphone
				+ ", agrstart=" + agrstart + ", agrend=" + agrend
				+ ", agrstatus=" + agrstatus + ", clientid=" + clientid
				+ ", password=" + password + ", cpassword=" + cpassword
				+ ", status=" + status + ", date=" + date + "]";
	}
	
	
}
