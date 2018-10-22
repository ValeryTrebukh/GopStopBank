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
        if(entity.getId() == null) {
            Account account = (Account)entity;
            Account created = new Account(account.getOwnerId(), account.getBankId());
            return accounts.put(created.getId(), created);
        }
        return accounts.put(entity.getId(), (Account) entity);
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
