package com.elesson.gopstopbank.controller;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Bank;
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

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(BANK_URL + "/{id}")
                .buildAndExpand(bank.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(bank);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBank(@PathVariable("id") Integer id) {
        bankDao.delete(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBank(@RequestBody Bank bank, @PathVariable("id") Integer id) {
        bank.setId(id);
        bankDao.save(bank);
    }

}
