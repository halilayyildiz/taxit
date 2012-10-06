package com.taxit.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxit.server.database.dao.LocationHistoryDAO;
import com.taxit.server.database.dbo.LocationHistory;
import com.taxit.server.database.dbo.Taxi;

@Service
public class ReportService
{
	// private final Log log = LogFactory.getLog(getClass());

	private LocationHistoryDAO	locationHistoryDAO;

	@Autowired
	public ReportService(LocationHistoryDAO locationHistoryDAO)
	{
		this.locationHistoryDAO = locationHistoryDAO;
	}

	public List<LocationHistory> getTaxiLocationHistory(Taxi taxi)
	{
		return locationHistoryDAO.getLocationHistory(taxi);
	}

	public List<LocationHistory> getAllTaxiLocationHistory()
	{
		return locationHistoryDAO.getAllLocationHistory();
	}

	public LocationHistoryDAO getLocationHistoryDAO()
	{
		return locationHistoryDAO;
	}

	public void setLocationHistoryDAO(LocationHistoryDAO locationHistoryDAO)
	{
		this.locationHistoryDAO = locationHistoryDAO;
	}

}
