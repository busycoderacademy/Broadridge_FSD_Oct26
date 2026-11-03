package com.java8.session1.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoLabAssigment {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(101, "Amit", "IT", 75000),
                new Employee(102, "Rahul", "HR", 45000),
                new Employee(103, "Neha", "IT", 90000),
                new Employee(104, "Priya", "Finance", 60000),
                new Employee(105, "Amit", "Sales", 55000),
                new Employee(106, "Karan", "IT", 35000),
                new Employee(107, "Neha", "Finance", 85000),
                new Employee(108, "Simran", "HR", 50000),
                new Employee(109, "Raj", "Sales", 65000),
                new Employee(110, "Pooja", "IT", 80000)
        ));
        //Task 1: Display Employee Details
        employees.stream().forEach(e-> System.out.println(e));
        //Task 2: Search Employees
    }
}
