package com.taxit.server.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taxit.server.remote.simulation.LocationSimulator;
import com.taxit.server.remote.simulation.TaxiInfo;

@Component
public class LocationAPIConnectorImpl implements LocationAPIConnector
{
	private LocationSimulator	simulator;

	@Autowired
	public LocationAPIConnectorImpl(LocationSimulator simulator)
	{
		this.simulator = simulator;
	}

	@Override
	public TaxiInfo getTaxiInfo(long taxiId)
	{
		return simulator.getTaxiInfo(taxiId);
	}

	public LocationSimulator getSimulator()
	{
		return simulator;
	}

	public void setSimulator(LocationSimulator simulator)
	{
		this.simulator = simulator;
	}

}
