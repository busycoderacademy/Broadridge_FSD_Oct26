package com.empapp.basics;

import com.util.factory.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class C_GetById {
    public static void main(String[] args) {

        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        //featch the record no tx
        Employee employee = session.get(Employee.class,1);//get vs load, here hib hit the db
        //load used under the hood when we learn about join of relationship *
        System.out.println("-----------------");
        System.out.println(employee);
        System.out.println("*******************");

        session.close();//detached

        sessionFactory.close();




    }
}
