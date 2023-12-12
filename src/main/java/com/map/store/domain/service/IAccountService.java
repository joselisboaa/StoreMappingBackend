package com.map.store.domain.service;

import com.map.store.domain.model.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAll();
    Account getById(Long id);
    Account create(Account account);
    Account update(Account account, Long id);
    void deleteById(Long id);
}
