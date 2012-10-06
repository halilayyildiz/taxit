package com.taxit.server.remote.simulation;

import java.util.ArrayList;
import java.util.List;

import com.taxit.server.database.dbo.Location;

public class TaxiRoute
{
	private List<Location>	locations			= new ArrayList<Location>();
	private int				lastLocationIndex	= 0;

	public TaxiRoute()
	{

	}

	public Location getNextLocation()
	{
		Location result = null;

		if (!locations.isEmpty())
		{
			result = locations.get(lastLocationIndex);
			lastLocationIndex = (lastLocationIndex < (locations.size() - 1)) ? (lastLocationIndex + 1) : 0;
		}

		return result;
	}

	public List<Location> getLocations()
	{
		return locations;
	}

	public void setLocations(List<Location> locations)
	{
		this.locations = locations;
	}

	public int getLastLocationIndex()
	{
		return lastLocationIndex;
	}

	public void setLastLocationIndex(int lastLocationIndex)
	{
		this.lastLocationIndex = lastLocationIndex;
	}

}
