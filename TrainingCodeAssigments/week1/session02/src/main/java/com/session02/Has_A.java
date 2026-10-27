package com.session02;
import java.util.*; // collection api lib: aka readymade dsa
//Company have many employee: DSA : LinkedList
class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public void showEmployee(){
        System.out.println("showEmployee: "+id+" "+name+" "+salary);
    }
}
//Company have many employee: DSA : LinkedList

//Companay<>---------Employee

class Company {
    private String name;
    private LinkedList<Employee> employees;

   public Company(String name) {
        this.name = name;
       this.employees=new LinkedList<>();
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public  void printCompanayDetails(){
        System.out.println("Company: "+name);

        for(Employee employee: employees){
            employee.showEmployee();
        }
    }
}
public class Has_A {
    public static void main(String[] args) {
        Employee employee=new Employee(1,"John",10000);
        Company company=new Company("Broadridge");
        company.addEmployee(employee);
        company.addEmployee(new Employee(2,"Jane",20000));
        company.addEmployee(new Employee(3,"Jack",30000));
        company.addEmployee(new Employee(4,"Jill",40000));
        company.addEmployee(new Employee(5,"ravi",40000));

        company.printCompanayDetails();
    }
}
