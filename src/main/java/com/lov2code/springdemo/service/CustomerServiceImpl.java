package com.lov2code.springdemo.service;

import com.lov2code.springdemo.dao.CustomerRepository;
import com.lov2code.springdemo.dto.CustomerDto;
import com.lov2code.springdemo.entitiy.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;

    @Autowired
    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> getCustomers() {

       List<Customer> customers = (List<Customer>) repository.findAll();
//       List<CustomerDto> result  = new ArrayList<>();

//       for(Customer customer:customers){
//           CustomerDto dto = new CustomerDto();
//           dto.setFirstName(customer.getFirstName());
//           dto.setEmail(customer.getEmail());
//           dto.setHome_tel(customer.getHome_tel());
//           dto.setLastName(customer.getLastName());
//           dto.setUser_id(customer.getUser_id());
//           dto.setId(customer.getId());
//
//           result.add(dto);
//       }

       return (List<Customer>) repository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer getCustomer(Integer theId) { return repository.findOne(theId); }

    @Override
    public void deletCustomer(Integer thdId) {
        repository.delete(thdId);
    }
}
