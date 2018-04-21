package com.lov2code.springdemo.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lov2code.springdemo.entitiy.Customer;
import com.lov2code.springdemo.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerRestfulController 
{
	@Autowired 
	private CustomerServiceImpl customerService;
	
	@RequestMapping(value = "/getCustomerList", method = RequestMethod.GET)
	@ResponseBody
	public String getCustomerlist()
	{
		List<Customer> allCustomerList = customerService.getCustomers();
		
		return createJsonArray(allCustomerList).toString();
	}
	
	public JSONArray createJsonArray(List<Customer> customerList) 
	{
		JSONArray customerJsonArray = new JSONArray();
		
		for(Customer customer : customerList)
		{
			JSONObject customerJson = new JSONObject();

			try 
			{
				customerJson.put("user_id", customer.getUser_id());
				customerJson.put("first_name", customer.getFirstName());
				customerJson.put("last_name", customer.getLastName());
				customerJson.put("email", customer.getEmail());
				customerJson.put("home_tel", customer.getHome_tel());
				customerJson.put("mobile_tel", customer.getMobile_tel());
				
				customerJsonArray.put(customerJson);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return customerJsonArray;
	}
}
