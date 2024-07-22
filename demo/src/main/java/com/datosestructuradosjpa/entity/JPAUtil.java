package com.datosestructuradosjpa.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    public static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("PI_LABORATORY_PU");

    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }
}