package com.taxit.remote.api.response;

import com.taxit.remote.Taxi;

public class TaxiStatusResponse
{
	private Taxi	taxi;

	public TaxiStatusResponse()
	{

	}

	public Taxi getTaxi()
	{
		return taxi;
	}

	public void setTaxi(Taxi taxi)
	{
		this.taxi = taxi;
	}

}
