package com.session3code.ex1.empmgt1;
//create Employee class, PartTimeEmployee class, FullTimeEmployee class
//create EmployeeMgt class
//Payment processing system
interface Payable{
    void pay();

}
abstract class Employee implements  Payable {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

   public void pay() {
        System.out.println("Employee Salary: " + salary);
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public void pay() {
        System.out.println("Part Time Employee: " + name);
        System.out.println("Monthly Salary: " + salary);
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
   public void pay() {
        System.out.println("Full Time Employee: " + name);
        System.out.println("Monthly Salary: " + salary);
    }
}
//how to symentially understand the code in era of AI
class FreelanceConsultant implements  Payable{
    private String contract;
    @Override
    public void pay() {
        System.out.println("payment of Freelance Consultant");
    }
}

class PaymentProcesser{
   static void processPayment(Payable e) {
        e.pay();
        //database update to save payment details
        System.out.println("Payment processed for ");
    }
}
public class F_EmployeeMgt {
    public static void main(String[] args) {
        Employee e1 = new PartTimeEmployee(101, "Rahul", 15000);
        Employee e2 = new FullTimeEmployee(102, "Amit", 50000);
        PaymentProcesser.processPayment(e1);
        PaymentProcesser.processPayment(e2);
    }
}
