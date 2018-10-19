package com.elesson.gopstopbank.controller;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final Dao accountDao;

    @Autowired
    public AccountController(@Qualifier("account") Dao accountDao) {
        this.accountDao = accountDao;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AbstractEntity> getAll() {
        return accountDao.getAll();
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AbstractEntity get(@PathVariable("id") int id) {
        return accountDao.get(id);
    }
}
