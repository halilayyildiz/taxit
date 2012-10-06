package com.taxit.server.database.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ROUTE")
public class SimulationRoute extends DomainObjectBase
{
	private static final long	serialVersionUID	= 1L;

	@Column(name = "FLD_VALUE", length = 2048)
	private String				value;

	public SimulationRoute()
	{

	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

}
