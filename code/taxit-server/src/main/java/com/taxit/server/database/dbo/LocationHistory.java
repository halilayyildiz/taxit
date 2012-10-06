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

@Entity
@Table(name = "TBL_LOCATION_HISTORY")
public class LocationHistory extends DomainObjectBase
{
	private static final long	serialVersionUID	= 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FLD_TAXI_ID")
	private Taxi				taxi;

	@OneToOne
	@JoinColumn(name = "FLD_LOCATION_ID")
	private Location			location;

	@Column(name = "FLD_STATE")
	@Enumerated(EnumType.STRING)
	private TaxiState			state;

	public LocationHistory()
	{

	}

	public Taxi getTaxi()
	{
		return taxi;
	}

	public void setTaxi(Taxi taxi)
	{
		this.taxi = taxi;
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
