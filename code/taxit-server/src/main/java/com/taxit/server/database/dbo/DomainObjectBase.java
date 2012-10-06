package com.taxit.server.database.dbo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class DomainObjectBase implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FLD_ID")
	protected long				id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FLD_STORE_DATE")
	protected Date				storeDate			= new Date();

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Date getStoreDate()
	{
		return storeDate;
	}

	public void setStoreDate(Date date)
	{
		this.storeDate = date;
	}

	@Override
	public int hashCode()
	{
		return Long.valueOf(id).hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof DomainObjectBase)
		{
			return id == ((DomainObjectBase) obj).getId();
		}
		return super.equals(obj);
	}
}
