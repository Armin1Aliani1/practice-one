package com.jpaAndHibernateTutorial.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    // We use (final) when we want to set a constant value only once
    // We use (static) when we do not want to create an object of our class
    private static final EntityManagerFactory emf;

    //    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    static {
        emf = Persistence.createEntityManagerFactory("default");
//        emf = Persistence.createEntityManagerFactory("name file persistence in tag <persistence-unit name="default">");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
