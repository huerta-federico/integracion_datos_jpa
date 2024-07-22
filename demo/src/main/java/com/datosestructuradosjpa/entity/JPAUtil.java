package com.datosestructuradosjpa.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Clase de utilidad para separar la creación de la conexión a la base de datos.
public class JpaUtil {
    public static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("PI_LABORATORY_PU");

    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }
}