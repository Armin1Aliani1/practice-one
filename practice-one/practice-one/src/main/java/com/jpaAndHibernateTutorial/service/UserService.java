package com.jpaAndHibernateTutorial.service;

import com.jpaAndHibernateTutorial.base.service.BaseService;
import com.jpaAndHibernateTutorial.domain.User;

public interface UserService extends BaseService<User, Long> {
    User findByUsername(String username);
}
