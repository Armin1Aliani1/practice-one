package com.jpaAndHibernateTutorial.service.impl;

import com.jpaAndHibernateTutorial.base.service.impl.BaseServiceImpl;
import com.jpaAndHibernateTutorial.domain.User;
import com.jpaAndHibernateTutorial.repository.UserRepository;
import com.jpaAndHibernateTutorial.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
