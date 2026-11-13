package com.demo.inh.singletable;

import com.demo.factory.EmFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class DemoTester {

	public static void main(String[] args) {

		EntityManagerFactory emf  = EmFactory.getEMFactory();
		EntityManager em = emf.createEntityManager();// getCurrentSession (web application spring)

		em.getTransaction().begin();
//
		Account account1=new SavingAccount("ravi", 5600, .4);
		Account account2=new SavingAccount("seema", 5690, .4);

		Account account3=new CurrentAccount("umesh", 5600, 400);
		Account account4=new CurrentAccount("foo", 5600, 400);
		Account account5=new CurrentAccount("bar", 5600, 400);
//
////
//		em.persist(account1);
//		em.persist(account2);
//		em.persist(account3);
//		em.persist(account4);
//		em.persist(account5);

//
		//it support poly quaries
		List<Account> accounts=em
				.createQuery("select a from Account a",Account.class).getResultList();
		accounts.forEach(System.out::println);
////
//		List<SavingAccount> accounts=em.createQuery("select a from SavingAccount a").getResultList();
//		accounts.forEach(System.out::println);
//
		
		em.getTransaction().commit();
		

		em.close();

		emf.close();


	}

}
