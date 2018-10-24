package com.elesson.gopstopbank.controller;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Bank;
import com.elesson.gopstopbank.repository.GopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(BankController.BANK_URL)
public class BankController {

    private final GopDao bankGopDao;
    static final String BANK_URL = "/banks";

    @Autowired
    public BankController(@Qualifier("bankRepository") GopDao bankGopDao) {
        this.bankGopDao = bankGopDao;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AbstractEntity>> getAllBanks() {
        List<AbstractEntity> result = bankGopDao.getAll();
        if (result == null || result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbstractEntity> getBankById(@PathVariable("id") Integer id) {
        Bank result = (Bank) bankGopDao.get(id);
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbstractEntity> createBank(@RequestBody Bank bank) {
        Bank created = (Bank) bankGopDao.save(bank);
        return created == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AbstractEntity> deleteBank(@PathVariable("id") Integer id) {
        Bank deleted = (Bank) bankGopDao.delete(id);
        return deleted == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbstractEntity> updateBank(@RequestBody Bank bank, @PathVariable("id") Integer id) {
        bank.setId(id);
        Bank updated = (Bank) bankGopDao.update(bank);
        return updated == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(HttpStatus.OK);
    }
}
