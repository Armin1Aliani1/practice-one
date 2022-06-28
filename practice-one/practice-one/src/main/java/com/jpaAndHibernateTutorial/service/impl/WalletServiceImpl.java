package com.jpaAndHibernateTutorial.service.impl;

import com.jpaAndHibernateTutorial.base.service.impl.BaseServiceImpl;
import com.jpaAndHibernateTutorial.domain.Wallet;
import com.jpaAndHibernateTutorial.repository.WalletRepository;
import com.jpaAndHibernateTutorial.service.WalletService;

public class WalletServiceImpl extends BaseServiceImpl<Wallet, Long, WalletRepository> implements WalletService {

    public WalletServiceImpl(WalletRepository repository) {
        super(repository);
    }

    @Override
    public Wallet save(Wallet wallet) {
        if (wallet.getId() == null) {
            return repository.save(wallet);
        } else {
            return super.save(wallet);
        }
    }
}
