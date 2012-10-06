package com.taxit.server.service.response;

import com.taxit.server.database.dbo.Location;

public class TaxiLocation
{
	private String		taxiPlate;
	private Location	location	= new Location();

	public TaxiLocation()
	{

	}

	public String getTaxiPlate()
	{
		return taxiPlate;
	}

	public void setTaxiPlate(String taxiPlate)
	{
		this.taxiPlate = taxiPlate;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

}
