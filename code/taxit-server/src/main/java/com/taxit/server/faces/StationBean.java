package com.taxit.server.faces;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.taxit.server.database.dbo.Station;
import com.taxit.server.service.StationService;
import com.taxit.server.util.FacesUtil;
import com.taxit.server.util.Navigations;

@ManagedBean
@RequestScoped
public class StationBean implements Serializable
{
	private static final long	serialVersionUID			= 1L;

	// private static final Log log = LogFactory.getLog(StationBean.class);

	@ManagedProperty(value = "#{stationService}")
	private StationService		stationService;

	private Station				station						= new Station();

	// edit station
	private Station				selectedStation				= new Station();
	private String				registeredOperatorUsername	= null;

	public StationBean()
	{

	}

	@PostConstruct
	public void init()
	{
		Station station = stationService.getStation();
		if (station != null)
		{
			this.station = station;
		}
	}

	public void handleStationSelect()
	{
		station = selectedStation;
	}

	public String addNewStation()
	{
		stationService.addNewStation(station, registeredOperatorUsername);
		FacesUtil.setFacesMessage(FacesMessage.SEVERITY_INFO, "success", "newStationAdded");
		return Navigations.GOTO_HOMEPAGE;
	}

	public String updateStation()
	{
		stationService.updateStation(station);
		FacesUtil.setFacesMessage(FacesMessage.SEVERITY_INFO, "success", "stationUpdated");
		return Navigations.GOTO_EDIT_STATION_PAGE;
	}

	public String deleteStation()
	{
		stationService.deleteStation(station);
		FacesUtil.setFacesMessage(FacesMessage.SEVERITY_INFO, "success", "stationDeleted");
		return Navigations.GOTO_EDIT_STATION_PAGE;
	}

	public List<Station> getAllStations()
	{
		List<Station> stations = stationService.getAllStations();
		return stations;
	}

	public StationService getStationService()
	{
		return stationService;
	}

	public void setStationService(StationService stationService)
	{
		this.stationService = stationService;
	}

	public Station getStation()
	{
		return station;
	}

	public void setStation(Station station)
	{
		this.station = station;
	}

	public Station getSelectedStation()
	{
		return selectedStation;
	}

	public void setSelectedStation(Station selectedStation)
	{
		this.selectedStation = selectedStation;
	}

	public String getRegisteredOperatorUsername()
	{
		return registeredOperatorUsername;
	}

	public void setRegisteredOperatorUsername(String registeredOperatorUsername)
	{
		this.registeredOperatorUsername = registeredOperatorUsername;
	}

}
