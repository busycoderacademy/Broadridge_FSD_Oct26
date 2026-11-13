package com.demo.inh.table_per_con_class;

import com.demo.factory.EmFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DemoTester {

	public static void main(String[] args) {

		EntityManagerFactory emf  = EmFactory.getEMFactory();
		EntityManager em = emf.createEntityManager();// getCurrentSession (web application spring)

		em.getTransaction().begin();
		
		Account account1=new SavingAccount("ravi", 5600, .4);
		Account account2=new SavingAccount("seema", 5690, .4);

		Account account3=new CurrentAccount("umesh", 5600, 400);
		Account account4=new CurrentAccount("foo", 5600, 400);
		Account account5=new CurrentAccount("bar", 5600, 400);
//
		em.persist(account1);
		em.persist(account2);
		em.persist(account3);
		em.persist(account4);
		em.persist(account5);
		em.persist(account2);

//
		//it support poly quaries
		
//		List<Account> accounts=session.createQuery("select a from Account a").getResultList();
//		accounts.forEach(System.out::println);
////
//		List<SavingAccount> accounts=em.createQuery("select a from SavingAccount a").getResultList();
//		accounts.forEach(System.out::println);
//

		em.getTransaction().commit();


		em.close();

		emf.close();


	}

}
