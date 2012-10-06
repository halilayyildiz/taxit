package com.taxit.remote.api.response;

import com.taxit.remote.Station;

public class StationStatusResponse
{
	private Station	station	= new Station();

	public StationStatusResponse()
	{

	}

	public Station getStation()
	{
		return station;
	}

	public void setStation(Station station)
	{
		this.station = station;
	}

}
