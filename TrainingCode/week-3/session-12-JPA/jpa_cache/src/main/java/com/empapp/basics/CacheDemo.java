
package com.empapp.basics;

import jakarta.persistence.*;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import java.util.List;

public class CacheDemo {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpasession");

        // FIRST EntityManager
        System.out.println("----- FIRST ENTITY MANAGER -----");

//        List<Employee> employees1 = em1.createQuery(
//                        "SELECT e FROM Employee e WHERE e.dept = :dept",
//                        Employee.class)
//                .setParameter("dept", "IT")
//                .setHint("org.hibernate.cacheable", true)
//                .getResultList();

        EntityManager em1 = emf.createEntityManager();
        Employee emp1 = em1.find(Employee.class, 1);
        System.out.println(emp1);
        em1.close();

        // SECOND EntityManager
        System.out.println("----- SECOND ENTITY MANAGER -----");
        EntityManager em2 = emf.createEntityManager();
        Employee emp2 = em2.find(Employee.class, 1);
        System.out.println(emp2);
        em2.close();



        emf.close();
    }
}
