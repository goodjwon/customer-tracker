package com.lov2code.springdemo.service;

import java.util.List;

import com.lov2code.springdemo.entitiy.Customer;

public interface CustomerService {

    public List<Customer> getCustomers();

    public Customer saveCustomer(Customer customer);

    public Customer getCustomer(Integer theId);

    public void deletCustomer(Integer thdId);

}
