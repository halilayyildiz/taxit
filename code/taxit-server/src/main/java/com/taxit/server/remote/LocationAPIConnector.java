package com.taxit.server.remote;

import com.taxit.server.remote.simulation.TaxiInfo;

/**
 * A interface to fetch data from remote location services.
 * 
 */
public interface LocationAPIConnector
{
	public TaxiInfo getTaxiInfo(long taxiId);
}
