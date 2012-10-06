package com.taxit.remote;

import java.util.ArrayList;
import java.util.List;

public class Station
{
	private String		stationId;
	private Operator	operator	= new Operator();
	private Location	location	= new Location();
	private List<Taxi>	taxiList	= new ArrayList<Taxi>();

	public Station()
	{

	}

	public String getStationId()
	{
		return stationId;
	}

	public void setStationId(String stationId)
	{
		this.stationId = stationId;
	}

	public Operator getOperator()
	{
		return operator;
	}

	public void setOperator(Operator operator)
	{
		this.operator = operator;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

	public List<Taxi> getTaxiList()
	{
		return taxiList;
	}

	public void setTaxiList(List<Taxi> taxiList)
	{
		this.taxiList = taxiList;
	}

}
