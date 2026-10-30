package com.session3code.ex1.empmgt2;
//create Employee class, PartTimeEmployee class, FullTimeEmployee class
//create EmployeeMgt class
abstract class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void pay() {
        System.out.println("Employee Salary: " + salary);
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    void pay() {
        System.out.println("Part Time Employee: " + name);
        System.out.println("Monthly Salary: " + salary);
    }
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    void pay() {
        System.out.println("Full Time Employee: " + name);
        System.out.println("Monthly Salary: " + salary);
    }
}

public class F_EmployeeMgt {
    public static void main(String[] args) {
        Employee e1 = new PartTimeEmployee(101, "Rahul", 15000);

        Employee e2 = new FullTimeEmployee(102, "Amit", 50000);
        e1.pay();
        System.out.println();
        e2.pay();
    }
}
