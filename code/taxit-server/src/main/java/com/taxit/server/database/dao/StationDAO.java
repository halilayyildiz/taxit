package com.taxit.server.database.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.taxit.server.database.dbo.Station;

@Repository
public class StationDAO extends BaseDAO
{
	// private final Log log = LogFactory.getLog(getClass());

	public StationDAO()
	{

	}

	public Station getSationByStationId(String stationId)
	{
		@SuppressWarnings("unchecked")
		List<Station> list = getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(Station.class, "station").add(Restrictions.eq("station.stationId", stationId)));
		return list.iterator().hasNext() ? list.iterator().next() : null;
	}

}
