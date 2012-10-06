package com.taxit.server.exception;

import com.taxit.common.exception.TaxitBaseException;

public class TaxitServerException extends TaxitBaseException
{
	private static final long	serialVersionUID	= -3181386788918057550L;

	public TaxitServerException(String msg, Throwable t)
	{
		super(msg, t);
	}

	public TaxitServerException(Throwable t)
	{
		super(t);
	}

	public TaxitServerException(String msg)
	{
		super(msg);
	}
}
