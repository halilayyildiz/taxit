package com.taxit.server.database.dbo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_DRIVER")
public class Driver extends DomainObjectBase
{
	private static final long	serialVersionUID	= 1365365468984721661L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FLD_PERSON_ID")
	private Person				person				= new Person();

	@ManyToOne
	@JoinColumn(name = "FLD_TAXI_ID")
	private Taxi				taxi				= new Taxi();

	public Driver()
	{

	}

	public Person getPerson()
	{
		return person;
	}

	public void setPerson(Person person)
	{
		this.person = person;
	}

	public Taxi getTaxi()
	{
		return taxi;
	}

	public void setTaxi(Taxi taxi)
	{
		this.taxi = taxi;
	}

}
