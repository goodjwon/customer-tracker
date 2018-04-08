package com.lov2code.springdemo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lov2code.springdemo.entitiy.Customer;
import com.lov2code.springdemo.service.CustomerService;
import com.lov2code.springdemo.validator.HomeTelValidator;
import com.lov2code.springdemo.validator.MobileValidator;
import com.lov2code.springdemo.validator.TelNumberValidator;

@Controller
@RequestMapping("/customer")
public class CustomerController 
{
    private CustomerService service;
    
    @Autowired
    private TelNumberValidator telNumberValidator;

    @Autowired
    public void setRepository(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {

        List<Customer> theCustomers = service.getCustomers();

        model.addAttribute("customer", theCustomers);


        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Customer theCustomer = new Customer();

        model.addAttribute("customer", theCustomer);


        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        service.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") Integer theId, Model theModel){

        //get hte customer from the database
        Customer theCustomer = service.getCustomer(theId);

        //set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        //send over to our form
        return "customer-form";
    }

    @RequestMapping("/telValidator")
    @ResponseBody
    public String validationTelNumber(@RequestParam String homeTel, @RequestParam String mobile)
    {
    	String param = "";
    	String result = "";
    	
    	param += "Home tel : " + homeTel + " / " + "Mobile : " + mobile + " / ";
    	
    	result += "Home Tel result : " + telNumberValidator.executeTelNumberStrategy(new HomeTelValidator(), homeTel);
    	result += " / ";
    	result += "Mobile result : " + telNumberValidator.executeTelNumberStrategy(new MobileValidator(), mobile);
    	
    	return param + " " + result;
    }
}
