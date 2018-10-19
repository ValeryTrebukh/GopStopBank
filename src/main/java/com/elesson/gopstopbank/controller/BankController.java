package com.elesson.gopstopbank.controller;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {

    private final Dao bankDao;

    @Autowired
    public BankController(@Qualifier("bank") Dao bankDao) {
        this.bankDao = bankDao;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AbstractEntity> getAll() {
        return bankDao.getAll();
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AbstractEntity get(@PathVariable("id") int id) {
        return bankDao.get(id);
    }

}
