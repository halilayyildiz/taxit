package com.taxit.common.exception;



public class TaxitConfigException extends TaxitBaseException
{
	private static final long	serialVersionUID	= -3181386788918057550L;

	public TaxitConfigException(String msg, Throwable t)
	{
		super(msg, t);
	}

	public TaxitConfigException(Throwable t)
	{
		super(t);
	}

	public TaxitConfigException(String msg)
	{
		super(msg);
	}
}
