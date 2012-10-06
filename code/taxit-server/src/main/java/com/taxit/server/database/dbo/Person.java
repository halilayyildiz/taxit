package com.taxit.server.database.dbo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "TBL_PERSON")
public class Person extends DomainObjectBase
{
	private static final long	serialVersionUID	= 1365365468984721661L;

	@Column(name = "FLD_NAME", length = 128)
	private String				name;

	@Column(name = "FLD_SURNAME", length = 128)
	private String				surname;

	@Column(name = "FLD_EMAIL", length = 128, unique = true)
	@Index(name = "IDX_EMAIL")
	private String				email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FLD_BIRTH_DATE")
	private Date				birthDate;

	@Column(name = "FLD_PHONE_NUMBER", length = 16, unique = true)
	private String				phoneNumber;

	public Person()
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

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Date getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode()
	{
		return getEmail().hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Person)
		{
			Person tmp = (Person) obj;
			return hashCode() == tmp.hashCode();
		}
		return false;
	}

}
