package com.empapp.basics;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class B_GetAll {
    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpasession");
        EntityManager em=emf.createEntityManager();
        Employee employee = em.getReference(Employee.class,1);//Proxy design pattern

        //JPQL
//        List<Employee> employees=em.createQuery("select e from Employee e", Employee.class).getResultList();
//        employees.forEach(System.out::println);

        System.out.println(employee.getName());
        em.close();
        emf.close();




        //close the session
        //close the session factory


    }
}
