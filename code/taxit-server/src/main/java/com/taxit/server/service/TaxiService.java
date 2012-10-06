package com.taxit.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxit.server.database.dao.TaxiDAO;
import com.taxit.server.database.dbo.Location;
import com.taxit.server.database.dbo.LocationHistory;
import com.taxit.server.database.dbo.Taxi;

@Service
public class TaxiService
{
	// private final Log log = LogFactory.getLog(getClass());

	private TaxiDAO	taxiDAO;

	@Autowired
	public TaxiService(TaxiDAO taxiDAO)
	{
		this.taxiDAO = taxiDAO;
	}

	public Taxi addNewTaxi(Taxi taxi)
	{
		return taxiDAO.save(taxi);
	}

	public void deleteTaxi(Taxi taxi)
	{
		taxiDAO.delete(taxi);
	}

	public void updateTaxi(Taxi taxi)
	{
		taxiDAO.update(taxi);
	}

	public void changeTaxiLocation(String plate, Location newLocation)
	{
		Taxi taxi = taxiDAO.getTaxiByPlate(plate);

		// first save old location to history
		LocationHistory locationHistory = new LocationHistory();
		locationHistory.setTaxi(taxi);
		locationHistory.setLocation(taxi.getLocation());
		taxiDAO.save(locationHistory);

		// then set new location
		taxi.setLocation(newLocation);
		taxiDAO.update(taxi);
	}

	public List<Taxi> getAllTaxi()
	{
		List<Taxi> taxiList = taxiDAO.getAll(Taxi.class);
		return taxiList;
	}

}
