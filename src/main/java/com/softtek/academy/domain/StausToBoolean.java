package com.softtek.academy.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class StausToBoolean implements AttributeConverter<String, Boolean> {

	@Override
	public Boolean convertToDatabaseColumn(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String convertToEntityAttribute(Boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
