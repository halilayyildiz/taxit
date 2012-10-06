package com.taxit.server.database.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.taxit.server.database.dbo.Taxi;

@Repository
public class TaxiDAO extends BaseDAO
{
	// private final Log log = LogFactory.getLog(getClass());

	public TaxiDAO()
	{

	}

	public Taxi getTaxiByPlate(String plate)
	{
		@SuppressWarnings("unchecked")
		List<Taxi> list = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Taxi.class, "taxi").add(Restrictions.eq("taxi.plate", plate)));
		return list.iterator().hasNext() ? list.iterator().next() : null;
	}

	public List<Taxi> getTaxiOfStation(long stationId)
	{
		@SuppressWarnings("unchecked")
		List<Taxi> list = getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(Taxi.class, "taxi").add(Restrictions.eq("taxi.station.id", stationId)));
		return list;
	}
}
