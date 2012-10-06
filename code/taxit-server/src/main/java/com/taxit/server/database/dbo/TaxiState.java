package com.taxit.server.database.dbo;

import javax.xml.bind.annotation.XmlEnumValue;

public enum TaxiState
{
	@XmlEnumValue(value = "1")
	FREE, 
	@XmlEnumValue(value = "2")
	OCCUPIED ,
	@XmlEnumValue(value = "3")
	NOTWORKING, 
	@XmlEnumValue(value = "4")
	EMERGENCY
}
