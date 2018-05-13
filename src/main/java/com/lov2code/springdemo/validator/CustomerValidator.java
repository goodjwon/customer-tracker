package com.lov2code.springdemo.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class CustomerValidator 
{
	private String mobilePattern = "(01[01678])-(\\d{4})-(\\d{4})";
	private String userIdPattern = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
	private String telephonePattern = "(02|03[1-3]|04[1-4]|05[1-5]|06[1-4])-(\\d{3})-(\\d{4})";
	private String emailPattern = "[a-zA-Z]{1}[a-zA-Z0-9_]+@[a-zA-Z]+\\.[a-zA-Z]+$";
	
	public BindingValidationResult isMobilePatternCorrect(String mobileNumber)
	{
		if(Pattern.matches(mobilePattern, mobileNumber))
		{
			return new BindingValidationResult(true, "mobile pattern correct");
		}
		else
		{
			return new BindingValidationResult(false, "Check your mobile number");
		}
	}
	
	public BindingValidationResult isUserIdCorrect(String userId)
	{
		if(Pattern.matches(userIdPattern, userId))
		{
			return new BindingValidationResult(true, "아이디를 사용하실 수 있습니다.");
		}
		else
		{
			return new BindingValidationResult(false, "시작은 영문으로만 가능하며, '영문, 숫자, '_'으로만 이루어진 5 ~ 12자 이하의 문자만 가능합니다.");
		}
	}
	
	public BindingValidationResult isTelephonePatternCorrect(String telephoneNumber)
	{
		if(Pattern.matches(telephonePattern, telephoneNumber))
		{
			return new BindingValidationResult(true, "Telephone number pattern correct");
		}
		else
		{
			return new BindingValidationResult(false, "Check your telephone number");
		}
	}
	
	public BindingValidationResult isEmailPatternCorrect(String email)
	{
		if(Pattern.matches(emailPattern, email))
		{
			return new BindingValidationResult(true, "email pattern correct");
		}
		else
		{
			return new BindingValidationResult(false, "Check your email");
		}
	}
}
