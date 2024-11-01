/*
*
*N Sunil 
*
*/

package com.fsuite.BgvApi.darwin.dto;

public class AddressDTO
{

	private AddressDetailsDTO current_address;
    private AddressDetailsDTO permanent_address;
    
	public AddressDetailsDTO getCurrent_address()
	{
		return current_address;
	}

	public void setCurrent_address(AddressDetailsDTO current_address)
	{
		this.current_address = current_address;
	}

	public AddressDetailsDTO getPermanent_address()
	{
		return permanent_address;
	}

	public void setPermanent_address(AddressDetailsDTO permanent_address)
	{
		this.permanent_address = permanent_address;
	}

	@Override
	public String toString()
	{
		return "Address [current_address=" + current_address
				+ ", permanent_address=" + permanent_address + "]";
	}
    
    
    
}
