package com.taxit.server.database.dbo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_STATION")
public class Station extends DomainObjectBase
{
	private static final long	serialVersionUID	= 1365365468984721661L;

	@Column(name = "FLD_NAME")
	private String				name;

	@Column(name = "FLD_ADDRESS", length = 512)
	private String				address;

	@Column(name = "FLD_PHONE_NUMBER", length = 16)
	private String				phoneNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FLD_LOCATION_ID")
	private Location			location			= new Location();

	public Station()
	{

	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

}
