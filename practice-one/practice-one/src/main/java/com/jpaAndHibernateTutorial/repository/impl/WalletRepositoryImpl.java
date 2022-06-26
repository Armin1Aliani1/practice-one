package com.jpaAndHibernateTutorial.repository.impl;

import com.jpaAndHibernateTutorial.base.repository.impl.BaseRepositoryImpl;
import com.jpaAndHibernateTutorial.domain.Wallet;
import com.jpaAndHibernateTutorial.repository.WalletRepository;

import javax.persistence.EntityManager;

public class WalletRepositoryImpl extends BaseRepositoryImpl<Wallet, Long> implements WalletRepository {

    public WalletRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Wallet> getEntityClass() {
        return Wallet.class;
    }

}
