/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.act.models;

import org.hibernate.annotations.GenericGenerator;

import com.fsuite.BgvApi.constants.SequenceConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cv_employers")
public class ClientDetails
{

	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = SequenceConstants.NATIVE)
	@GenericGenerator(name = SequenceConstants.NATIVE, strategy = SequenceConstants.NATIVE)
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "industry")
	private String industry;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "spocname")
	private String spocName;
	
	@Column(name = "spocemail")
	private String spocEmail;
	
	@Column(name = "spocphone")
	private String spocPhone;
	
	@Column(name = "manager")
	private String manager;
	
	@Column(name = "manemail")
	private String manemail;
	
	@Column(name = "manphone")
	private String manphone;
	
//	@Column(name = "agrstart")
//	private Date agrStart;
//	
//	@Column(name = "agrend")
//	private Date agrEnd;
	
	@Column(name = "agrstatus")
	private String agrStatus;
	
	@Column(name = "clientid")
	private String clientId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "cpassword")
	private String cpassword;
	
	@Column(name = "status")
	private String status;
	
//	@Column(name = "date")
//	private Date date;

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

	public String getSpocName()
	{
		return spocName;
	}

	public void setSpocName(String spocName)
	{
		this.spocName = spocName;
	}

	public String getSpocEmail()
	{
		return spocEmail;
	}

	public void setSpocEmail(String spocEmail)
	{
		this.spocEmail = spocEmail;
	}

	public String getSpocPhone()
	{
		return spocPhone;
	}

	public void setSpocPhone(String spocPhone)
	{
		this.spocPhone = spocPhone;
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

//	public Date getAgrStart()
//	{
//		return agrStart;
//	}
//
//	public void setAgrStart(Date agrStart)
//	{
//		this.agrStart = agrStart;
//	}
//
//	public Date getAgrEnd()
//	{
//		return agrEnd;
//	}
//
//	public void setAgrEnd(Date agrEnd)
//	{
//		this.agrEnd = agrEnd;
//	}

	public String getAgrStatus()
	{
		return agrStatus;
	}

	public void setAgrStatus(String agrStatus)
	{
		this.agrStatus = agrStatus;
	}

	public String getClientId()
	{
		return clientId;
	}

	public void setClientId(String clientId)
	{
		this.clientId = clientId;
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

	@Override
	public String toString()
	{
		return "ClientDetails [id=" + id + ", company=" + company + ", address="
				+ address + ", city=" + city + ", state=" + state
				+ ", industry=" + industry + ", website=" + website
				+ ", spocName=" + spocName + ", spocEmail=" + spocEmail
				+ ", spocPhone=" + spocPhone + ", manager=" + manager
				+ ", manemail=" + manemail + ", manphone=" + manphone
				+ ", agrStatus=" + agrStatus + ", clientId=" + clientId
				+ ", password=" + password + ", cpassword=" + cpassword
				+ ", status=" + status + "]";
	}

//	public Date getDate()
//	{
//		return date;
//	}
//
//	public void setDate(Date date)
//	{
//		this.date = date;
//	}

	
		
	
	
}
