package com.taxit.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.taxit.server.database.dao.StationDAO;
import com.taxit.server.database.dao.UserDAO;
import com.taxit.server.database.dbo.Operator;
import com.taxit.server.database.dbo.Station;

@Service
public class StationService
{
	// private final Log log = LogFactory.getLog(getClass());

	private StationDAO	stationDAO;
	private UserDAO		userDAO;

	@Autowired
	public StationService(StationDAO stationDAO, UserDAO userDAO)
	{
		this.stationDAO = stationDAO;
		this.userDAO = userDAO;
	}

	public Station getStation()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null)
		{
			String operatorUsername = auth.getName();
			Station station = userDAO.getOperatorByUsername(operatorUsername).getStation();
			return station;
		}
		return null;
	}

	public Station getStation(long id)
	{
		return stationDAO.get(Station.class, id);
	}

	public Station addNewStation(Station station, String operatorUsername)
	{
		Station newStation = stationDAO.save(station);

		// assign station to operator
		Operator operator = userDAO.getOperatorByUsername(operatorUsername);
		operator.setStation(newStation);
		userDAO.update(operator);

		return newStation;
	}

	public void deleteStation(Station station)
	{
		stationDAO.delete(station);
	}

	public void updateStation(Station station)
	{
		stationDAO.update(station);
	}

	// public void addTaxiToStation(String stationId, Taxi newTaxi)
	// {
	// Station station = stationDAO.getSationByStationId(stationId);
	// station.getTaxiList().add(newTaxi);
	// stationDAO.update(station);
	// }

	public List<Station> getAllStations()
	{
		List<Station> stations = stationDAO.getAll(Station.class);
		return stations;
	}

}
