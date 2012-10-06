package com.taxit.server.database.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_LOCATION")
public class Location extends DomainObjectBase
{
	private static final long	serialVersionUID	= 1365365468984721661L;

	@Column(name = "FLD_COORD_X", length = 32)
	private String				coordinateX;

	@Column(name = "FLD_COORD_Y", length = 32)
	private String				coordinateY;

	public Location()
	{

	}

	public Location(String lat, String lng)
	{
		this.coordinateX = lat;
		this.coordinateY = lng;
	}

	public String getCoordinateX()
	{
		return coordinateX;
	}

	public void setCoordinateX(String coordinateX)
	{
		this.coordinateX = coordinateX;
	}

	public String getCoordinateY()
	{
		return coordinateY;
	}

	public void setCoordinateY(String coordinateY)
	{
		this.coordinateY = coordinateY;
	}

	@Override
	public int hashCode()
	{
		return (getId() + "").hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Location)
		{
			Location tmp = (Location) obj;
			return hashCode() == tmp.hashCode();
		}
		return false;
	}

}
