package com.jpaAndHibernateTutorial.util;

import com.jpaAndHibernateTutorial.repository.UserRepository;
import com.jpaAndHibernateTutorial.repository.WalletRepository;
import com.jpaAndHibernateTutorial.repository.impl.UserRepositoryImpl;
import com.jpaAndHibernateTutorial.repository.impl.WalletRepositoryImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

    private static UserRepository userRepository;
    private static WalletRepository walletRepository;

    private ApplicationContext() {
    }

    public static UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(em);
        }
        return userRepository;
    }

    public static WalletRepository getWalletRepository() {
        if (walletRepository == null) {
            walletRepository = new WalletRepositoryImpl(em);
        }
        return walletRepository;
    }

}
