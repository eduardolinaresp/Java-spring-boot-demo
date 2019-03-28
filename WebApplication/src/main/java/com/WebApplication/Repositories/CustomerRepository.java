package com.WebApplication.Repositories;
import com.WebApplication.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>  {

    Customer findByName(String name);
}
