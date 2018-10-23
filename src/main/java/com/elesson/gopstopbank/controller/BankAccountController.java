package com.elesson.gopstopbank.controller;

import com.elesson.gopstopbank.model.BankAccount;
import com.elesson.gopstopbank.repository.BankAccountDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(BankAccountController.BANK_ACCOUNT_URL)
public class BankAccountController {

    private final BankAccountDao bankAccountDao;
    static final String BANK_ACCOUNT_URL = "/banks/{bankId}/accounts";

    public BankAccountController(BankAccountDao bankAccountDao) {
        this.bankAccountDao = bankAccountDao;
    }

    @GetMapping(value = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankAccount> getBankById(@PathVariable("bankId") Integer bankId,
                                                   @PathVariable("accountId") Integer accountId) {
        BankAccount result = bankAccountDao.get(bankId, accountId);
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BankAccount>> getAccountsBankById(@PathVariable("bankId") Integer bankId) {
        List<BankAccount> result = bankAccountDao.getAll(bankId);
        return result == null || result.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount account,
                                                     @PathVariable("bankId") Integer bankId) {
        BankAccount created = bankAccountDao.save(bankId, account);
        return created == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BankAccount> deleteAccount(@PathVariable("bankId") Integer bankId,
                                                     @PathVariable("id") Integer id) {
        BankAccount deleted = bankAccountDao.delete(bankId, id);
        return deleted == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankAccount> updateAccount(@RequestBody BankAccount account,
                              @PathVariable("bankId") Integer bankId, @PathVariable("id") Integer id) {
        account.setId(id);
        BankAccount updated = bankAccountDao.update(bankId, account);
        return updated == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(HttpStatus.OK);
    }
}
