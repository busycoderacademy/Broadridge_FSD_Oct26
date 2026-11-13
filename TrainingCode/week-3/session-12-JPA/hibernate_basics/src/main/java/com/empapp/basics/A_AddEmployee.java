package com.empapp.basics;

import com.util.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class A_AddEmployee {
    public static void main(String[] args) {
     //1 u need to create sessionfactory
        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();
        //2. create session
        Session session=sessionFactory.openSession();
        //3. start the transaction
        Transaction tx=session.getTransaction();

        //4. save the emp: u write oo code
        try{
            tx.begin();
            Employee employee1=new Employee("sumit",6700,"IT");
            Employee employee2=new Employee("kapil",9700,"Training");
            Employee employee3=new Employee("Seema",9710,"Fin");
            //orm
            session.save(employee1); // session.persist(employee1);
            session.save(employee2);
            session.save(employee3);
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
        }
    }
}
