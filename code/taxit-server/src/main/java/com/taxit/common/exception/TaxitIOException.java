package com.taxit.common.exception;

public class TaxitIOException extends TaxitBaseException
{
	private static final long	serialVersionUID	= -3181386788918057550L;

	public TaxitIOException(String msg, Throwable t)
	{
		super(msg, t);
	}

	public TaxitIOException(Throwable t)
	{
		super(t);
	}

	public TaxitIOException(String msg)
	{
		super(msg);
	}
}
