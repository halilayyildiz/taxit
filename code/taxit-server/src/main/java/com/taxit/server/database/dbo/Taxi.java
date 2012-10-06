package com.taxit.server.database.dbo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "TBL_TAXI")
public class Taxi extends DomainObjectBase
{
	private static final long	serialVersionUID	= 1365365468984721661L;

	@Column(name = "FLD_BRAND")
	private String				brand;

	@Column(name = "FLD_MODEL")
	private String				model;

	@Column(name = "FLD_PRODUCTION_YEAR")
	private String				productionYear;

	@Column(name = "FLD_ENGINE_NUMBER")
	private String				engineNumber;

	@Column(name = "FLD_PLATE", unique = true)
	@Index(name = "IDX_PLATE")
	private String				plate;

	@ManyToOne
	@JoinColumn(name = "FLD_STATION_ID")
	private Station				station				= new Station();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FLD_LOCATION_ID")
	private Location			location			= new Location();

	@Column(name = "FLD_STATE")
	@Enumerated(EnumType.STRING)
	private TaxiState			state;

	public Taxi()
	{

	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public String getProductionYear()
	{
		return productionYear;
	}

	public void setProductionYear(String productionYear)
	{
		this.productionYear = productionYear;
	}

	public String getEngineNumber()
	{
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber)
	{
		this.engineNumber = engineNumber;
	}

	public String getPlate()
	{
		return plate;
	}

	public void setPlate(String plate)
	{
		this.plate = plate;
	}

	public Station getStation()
	{
		return station;
	}

	public void setStation(Station station)
	{
		this.station = station;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

	public TaxiState getState()
	{
		return state;
	}

	public void setState(TaxiState state)
	{
		this.state = state;
	}

}
