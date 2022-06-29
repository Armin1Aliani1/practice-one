package com.jpaAndHibernateTutorial.repository.impl;

import com.jpaAndHibernateTutorial.base.repository.impl.BaseRepositoryImpl;
import com.jpaAndHibernateTutorial.domain.User;
import com.jpaAndHibernateTutorial.repository.UserRepository;
import com.jpaAndHibernateTutorial.service.dto.UserBriefProjection;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public User save(User user) {
        throw new RuntimeException();
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("select u from User u where u.username=:username", User.class).setParameter("username", username).getSingleResult();
    }

    @Override
    public List<UserBriefProjection> getUserBriefProjection() {

        return entityManager.createQuery(
                "select new com.jpaAndHibernateTutorial.service.dto." +
                        "UserBriefProjection(u.id, u.firstName, u.lastName) from User u",
                UserBriefProjection.class
        ).getResultList();

    }

}
