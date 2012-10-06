package com.taxit.server.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.taxit.server.database.dbo.TaxiState;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "taxiPlate", "driverName", "taxiLatLng", "taxiState" })
public class TaxiStatus
{
	@XmlElement(name = "tplate")
	private String		taxiPlate	= null;

	@XmlElement(name = "dname")
	private String		driverName	= null;

	@XmlElement(name = "latlng")
	private String		taxiLatLng	= null;

	@XmlElement(name = "tstate")
	private TaxiState	taxiState	= null;

	public TaxiStatus()
	{

	}

	public String getTaxiPlate()
	{
		return taxiPlate;
	}

	public void setTaxiPlate(String taxiPlate)
	{
		this.taxiPlate = taxiPlate;
	}

	public String getDriverName()
	{
		return driverName;
	}

	public void setDriverName(String driverName)
	{
		this.driverName = driverName;
	}

	public String getTaxiLatLng()
	{
		return taxiLatLng;
	}

	public void setTaxiLatLng(String taxiLatLng)
	{
		this.taxiLatLng = taxiLatLng;
	}

	public TaxiState getTaxiState()
	{
		return taxiState;
	}

	public void setTaxiState(TaxiState taxiState)
	{
		this.taxiState = taxiState;
	}

}
