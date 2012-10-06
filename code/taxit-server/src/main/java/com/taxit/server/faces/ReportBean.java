package com.taxit.server.faces;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.taxit.server.database.dbo.LocationHistory;
import com.taxit.server.database.dbo.Taxi;
import com.taxit.server.service.ReportService;

@ManagedBean
@ViewScoped
public class ReportBean implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	// private static final Log log = LogFactory.getLog(ReportBean.class);

	@ManagedProperty(value = "#{reportService}")
	private ReportService		reportService;

	private Taxi				selectedTaxi		= null;

	public ReportBean()
	{

	}

	public void handleTaxiSelect()
	{

	}

	public List<LocationHistory> getTaxiLocationHistory()
	{
		List<LocationHistory> result = null;

		if (selectedTaxi != null)
		{
			result = reportService.getTaxiLocationHistory(selectedTaxi);
		}
		else
		{
			result = reportService.getAllTaxiLocationHistory();
		}

		return result;
	}

	// getter & setter

	public ReportService getReportService()
	{
		return reportService;
	}

	public void setReportService(ReportService reportService)
	{
		this.reportService = reportService;
	}

	public Taxi getSelectedTaxi()
	{
		return selectedTaxi;
	}

	public void setSelectedTaxi(Taxi selectedTaxi)
	{
		this.selectedTaxi = selectedTaxi;
	}

}
