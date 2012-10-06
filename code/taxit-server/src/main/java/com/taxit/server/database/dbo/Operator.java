package com.taxit.server.database.dbo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import com.taxit.server.UserRole;

@Entity
@Table(name = "TBL_OPERATOR")
public class Operator extends DomainObjectBase
{
	private static final long	serialVersionUID	= 1365365468984721661L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FLD_PERSON_ID")
	private Person				person				= new Person();

	@Column(name = "FLD_ROLE")
	@Enumerated(EnumType.STRING)
	private UserRole			role				= UserRole.ROLE_OPERATOR;

	@Column(name = "FLD_USERNAME", length = 128, unique = true)
	@Index(name = "IDX_USERNAME")
	private String				username;

	@Column(name = "FLD_PASSWORD", length = 128)
	private String				password;

	@OneToOne
	@JoinColumn(name = "FLD_STATION_ID")
	private Station				station				= null;

	public Operator()
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

	public UserRole getRole()
	{
		return role;
	}

	public void setRole(UserRole role)
	{
		this.role = role;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Station getStation()
	{
		return station;
	}

	public void setStation(Station station)
	{
		this.station = station;
	}

}
