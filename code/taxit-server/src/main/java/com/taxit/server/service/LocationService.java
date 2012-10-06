package com.taxit.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxit.server.database.dao.TaxiDAO;
import com.taxit.server.database.dao.UserDAO;
import com.taxit.server.database.dbo.LocationHistory;
import com.taxit.server.database.dbo.Operator;
import com.taxit.server.database.dbo.Station;
import com.taxit.server.database.dbo.Taxi;
import com.taxit.server.remote.LocationAPIConnectorImpl;
import com.taxit.server.remote.simulation.TaxiInfo;
import com.taxit.server.rest.StationStatusResult;
import com.taxit.server.rest.TaxiStatus;
import com.taxit.server.rest.TaxiStatusResult;

/**
 * Encapsulates top level location related operations.
 */
@Service
public class LocationService
{
	// private final Log log = LogFactory.getLog(getClass());

	private LocationAPIConnectorImpl	connector;
	private UserDAO						userDAO;
	private TaxiDAO						taxiDAO;

	@Autowired
	public LocationService(LocationAPIConnectorImpl connector, UserDAO userDAO, TaxiDAO taxiDAO)
	{
		this.connector = connector;
		this.userDAO = userDAO;
		this.taxiDAO = taxiDAO;
	}

	public StationStatusResult getStationStatus(String operatorUsername)
	{
		StationStatusResult result = new StationStatusResult();

		Operator operator = userDAO.getOperatorByUsername(operatorUsername);

		result.setOperatorName(operator.getPerson().getName() + " " + operator.getPerson().getSurname());
		result.setStationName(operator.getStation().getName());
		result.setStationLatLng(operator.getStation().getLocation().getCoordinateX() + "," + operator.getStation().getLocation().getCoordinateY());

		return result;
	}

	public TaxiStatusResult getTaxiStatus(String operatorUsername)
	{
		TaxiStatusResult result = new TaxiStatusResult();

		Station station = userDAO.getOperatorByUsername(operatorUsername).getStation();
		List<Taxi> taxiList = taxiDAO.getTaxiOfStation(station.getId());

		// set station location for simulator
		connector.getSimulator().setStationLocation(station.getLocation());

		for (Taxi taxi : taxiList)
		{
			// first record old location to history
			LocationHistory locationHistory = new LocationHistory();
			locationHistory.setTaxi(taxi);
			locationHistory.setLocation(taxi.getLocation());
			locationHistory.setState(taxi.getState());
			taxiDAO.save(locationHistory);

			// then set new location
			TaxiInfo taxiInfo = connector.getTaxiInfo(taxi.getId());
			taxi.getLocation().setCoordinateX(taxiInfo.getLocation().getCoordinateX());
			taxi.getLocation().setCoordinateY(taxiInfo.getLocation().getCoordinateY());
			taxi.setState(taxiInfo.getState());
			taxiDAO.update(taxi);

			// and prepare taxi status
			TaxiStatus taxiStatus = new TaxiStatus();

			taxiStatus.setTaxiPlate(taxi.getPlate());
			taxiStatus.setTaxiLatLng(taxiInfo.getLocation().getCoordinateX() + "," + taxiInfo.getLocation().getCoordinateY());
			taxiStatus.setTaxiState(taxiInfo.getState());
			taxiStatus.setDriverName("todo");

			result.getTaxiStatusList().add(taxiStatus);
		}

		return result;
	}

	public LocationAPIConnectorImpl getConnector()
	{
		return connector;
	}

	public void setConnector(LocationAPIConnectorImpl connector)
	{
		this.connector = connector;
	}

	public TaxiDAO getTaxiDAO()
	{
		return taxiDAO;
	}

	public void setTaxiDAO(TaxiDAO taxiDAO)
	{
		this.taxiDAO = taxiDAO;
	}

	public UserDAO getUserDAO()
	{
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

}
