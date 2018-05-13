package com.lov2code.springdemo.validator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BindingValidationResult 
{
	private boolean validationResultBoolean;
	private String validationMessage;
	
	public BindingValidationResult(boolean validationResultBoolean, String validationErrorMessage)
	{
		this.validationResultBoolean = validationResultBoolean;
		this.validationMessage = validationErrorMessage;
	}
}
