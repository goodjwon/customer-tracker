package com.lov2code.springdemo.service;

import com.lov2code.springdemo.dto.CustomerDto;
import com.lov2code.springdemo.entitiy.Customer;

import java.util.List;

public interface CustomerService {

    public List<CustomerDto> getCustomers();

    public Customer saveCustomer(Customer customer);

    public Customer getCustomer(Integer theId);

    public void deletCustomer(Integer thdId);

}
