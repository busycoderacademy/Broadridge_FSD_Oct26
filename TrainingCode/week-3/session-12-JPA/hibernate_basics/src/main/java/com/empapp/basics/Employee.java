package com.empapp.basics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//how hib come to know about this class
//actually hibernate manage the life cycle of object
//entity -> pojo with @Enitity @Id
@Entity
@Table(name = "emp_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;

    @Column(name = "emp_name", nullable = false, length = 50)
    private String name;
    @Column(name = "emp_salary" , nullable = false)
    private double salary;

    @Column(name = "emp_dept", nullable = false, length = 50)
    private String dept;


    public Employee(String name, double salary, String dept) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}
