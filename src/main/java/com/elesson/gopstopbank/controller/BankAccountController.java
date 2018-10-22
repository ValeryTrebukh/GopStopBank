package com.elesson.gopstopbank.controller;

import com.elesson.gopstopbank.model.BankAccount;
import com.elesson.gopstopbank.repository.BankAccountDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(BankController.BANK_URL)
public class BankAccountController {

    private final BankAccountDao bankAccountDao;


    public BankAccountController(BankAccountDao bankAccountDao) {
        this.bankAccountDao = bankAccountDao;
    }

    @GetMapping(value = "/{bankId}/accounts/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BankAccount getBankById(@PathVariable("bankId") Integer bankId, @PathVariable("accountId") Integer accountId) {
        return bankAccountDao.get(bankId, accountId);
    }

    @GetMapping(value = "/{bankId}/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccount> getAccountsBankById(@PathVariable("bankId") Integer bankId) {
        return bankAccountDao.getAll(bankId);
    }

    @PostMapping(value = "/{bankId}/accounts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount account, @PathVariable("bankId") Integer bankId) {
        bankAccountDao.save(bankId, account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{bankId}/accounts/{id}")
    public ResponseEntity<BankAccount> deleteAccount(@PathVariable("bankId") Integer bankId, @PathVariable("id") Integer id) {
        bankAccountDao.delete(bankId, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{bankId}/accounts/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankAccount> updateAccount(@RequestBody BankAccount account,
                              @PathVariable("bankId") Integer bankId, @PathVariable("id") Integer id) {
        account.setId(id);
        bankAccountDao.update(bankId, account);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
