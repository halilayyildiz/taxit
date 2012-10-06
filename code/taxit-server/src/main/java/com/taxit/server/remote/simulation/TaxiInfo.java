package com.taxit.server.remote.simulation;

import com.taxit.server.database.dbo.Location;
import com.taxit.server.database.dbo.TaxiState;

public class TaxiInfo
{
	private Location	location;
	private TaxiState	state;

	public TaxiInfo()
	{

	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

	public TaxiState getState()
	{
		return state;
	}

	public void setState(TaxiState state)
	{
		this.state = state;
	}

}
