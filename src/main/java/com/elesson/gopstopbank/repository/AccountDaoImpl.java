package com.elesson.gopstopbank.repository;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoImpl implements Dao {

    private static Map<Integer, Account> accounts = new HashMap<>();

    @Override
    public AbstractEntity save(AbstractEntity entity) {
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
