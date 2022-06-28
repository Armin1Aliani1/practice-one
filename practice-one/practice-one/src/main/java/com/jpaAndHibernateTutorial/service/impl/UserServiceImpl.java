package com.jpaAndHibernateTutorial.service.impl;

import com.jpaAndHibernateTutorial.base.service.impl.BaseServiceImpl;
import com.jpaAndHibernateTutorial.domain.User;
import com.jpaAndHibernateTutorial.repository.UserRepository;
import com.jpaAndHibernateTutorial.service.UserService;
import com.jpaAndHibernateTutorial.service.WalletService;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {

    private final WalletService walletService;

    public UserServiceImpl(UserRepository repository, WalletService walletService) {
        super(repository);
        this.walletService = walletService;
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            try {
                repository.beginTransaction();
                /*Wallet wallet = walletService.save(new Wallet());
                user.setWallet(wallet);*/
                user = repository.save(user);
//                user = super.save(user);
                repository.commitTransaction();
                return user;
            } catch (Exception e) {
                e.printStackTrace();
                repository.rollbackTransaction();
                throw e;
            }
        } else {
            return super.save(user);
        }
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
