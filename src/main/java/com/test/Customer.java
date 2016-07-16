package com.test;

import org.springframework.data.annotation.Id;


public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String jobName;
    private double salary;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setJobName("Default");
        this.setSalary(0.0);
    }

    public Customer(String firstName, String lastName, String jobName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setJobName(jobName);
        this.setSalary(0.0);
    }
    
    public Customer(String firstName, String lastName, String jobName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setJobName(jobName);
        this.setSalary(salary);
    }
    
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', jonNam=%s, salary=%s]",
                id, firstName, jobName, lastName, salary);
    }

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}

