package com.bankapp.factory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmFactory {
    private static EntityManagerFactory emf =  null;

    public static EntityManagerFactory getEntityManagerFactory(){
        emf= Persistence.createEntityManagerFactory("bankapp");
        return emf;
    }
}
