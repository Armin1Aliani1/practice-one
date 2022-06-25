package com.jpaAndHibernateTutorial.repository.impl;

import com.jpaAndHibernateTutorial.base.repository.impl.BaseRepositoryImpl;
import com.jpaAndHibernateTutorial.domain.User;
import com.jpaAndHibernateTutorial.repository.UserRepository;

import javax.persistence.EntityManager;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {

    protected UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("select u from User u where u.username=:username", User.class).setParameter("username", username).getSingleResult();
    }

}
