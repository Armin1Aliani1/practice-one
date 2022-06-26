package com.jpaAndHibernateTutorial;

import com.jpaAndHibernateTutorial.domain.User;
import com.jpaAndHibernateTutorial.domain.Wallet;
import com.jpaAndHibernateTutorial.util.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaApplication {
    public static void main(String[] args) {

        System.out.println(ApplicationContext.getUserRepository().findAll());
        insertUserWithWallet();
        System.out.println(ApplicationContext.getUserRepository().findAll());

//        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();

        // Build and get entityManager with entityManagerFactory
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Build and get entityManager with entityManagerFactory

//        doFirstExample(entityManager);

    }

    private static void insertUserWithWallet() {
        //        User user = ApplicationContext.getUserRepository().findById(2L);
        Wallet wallet = new Wallet();
        wallet = ApplicationContext.getWalletRepository().save(wallet);
        Wallet newW = new Wallet();
        newW.setId(wallet.getId());
        User user = new User();
        user.setFirstName("Reza");
        user.setActive(true);
        user.setWallet(newW);
        ApplicationContext.getUserRepository().save(user);
    }

    private static void doFirstExample(EntityManager entityManager) {
        // This command is used to create a query
        TypedQuery<User> query = entityManager.createQuery("SELECT u from User u", User.class);
        // This command is used to create a query

        // Show user
        // Results a list of data
        List<User> userList = query.getResultList();
        // Results a list of data
        if (userList == null || userList.isEmpty()) {
            System.out.println("Empty users");
        } else {
            // Do print for each user
            userList.forEach(user -> System.out.println(user));
            // Do print for each user
        }
        // Show user

        EntityTransaction transaction = entityManager.getTransaction();
        // transaction start
        transaction.begin();
        // transaction start

        User user = new User("Armin", "Aliani", "ArminA", "123456789", true);
        // Is persist for save user
        entityManager.persist(user);
        // Is persist for save user
        System.out.println(user);

        // Record
        transaction.commit();
        // Record

        userList = query.getResultList();
        System.out.println(userList);
    }
}
