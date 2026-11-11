package com.empapp.basics;

import com.util.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class B_GetAllEmployee {
    public static void main(String[] args) {

        //1. get the session factory
        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();
        //2. get the session from the session factory
        Session session=sessionFactory.openSession();
        //orm it automatically featch all tuples and convert them to object
        //hiberante SQLX            HQL (hibernate Query language): database portablity mysql vs oracle
        //What is HQL aka oo wrapper on top of SQL
//        List<Object[]> employees=session.createQuery("select e.name, e.salary from Employee e").list();
//        for (Object []arr: employees){
//            System.out.println(arr[0]+": "+ arr[1]);
//        }

        List<EmployeeSelectedDataDto> employeesSelectedField=session
                .createQuery("select new com.empapp.basics.EmployeeSelectedDataDto(e.name, e.salary) from Employee e").list();

        employeesSelectedField.forEach(System.out::println);



        //hey hib i want all the records : orm, HQL OO way of writing sql vs SQL
//        List<Employee> employees=session.createQuery("select e from Employee e", Employee.class).getResultList();
//        employees.forEach(e-> System.out.println(e));
        //Sec ex
//        List<String> employees=session.createQuery("select e.name from Employee e", String.class).getResultList();
//        employees.forEach(e-> System.out.println(e));

//        List<String> employees=session.createQuery("select e.name from Employee e", String.class).getResultList();
//        employees.forEach(e-> System.out.println(e));

//        List<EmployeeSelectedDataDto> employees=session
//                .createQuery("select new com.empapp.basics.EmployeeSelectedDataDto(e.name,e.salary) from Employee e", EmployeeSelectedDataDto.class).getResultList();
//
//        employees.forEach(e-> System.out.println(e));

        //REST vs
//        List<Object[]> employees=session
//                .createQuery("select e.name,e.salary from Employee e", Object[].class).getResultList();

       //one in one ?

//        session.close();
//        sessionFactory.close();


        //close the session
        //close the session factory


    }
}
