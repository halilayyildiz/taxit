package com.taxit.server.remote.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taxit.server.database.dao.BaseDAO;
import com.taxit.server.database.dbo.Location;
import com.taxit.server.database.dbo.SimulationRoute;

@Component
public class LocationSimulator
{
	private BaseDAO					baseDAO;
	private Location				stationLocation;

	private List<TaxiRoute>			taxiRoutes		= new ArrayList<TaxiRoute>();
	private int						taxiRouteIndex	= 0;

	private Map<Long, TaxiRoute>	taxiRouteMap	= new HashMap<Long, TaxiRoute>();

	@Autowired
	public LocationSimulator(BaseDAO baseDAO)
	{
		this.baseDAO = baseDAO;
	}

	public TaxiInfo getTaxiInfo(long taxiId)
	{
		TaxiInfo taxiInfo = new TaxiInfo();

		taxiInfo.setLocation(getTaxiRoute(taxiId).getNextLocation());
		taxiInfo.setState(TaxiStateSimulator.getRandomState());

		return taxiInfo;
	}

	private TaxiRoute getTaxiRoute(long taxiId)
	{
		TaxiRoute taxiRoute = taxiRouteMap.get(taxiId);
		// if no route, assign one
		if (taxiRoute == null)
		{
			taxiRoute = getNextTaxiRoute();
			taxiRouteMap.put(taxiId, taxiRoute);
		}
		return taxiRoute;
	}

	private TaxiRoute getNextTaxiRoute()
	{
		TaxiRoute result = null;

		if (taxiRoutes.isEmpty())
		{
			loadTaxiRoutes();
		}
		if (!taxiRoutes.isEmpty())
		{
			result = taxiRoutes.get(taxiRouteIndex);
			taxiRouteIndex = (taxiRouteIndex < (taxiRoutes.size() - 1)) ? (taxiRouteIndex + 1) : 0;
		}

		return result;
	}

	private void loadTaxiRoutes()
	{
		List<SimulationRoute> simRoutes = baseDAO.getAll(SimulationRoute.class);
		for (SimulationRoute simRoute : simRoutes)
		{
			TaxiRoute newTaxiRoute = new TaxiRoute();

			String[] locations = StringUtils.split(simRoute.getValue(), "|");

			for (String location : locations)
			{
				String[] latlngDelta = StringUtils.split(location, ",");

				String lat = (Double.parseDouble(latlngDelta[0].trim()) - 0.006)+ "";
				String lng = Double.parseDouble(latlngDelta[1].trim()) + "";
				// String lat = (Double.parseDouble(stationLocation.getCoordinateX().trim()) +
				// Double.parseDouble(latlngDelta[0].trim())) + "";
				// String lng = (Double.parseDouble(stationLocation.getCoordinateY().trim()) +
				// Double.parseDouble(latlngDelta[1].trim())) + "";

				newTaxiRoute.getLocations().add(new Location(lat, lng));
			}
			taxiRoutes.add(newTaxiRoute);
		}
	}

	public BaseDAO getBaseDAO()
	{
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO)
	{
		this.baseDAO = baseDAO;
	}

	public Location getStationLocation()
	{
		return stationLocation;
	}

	public void setStationLocation(Location stationLocation)
	{
		this.stationLocation = stationLocation;
	}

	public Map<Long, TaxiRoute> getTaxiRouteMap()
	{
		return taxiRouteMap;
	}

	public void setTaxiRouteMap(Map<Long, TaxiRoute> taxiRouteMap)
	{
		this.taxiRouteMap = taxiRouteMap;
	}

	public List<TaxiRoute> getTaxiRoutes()
	{
		return taxiRoutes;
	}

	public void setTaxiRoutes(List<TaxiRoute> taxiRoutes)
	{
		this.taxiRoutes = taxiRoutes;
	}

	public int getTaxiRouteIndex()
	{
		return taxiRouteIndex;
	}

	public void setTaxiRouteIndex(int taxiRouteIndex)
	{
		this.taxiRouteIndex = taxiRouteIndex;
	}

}
