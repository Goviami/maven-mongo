package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
		
//		BasicQ

//		System.out.println("query2 - " + query2.toString());
//		System.out.println("userTest2 - " + userTest2);

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));
		repository.save(new Customer("Donald", "Duck", "Engineer", 7000));
		repository.save(new Customer("Donald", "Allan", "Cricket", 8000));
		repository.save(new Customer("Lee", "Brett", "Cricket", 9000));
		repository.save(new Customer("Lara", "Brian", "Cricket", 10000));
		repository.save(new Customer("Richards", "Vivian", "Cricket", 10000.00));

		BasicQuery query1 = new BasicQuery("{ salary : { $gt : 40 } }");
		//Query query1 = new Query();
		System.out.println("query1 - " + query1.toString());
		query1.addCriteria(Criteria.where("salary").gte(7000));
		
		// fetch all customers
		System.out.println("Customers with salary > 8K");
		System.out.println("-------------------------------");
		Customer custObj = repository.findOne(query1.toString());
		System.out.println(custObj);
		
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
		
		System.out.println("Customers found with findBySalaryLessThan('10 - K'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findBySalaryLessThan(10000)) {
			System.out.println(customer);
		}
	}

}
