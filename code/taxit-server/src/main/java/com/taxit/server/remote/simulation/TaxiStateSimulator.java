package com.taxit.server.remote.simulation;

import java.util.Random;

import com.taxit.server.database.dbo.TaxiState;

public class TaxiStateSimulator
{
	public static TaxiState getRandomState()
	{
		int nextInt = new Random().nextInt(100);

		if (nextInt < 55)
		{
			return TaxiState.FREE;
		}
		else if (nextInt >= 55 && nextInt < 85)
		{
			return TaxiState.OCCUPIED;
		}
		else if (nextInt >= 85 && nextInt < 96)
		{
			return TaxiState.NOTWORKING;
		}
		else
		{
			return TaxiState.EMERGENCY;
		}
	}
}
