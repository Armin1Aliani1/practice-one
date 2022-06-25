package com.jpaAndHibernateTutorial.repository;

import com.jpaAndHibernateTutorial.base.repository.BaseRepository;
import com.jpaAndHibernateTutorial.domain.User;

public interface UserRepository extends BaseRepository<User, Long> {
    User findByUsername(String username);
}
