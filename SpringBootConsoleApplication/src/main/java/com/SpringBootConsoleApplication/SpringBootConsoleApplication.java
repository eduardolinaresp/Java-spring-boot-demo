package com.SpringBootConsoleApplication;

import com.SpringBootConsoleApplication.Models.Customer;
import com.SpringBootConsoleApplication.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

		@Autowired
		private CustomerService _customerService;

	public static void main(String[] args) {

		//SpringApplication.run(SpringBootConsoleApplication.class, args);
		SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {



		for (Customer _customer : _customerService.getCustomers() ) {

			System.out.println(String.format("Customer Name: %s",_customer.getName()));

		}
		 
		   
	}
}
