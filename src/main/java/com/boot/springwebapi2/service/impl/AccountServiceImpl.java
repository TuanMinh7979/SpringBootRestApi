package com.boot.springwebapi2.service.impl;

import com.boot.springwebapi2.model.Account;
import com.boot.springwebapi2.repo.AccountRepo;
import com.boot.springwebapi2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class AccountServiceImpl implements AccountService {
    private List<Account> accounts;

    public AccountServiceImpl() {
        this.accounts= new ArrayList<>();
        this.accounts.add(new Account("nva", "123"));
        this.accounts.add(new Account("nvb", "125"));

    }

    @Override
    public boolean check(String username, String password) {
        for (Account acc : accounts) {
            if (acc.getUserName().equalsIgnoreCase(username) && acc.getPassword().equalsIgnoreCase(password))
                return true;
        }
        return false;
    }
}
