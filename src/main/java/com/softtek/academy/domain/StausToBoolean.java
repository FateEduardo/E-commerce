package com.softtek.academy.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class StausToBoolean  implements AttributeConverter<Boolean, String>{

	@Override
	public String convertToDatabaseColumn(Boolean status) {
		// TODO Auto-generated method stub
		return (status)?"S":"N"; 
	}

	@Override
	public Boolean convertToEntityAttribute(String status) {
		// TODO Auto-generated method stub
		return (status.equals("S"))?true:false;
		
	}

}
