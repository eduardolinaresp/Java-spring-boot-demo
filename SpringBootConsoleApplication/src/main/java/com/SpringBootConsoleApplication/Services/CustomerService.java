package com.SpringBootConsoleApplication.Services;

import com.SpringBootConsoleApplication.Models.Customer;
import com.SpringBootConsoleApplication.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}
