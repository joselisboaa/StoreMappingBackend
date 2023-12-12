package com.map.store.api.controller;

import com.map.store.domain.model.Account;
import com.map.store.domain.service.IAccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts/")
@Resource
@CrossOrigin(origins = "*")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        List<Account> clients =  accountService.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> getById(@PathVariable Long id) {
        Account client = accountService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account client) {
        Account newAccount = accountService.create(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    @PutMapping("{id}")
    public ResponseEntity<Account> update(@RequestBody Account client, @PathVariable Long id) {
        Account updatedAccount = accountService.update(client, id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedAccount);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        accountService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
