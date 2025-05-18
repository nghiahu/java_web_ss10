package com.example.session10.service.account;

import com.example.session10.model.Account;
import com.example.session10.repository.account.AccountRepository;
import com.example.session10.repository.account.AccountRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountSeviceImp implements AccountRepository {

    @Autowired
    private AccountRepositoryImp accountRepositoryImp;
    @Override
    public boolean addProduct(Account account) {
        return accountRepositoryImp.addProduct(account);
    }
}
