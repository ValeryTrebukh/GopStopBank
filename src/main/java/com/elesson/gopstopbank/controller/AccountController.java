package com.elesson.gopstopbank.controller;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Account;
import com.elesson.gopstopbank.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(AccountController.ACCOUNT_URL)
public class AccountController {

    private final Dao accountDao;
    static final String ACCOUNT_URL = "/accounts";

    @Autowired
    public AccountController(@Qualifier("account") Dao accountDao) {
        this.accountDao = accountDao;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AbstractEntity> getAllAccounts() {
        return accountDao.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AbstractEntity getAccountById(@PathVariable("id") Integer id) {
        return accountDao.get(id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbstractEntity> createAccount(@RequestBody Account account) {
        Account saved = (Account) accountDao.save(account);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(ACCOUNT_URL + "/{id}")
                .buildAndExpand(saved.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(saved);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAccount(@PathVariable("id") Integer id) {
        accountDao.delete(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAccount(@RequestBody Account account, @PathVariable("id") Integer id) {
        account.setId(id);
        accountDao.update(account);
    }
}
