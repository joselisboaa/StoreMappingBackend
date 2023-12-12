package com.map.store.domain.service;

import com.map.store.domain.model.Account;
import com.map.store.domain.repository.IAccountRepository;
import com.map.store.domain.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    private final String ACCOUNT_NOT_EXIST = "Essa conta não existe ou não foi encontrada.";

     public List<Account> getAll() {
         return accountRepository.findAll();
     }

     public Account getById(Long id) {
         Optional<Account> client = accountRepository.findById(id);

        return client.orElseThrow(() -> {
            throw new ResourceNotFoundException(ACCOUNT_NOT_EXIST);
        });
     }

     public Account create(Account client) {
         Account newAccount = accountRepository.save(client);

         return newAccount;
     }

     public Account update(Account newAccountData, Long id) {
         try {
             Account accountData = accountRepository.findById(id).get();
             updateAccountData(accountData, newAccountData);
             
             accountRepository.save(accountData);

             return accountData;
         } catch (EntityNotFoundException error) {
             throw new ResourceNotFoundException(ACCOUNT_NOT_EXIST);
         }
     }

     public void deleteById(Long id) {
         try {
             if (accountRepository.existsById(id)) {
                 accountRepository.deleteById(id);
             }
             throw new EntityNotFoundException();
         } catch (EntityNotFoundException error) {
             throw new ResourceNotFoundException(ACCOUNT_NOT_EXIST);
         }
     }

     private void updateAccountData(Account oldAccountData, Account newAccountData) {
         oldAccountData.setLogin(newAccountData.getLogin());
     }
}
