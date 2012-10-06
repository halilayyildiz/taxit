package com.taxit.server.faces;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.taxit.server.database.dbo.Station;
import com.taxit.server.database.dbo.Taxi;
import com.taxit.server.service.StationService;
import com.taxit.server.service.TaxiService;
import com.taxit.server.util.FacesUtil;
import com.taxit.server.util.Navigations;

@ManagedBean
@RequestScoped
public class TaxiBean implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	// private static final Log log = LogFactory.getLog(TaxiBean.class);

	@ManagedProperty(value = "#{taxiService}")
	private TaxiService			taxiService;

	@ManagedProperty(value = "#{stationService}")
	private StationService		stationService;

	private Taxi				taxi				= new Taxi();
	private Taxi				selectedTaxi		= new Taxi();

	public TaxiBean()
	{

	}

	public void handleTaxiSelect()
	{
		taxi = selectedTaxi;
	}

	public String addNewTaxi()
	{
		Station station = stationService.getStation();
		taxi.setStation(station);
		taxiService.addNewTaxi(taxi);
		FacesUtil.setFacesMessage(FacesMessage.SEVERITY_INFO, "success", "newTaxiAdded");
		taxi = new Taxi();
		selectedTaxi = new Taxi();
		return Navigations.GOTO_NEW_TAXI_PAGE;
	}

	public String updateTaxi()
	{
		taxiService.updateTaxi(taxi);
		FacesUtil.setFacesMessage(FacesMessage.SEVERITY_INFO, "success", "taxiUpdated");
		taxi = new Taxi();
		selectedTaxi = new Taxi();
		return Navigations.GOTO_EDIT_TAXI_PAGE;
	}

	public String deleteTaxi()
	{
		taxiService.deleteTaxi(taxi);
		FacesUtil.setFacesMessage(FacesMessage.SEVERITY_INFO, "success", "taxiDeleted");
		taxi = new Taxi();
		selectedTaxi = new Taxi();
		return Navigations.GOTO_EDIT_TAXI_PAGE;
	}

	public List<Taxi> getAllTaxi()
	{
		return taxiService.getAllTaxi();
	}

	// getter & setter

	public Taxi getTaxi()
	{
		return taxi;
	}

	public TaxiService getTaxiService()
	{
		return taxiService;
	}

	public void setTaxiService(TaxiService taxiService)
	{
		this.taxiService = taxiService;
	}

	public StationService getStationService()
	{
		return stationService;
	}

	public void setStationService(StationService stationService)
	{
		this.stationService = stationService;
	}

	public void setTaxi(Taxi taxi)
	{
		this.taxi = taxi;
	}

	public Taxi getSelectedTaxi()
	{
		return selectedTaxi;
	}

	public void setSelectedTaxi(Taxi selectedTaxi)
	{
		this.selectedTaxi = selectedTaxi;
	}

}
