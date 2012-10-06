package com.taxit.common.exception;

public class TaxitBaseException extends RuntimeException
{
	private static final long	serialVersionUID	= -3578398364905352559L;

	public TaxitBaseException()
	{

	}

	public TaxitBaseException(String message, Throwable t)
	{
		super(message, t);
	}

	public TaxitBaseException(Throwable t)
	{
		super(t);
	}

	public TaxitBaseException(String message)
	{
		super(message);
	}
}
