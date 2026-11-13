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
        Employee e1 = session.get(Employee.class,1);//get vs load, here hib hit the db, joins
        System.out.println("-----------------");
        System.out.println(e1);
        System.out.println("*******************");
//        session.evict(e1);// batch processing
        session.clear();
        Employee e2 = session.get(Employee.class,1);
        System.out.println(e2);
        session.close();//detached
        sessionFactory.close();




    }
}
