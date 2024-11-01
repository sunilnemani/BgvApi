/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.darwin.dto;

public class ContactDetailsDTO
{

	private AddressDTO address;
	
    private String current_address_proof;
    
    private String current_address_period_of_stay_from;
    
    private String current_address_period_of_stay_to;
    
    private String permanent_address_proof;
    
    private String permanent_address_period_of_stay_from;
    
    private String permanent_address_period_of_stay_to;


	public AddressDTO getAddress()
	{
		return address;
	}

	public void setAddress(AddressDTO address)
	{
		this.address = address;
	}

	public String getCurrent_address_proof()
	{
		return current_address_proof;
	}

	public void setCurrent_address_proof(String current_address_proof)
	{
		this.current_address_proof = current_address_proof;
	}

	public String getCurrent_address_period_of_stay_from()
	{
		return current_address_period_of_stay_from;
	}

	public void setCurrent_address_period_of_stay_from(
			String current_address_period_of_stay_from)
	{
		this.current_address_period_of_stay_from = current_address_period_of_stay_from;
	}

	public String getCurrent_address_period_of_stay_to()
	{
		return current_address_period_of_stay_to;
	}

	public void setCurrent_address_period_of_stay_to(
			String current_address_period_of_stay_to)
	{
		this.current_address_period_of_stay_to = current_address_period_of_stay_to;
	}

	public String getPermanent_address_proof()
	{
		return permanent_address_proof;
	}

	public void setPermanent_address_proof(String permanent_address_proof)
	{
		this.permanent_address_proof = permanent_address_proof;
	}

	public String getPermanent_address_period_of_stay_from()
	{
		return permanent_address_period_of_stay_from;
	}

	public void setPermanent_address_period_of_stay_from(
			String permanent_address_period_of_stay_from)
	{
		this.permanent_address_period_of_stay_from = permanent_address_period_of_stay_from;
	}

	public String getPermanent_address_period_of_stay_to()
	{
		return permanent_address_period_of_stay_to;
	}

	public void setPermanent_address_period_of_stay_to(
			String permanent_address_period_of_stay_to)
	{
		this.permanent_address_period_of_stay_to = permanent_address_period_of_stay_to;
	}

	@Override
	public String toString()
	{
		return "ContactDetails [address=" + address + ", current_address_proof="
				+ current_address_proof
				+ ", current_address_period_of_stay_from="
				+ current_address_period_of_stay_from
				+ ", current_address_period_of_stay_to="
				+ current_address_period_of_stay_to
				+ ", permanent_address_proof=" + permanent_address_proof
				+ ", permanent_address_period_of_stay_from="
				+ permanent_address_period_of_stay_from
				+ ", permanent_address_period_of_stay_to="
				+ permanent_address_period_of_stay_to + "]";
	}
    
    

}
