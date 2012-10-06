package com.taxit.server.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "stationName", "operatorName", "stationLatLng" })
public class StationStatusResult
{
	@XmlElement(name = "sname")
	private String	stationName		= null;

	@XmlElement(name = "oname")
	private String	operatorName	= null;

	@XmlElement(name = "latlng")
	private String	stationLatLng	= null;

	public StationStatusResult()
	{

	}

	public String getStationName()
	{
		return stationName;
	}

	public void setStationName(String stationName)
	{
		this.stationName = stationName;
	}

	public String getOperatorName()
	{
		return operatorName;
	}

	public void setOperatorName(String operatorName)
	{
		this.operatorName = operatorName;
	}

	public String getStationLatLng()
	{
		return stationLatLng;
	}

	public void setStationLatLng(String stationLatLng)
	{
		this.stationLatLng = stationLatLng;
	}

}
