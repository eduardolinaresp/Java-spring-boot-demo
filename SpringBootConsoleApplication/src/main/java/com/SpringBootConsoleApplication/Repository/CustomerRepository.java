package com.SpringBootConsoleApplication.Repository;

import com.SpringBootConsoleApplication.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long>   {
}
