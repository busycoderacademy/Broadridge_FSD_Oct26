package com.bankapp.repo;

import com.bankapp.dto.Account;
import com.bankapp.factory.EmFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class AccountRepoJpaImpl implements  AccountRepo{
    private EntityManagerFactory emf;

    public  AccountRepoJpaImpl(){
        emf= EmFactory.getEntityManagerFactory();
    }
    @Override
    public List<Account> getAccounts() {
        EntityManager entityManager =  emf.createEntityManager();
        List<Account> accounts = entityManager.createQuery("select Account", Account.class).getResultList();
        entityManager.close();
        return accounts;
    }

    @Override
    public Account getAccountById(int id) {
        EntityManager entityManager =  emf.createEntityManager();
        Account account = entityManager.find(Account.class, id);
        entityManager.close();
        return account;
    }

    @Override
    public void update(Account account) {
        EntityManager entityManager =  emf.createEntityManager();
        Account accountToUpdate = entityManager.find(Account.class, account.getId());
        if(accountToUpdate!=null){
            EntityTransaction tx=entityManager.getTransaction();
            try{
                tx.begin();
                accountToUpdate.setBalance(account.getBalance());
                entityManager.merge(accountToUpdate);
                tx.commit();
            }catch (Exception e){
                tx.rollback();
            }
        }
        entityManager.close();
    }

    @Override
    public void save(Account account) {
        EntityManager entityManager =  emf.createEntityManager();
        EntityTransaction tx=entityManager.getTransaction();
        try{
                tx.begin();
                entityManager.persist(account);
                tx.commit();
            }catch (Exception e){
                tx.rollback();
            }

        entityManager.close();
    }
}
