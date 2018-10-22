package com.elesson.gopstopbank.repository;

import com.elesson.gopstopbank.DataBase;
import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository("account")
public class AccountDaoImpl implements Dao {

    private static Map<Integer, Account> accounts = DataBase.getAccounts();


    @Override
    public AbstractEntity save(AbstractEntity entity) {
        Account created = (Account)entity;
        if(isValidBankAndOwner(created)) {
            created.assignId();
            return accounts.put(created.getId(), created);
        }
        return null;
    }

    @Override
    public AbstractEntity update(AbstractEntity entity) {
        Account account = (Account)entity;
        if (accounts.containsKey(account.getId()) && isValidBankAndOwner(account)) {
            return accounts.put(account.getId(), account);
        }
        return null;
    }

    private boolean isValidBankAndOwner(Account account) {
        return DataBase.getClients().containsKey(account.getOwnerId()) &&
               DataBase.getBanks().containsKey(account.getBankId());
    }

    @Override
    public AbstractEntity get(Integer id) {
        return accounts.get(id);
    }

    @Override
    public List<AbstractEntity> getAll() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public boolean delete(Integer id) {
        return accounts.remove(id) != null;
    }
}
