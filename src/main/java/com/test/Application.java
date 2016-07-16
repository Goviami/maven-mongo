package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));
		repository.save(new Customer("Donald", "Duck", "Engineer", 7000));
		repository.save(new Customer("Donald", "Allan", "Cricket", 8000));
		repository.save(new Customer("Lee", "Brett", "Cricket", 9000));
		repository.save(new Customer("Lara", "Brian", "Cricket", 10000));
		repository.save(new Customer("Richards", "Vivian", "Cricket", 10000.00));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}

		System.out.println("Customers found with findByJobName('Engineer'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByJobName("Engineer")) {
			System.out.println(customer);
		}
		
		System.out.println("Customers found with findBySalary('Salary - 10K'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findBySalary(10000.00)) {
			System.out.println(customer);
		}		

		System.out.println("Customers found with findBySalary('Salary'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findBySalary(9000.00)) {
			System.out.println(customer);
		}	
	}

}
