package com.elesson.gopstopbank.controller;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Bank;
import com.elesson.gopstopbank.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(BankController.BANK_URL)
public class BankController {

    private final Dao bankDao;
    static final String BANK_URL = "/banks";

    @Autowired
    public BankController(@Qualifier("bank") Dao bankDao) {
        this.bankDao = bankDao;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AbstractEntity> getAllBanks() {
        return bankDao.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AbstractEntity getBankById(@PathVariable("id") Integer id) {
        return bankDao.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbstractEntity> createBank(@RequestBody Bank bank) {
        bankDao.save(bank);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AbstractEntity> deleteBank(@PathVariable("id") Integer id) {
        bankDao.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbstractEntity> updateBank(@RequestBody Bank bank, @PathVariable("id") Integer id) {
        bank.setId(id);
        bankDao.update(bank);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
