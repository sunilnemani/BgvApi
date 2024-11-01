/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.inter.models;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;

import com.fsuite.BgvApi.constants.SequenceConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bgv_form_data")
public class BgvFormData implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = SequenceConstants.NATIVE)
	@GenericGenerator(name = SequenceConstants.NATIVE, strategy = SequenceConstants.NATIVE)
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "case_id")
	private Integer case_id;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
    private String lastname;
    
	@Column(name = "gender")
    private String gender;
    
	@Column(name = "primary_mobile")
    private String primary_mobile;
    
	@Column(name = "date_of_birth")
    private String date_of_birth;
    
	@Column(name = "user_name_as_per_aadhar")
    private String user_name_as_per_aadhar;
    
	@Column(name = "name_as_per_pan")
    private String name_as_per_pan;
    
	@Column(name = "personal_email_id")
    private String personal_email_id;
    
	@Column(name = "pancard")
    private String pancard;
    
	@Column(name = "adharcard")
    private String adharcard;
	
	@Column(name = "cv_document")
	private String cv_document;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getCase_id()
	{
		return case_id;
	}

	public void setCase_id(Integer case_id)
	{
		this.case_id = case_id;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getPrimary_mobile()
	{
		return primary_mobile;
	}

	public void setPrimary_mobile(String primary_mobile)
	{
		this.primary_mobile = primary_mobile;
	}

	public String getDate_of_birth()
	{
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth)
	{
		this.date_of_birth = date_of_birth;
	}

	public String getUser_name_as_per_aadhar()
	{
		return user_name_as_per_aadhar;
	}

	public void setUser_name_as_per_aadhar(String user_name_as_per_aadhar)
	{
		this.user_name_as_per_aadhar = user_name_as_per_aadhar;
	}

	public String getName_as_per_pan()
	{
		return name_as_per_pan;
	}

	public void setName_as_per_pan(String name_as_per_pan)
	{
		this.name_as_per_pan = name_as_per_pan;
	}

	public String getPersonal_email_id()
	{
		return personal_email_id;
	}

	public void setPersonal_email_id(String personal_email_id)
	{
		this.personal_email_id = personal_email_id;
	}

	public String getPancard()
	{
		return pancard;
	}

	public void setPancard(String pancard)
	{
		this.pancard = pancard;
	}

	public String getAdharcard()
	{
		return adharcard;
	}

	public void setAdharcard(String adharcard)
	{
		this.adharcard = adharcard;
	}

	public String getCv_document()
	{
		return cv_document;
	}

	public void setCv_document(String cv_document)
	{
		this.cv_document = cv_document;
	}

	@Override
	public String toString()
	{
		return "BgvFormData [id=" + id + ", case_id=" + case_id
				+ ", firstname=" + firstname + ", lastname=" + lastname
				+ ", gender=" + gender + ", primary_mobile=" + primary_mobile
				+ ", date_of_birth=" + date_of_birth
				+ ", user_name_as_per_aadhar=" + user_name_as_per_aadhar
				+ ", name_as_per_pan=" + name_as_per_pan
				+ ", personal_email_id=" + personal_email_id + ", pancard="
				+ pancard + ", adharcard=" + adharcard + "]";
	}
	
}
