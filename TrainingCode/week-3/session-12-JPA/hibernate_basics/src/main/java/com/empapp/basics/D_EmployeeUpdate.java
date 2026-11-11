package com.empapp.basics;

import com.util.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class D_EmployeeUpdate {
    public static void main(String[] args) {

        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        //featch the record no tx
        Transaction tx=session.getTransaction();
        try{
            tx.begin();
            Employee employee = session.get(Employee.class,2);//get vs load, here hib hit the db
            if(employee!=null){
                employee.setSalary(employee.getSalary()*2);
                employee.setSalary(employee.getSalary()*2);
            }
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
        }


        session.close();//detached

        sessionFactory.close();



    }
}
