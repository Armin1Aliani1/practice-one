package com.jpaAndHibernateTutorial;

import com.jpaAndHibernateTutorial.domain.*;
import com.jpaAndHibernateTutorial.util.ApplicationContext;
import com.jpaAndHibernateTutorial.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaApplication {
    public static void main(String[] args) {

        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        Radio radio = new Radio();
        radio.setFrequency(10);
        radio.setPower(110L);
        radio.setPrice(11000L);
        entityManager.persist(radio);

        Tv tv = new Tv();
        tv.setInch(100);
        tv.setPower(11000L);
        tv.setPrice(11000000L);
        entityManager.persist(tv);

        Cart cart = new Cart();
        cart.getProductList().add(radio);
        cart.getProductList().add(tv);
        entityManager.persist(cart);

        entityManager.getTransaction().commit();

        System.out.println(entityManager.createQuery("select c from Cart c", Cart.class).getResultList());

//        System.out.println(entityManager.createQuery("select t from Tv t", Tv.class).getResultList());

//        System.out.println(entityManager.createQuery("select r from Radio r", Radio.class).getResultList());

//        System.out.println(ApplicationContext.getUserRepository().findAll());
//        insertUserWithUserService();
//        insertUserWithWallet();
//        System.out.println(ApplicationContext.getUserRepository().findAll());

//        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();

        // Build and get entityManager with entityManagerFactory
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Build and get entityManager with entityManagerFactory

//        doFirstExample(entityManager);

    }

    private static void insertUserWithUserService() {
        ApplicationContext.getUserService().save(new User("Sadegh", "Abdi", null, "123456", true));
    }

    private static void insertUserWithWallet() {
        //        User user = ApplicationContext.getUserRepository().findById(2L);
        Wallet wallet = new Wallet();
        wallet = ApplicationContext.getWalletRepository().save(wallet);
        /*Wallet newW = new Wallet();
        newW.setId(wallet.getId());*/
        User user = new User();
        user.setFirstName("Alireza");
        user.setActive(true);
//        user.setWallet(wallet);
        throw new RuntimeException();
//        ApplicationContext.getUserRepository().save(user);
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
