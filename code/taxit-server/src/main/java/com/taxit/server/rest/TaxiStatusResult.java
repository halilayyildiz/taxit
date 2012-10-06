package com.taxit.server.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "taxiStatusList" })
public class TaxiStatusResult
{
	@XmlElement(name = "tlist")
	private List<TaxiStatus>	taxiStatusList	= new ArrayList<TaxiStatus>();

	public TaxiStatusResult()
	{

	}

	public List<TaxiStatus> getTaxiStatusList()
	{
		return taxiStatusList;
	}

	public void setTaxiStatusList(List<TaxiStatus> taxiStatusList)
	{
		this.taxiStatusList = taxiStatusList;
	}

}
