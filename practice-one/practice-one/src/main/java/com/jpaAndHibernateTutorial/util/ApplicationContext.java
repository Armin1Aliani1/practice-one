package com.jpaAndHibernateTutorial.util;

import com.jpaAndHibernateTutorial.repository.UserRepository;
import com.jpaAndHibernateTutorial.repository.impl.UserRepositoryImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

    private static UserRepository userRepository;

    private ApplicationContext() {
    }

    public static UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(em);
        }
        return userRepository;
    }
}
