package com.lov2code.springdemo.validator;

import org.springframework.stereotype.Component;

@Component
public class TelNumberValidator 
{
	public boolean executeTelNumberStrategy(TelNumberStrategy telNumberStrategy, String telNumber)
	{
		return telNumberStrategy.doTelNumberValidation(telNumber);
	}
}
