package com.taxit.remote;

public class Taxi
{
	private String		plate;
	private Location	location;
	private Driver		driver;
	private TaxiState	state;

	public Taxi()
	{

	}

	public String getPlate()
	{
		return plate;
	}

	public void setPlate(String plate)
	{
		this.plate = plate;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

	public Driver getDriver()
	{
		return driver;
	}

	public void setDriver(Driver driver)
	{
		this.driver = driver;
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
