package com.lov2code.springdemo.validator;

public class MobileValidator implements TelNumberStrategy
{
	private static String mobilePattern = "(01[01678])-(\\d{4})-(\\d{4})";
	
	@Override
	public boolean doTelNumberValidation(String telNumber) 
	{
		return telNumber.matches(mobilePattern);
	}
}
