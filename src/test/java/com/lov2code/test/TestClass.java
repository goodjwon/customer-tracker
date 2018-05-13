package com.lov2code.test;

import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestClass 
{
	private String mobilePattern = "(01[01678])-(\\d{4})-(\\d{4})";
	private String userIdPattern = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
	private String telephonePattern = "(02|03[1-3]|04[1-4]|05[1-5]|06[1-4])-(\\d{3})-(\\d{4})";
	private String emailPattern = "[a-zA-Z]{1}[a-zA-Z0-9_]+@[a-zA-Z]+\\.[a-zA-Z]+$";
	
	@Test
	public void test()
	{
		System.out.println(Pattern.matches(mobilePattern, "010-7652-7885"));
	}
}
