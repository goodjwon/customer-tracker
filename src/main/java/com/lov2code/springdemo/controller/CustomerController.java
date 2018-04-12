package com.lov2code.springdemo.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lov2code.springdemo.entitiy.Customer;
import com.lov2code.springdemo.service.CustomerService;
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
    public String showFormForUpdate(@RequestParam("customerId") Integer theId, Model theModel){

        //get hte customer from the database
        Customer theCustomer = service.getCustomer(theId);

        //set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        //send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") Integer theId){

        service.deletCustomer(theId);

        return "redirect:/customer/list";
    }
}
