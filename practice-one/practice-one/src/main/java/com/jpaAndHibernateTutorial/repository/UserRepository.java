package com.jpaAndHibernateTutorial.repository;

import com.jpaAndHibernateTutorial.base.repository.BaseRepository;
import com.jpaAndHibernateTutorial.domain.User;
import com.jpaAndHibernateTutorial.service.dto.UserBriefProjection;

import java.util.List;

public interface UserRepository extends BaseRepository<User, Long> {
    User findByUsername(String username);

    List<UserBriefProjection> getUserBriefProjection();
}
