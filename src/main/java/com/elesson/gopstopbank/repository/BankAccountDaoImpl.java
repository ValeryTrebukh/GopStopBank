package com.elesson.gopstopbank.repository;

import com.elesson.gopstopbank.model.Bank;
import com.elesson.gopstopbank.model.BankAccount;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {

    private final GopDao bankGopDao;
    private final GopDao clientGopDao;

    public BankAccountDaoImpl(@Qualifier("bankRepository") GopDao bankGopDao,
                              @Qualifier("clientRepository") GopDao clientGopDao) {
        this.bankGopDao = bankGopDao;
        this.clientGopDao = clientGopDao;
    }

    @Override
    public BankAccount save(Integer bankId, BankAccount account) {
        Bank bank = (Bank) bankGopDao.get(bankId);
        if(bank != null && clientGopDao.get(account.getOwnerId()) != null) {
            account.assignId(bank);
            return bank.getBankAccountsMap().putIfAbsent(account.getId(), account);
        }
        return null;
    }

    @Override
    public BankAccount update(Integer bankId, BankAccount account) {
        Bank bank = (Bank) bankGopDao.get(bankId);
        if (bank != null && bank.getBankAccountsMap().containsKey(account.getId()) && clientGopDao.get(account.getOwnerId()) != null) {
            return bank.getBankAccountsMap().put(account.getId(), account);
        }
        return null;
    }

    @Override
    public BankAccount get(Integer bankId, Integer accountId) {
        Bank bank = (Bank) bankGopDao.get(bankId);
        if(bank != null) {
            return bank.getBankAccountsMap().get(accountId);
        }
        return null;
    }

    @Override
    public List<BankAccount> getAll(Integer bankId) {
        Bank bank = (Bank) bankGopDao.get(bankId);
        if(bank != null) {
            return bank.getBankAccounts();
        }
        return null;
    }

    @Override
    public BankAccount delete(Integer bankId, Integer accountId) {
        Bank bank = (Bank) bankGopDao.get(bankId);
        if(bank != null) {
            return bank.getBankAccountsMap().remove(accountId);
        }
        return null;
    }
}
