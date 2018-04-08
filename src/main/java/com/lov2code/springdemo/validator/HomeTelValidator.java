package com.lov2code.springdemo.validator;

public class HomeTelValidator implements TelNumberStrategy  
{
	private static String homeNumberPattern = "(02|03[1-3]|04[1-4]|05[1-5]|06[1-4])-(\\d{3})-(\\d{4})";
	
	@Override
	public boolean doTelNumberValidation(String telNumber) 
	{
		// TODO Auto-generated method stub
		return telNumber.matches(homeNumberPattern);
	}
	
}
