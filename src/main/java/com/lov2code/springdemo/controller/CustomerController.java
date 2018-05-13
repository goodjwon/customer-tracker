package com.lov2code.springdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lov2code.springdemo.dto.CustomerDto;
import com.lov2code.springdemo.entitiy.Customer;
import com.lov2code.springdemo.service.CustomerService;
import com.lov2code.springdemo.validator.BindingValidationResult;
import com.lov2code.springdemo.validator.CustomerValidator;

@Controller
@RequestMapping("/customer")
public class CustomerController 
{
	private CustomerService service;
	private ModelMapper modelMapper;

	@Autowired
	private CustomerValidator customerValidator;
	
	@Autowired
	public void setRepository(CustomerService service) 
	{
		this.service = service;
	}

	@GetMapping("/list")
	public String listCustomers(Model model) 
	{
		List<Customer> theCustomers = service.getCustomers();

		List<CustomerDto> result = new ArrayList<>();

		for (Customer customer : theCustomers) 
		{
			result.add(convertToDto(customer));
		}

		model.addAttribute("customer", result);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) 
	{
		Customer theCustomer = new Customer();

		model.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) 
		{
			return "customer-form";
		}

		service.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") Integer theId, Model theModel) 
	{
		// get hte customer from the database
		Customer theCustomer = service.getCustomer(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to our form
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") Integer theId) 
	{
		service.deletCustomer(theId);

		return "redirect:/customer/list";
	}

	@GetMapping("/realtimeUserIdCheck")
	@ResponseBody
	public String realtimeUserIdCheck(@RequestParam("userId") String userId) 
	{
		BindingValidationResult userValidationResult = customerValidator.isUserIdCorrect(userId);

		return userValidationResult.getValidationMessage();
	}

	/**
	 * 이거 위치를 어떻게 해야하니.. 
	 * 1. 컨트롤러에 위치 
	 * 2. 각 엔티티나 Dto에 위치 
	 * 3. 서비스에 위치..
	 * 
	 * @param dto
	 * @return
	 */
	private Customer convertToEntity(CustomerDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Customer.class);
	}

	private CustomerDto convertToDto(Customer customer) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(customer, CustomerDto.class);
	}
}
