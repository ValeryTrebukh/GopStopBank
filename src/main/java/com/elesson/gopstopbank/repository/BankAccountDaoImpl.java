package com.elesson.gopstopbank.repository;

import com.elesson.gopstopbank.model.Bank;
import com.elesson.gopstopbank.model.BankAccount;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {

    private final Dao bankDao;
    private final Dao clientDao;

    public BankAccountDaoImpl(@Qualifier("bank") Dao bankDao, @Qualifier("client") Dao clientDao) {
        this.bankDao = bankDao;
        this.clientDao = clientDao;
    }

    @Override
    public BankAccount save(Integer bankId, BankAccount account) {
        Bank bank = (Bank)bankDao.get(bankId);
        if(bank != null && clientDao.get(account.getOwnerId()) != null) {
            account.assignId(bank);
            return bank.getBankAccountsMap().put(account.getId(), account);
        }
        return null;
    }

    @Override
    public BankAccount update(Integer bankId, BankAccount account) {
        Bank bank = (Bank)bankDao.get(bankId);
        if (bank != null && bank.getBankAccountsMap().containsKey(account.getId()) && clientDao.get(account.getOwnerId()) != null) {
            return bank.getBankAccountsMap().put(account.getId(), account);
        }
        return null;
    }

    @Override
    public BankAccount get(Integer bankId, Integer accountId) {
        Bank bank = (Bank)bankDao.get(bankId);
        if(bank != null) {
            return bank.getBankAccountsMap().get(accountId);
        }
        return null;
    }

    @Override
    public List<BankAccount> getAll(Integer bankId) {
        Bank bank = (Bank)bankDao.get(bankId);
        if(bank != null) {
            return bank.getBankAccounts();
        }
        return null;
    }

    @Override
    public boolean delete(Integer bankId, Integer accountId) {
        Bank bank = (Bank)bankDao.get(bankId);
        if(bank != null) {
            bank.getBankAccountsMap().remove(accountId);
            return true;
        }
        return false;
    }
}
