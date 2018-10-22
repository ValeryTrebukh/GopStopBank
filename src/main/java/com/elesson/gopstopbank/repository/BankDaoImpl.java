package com.elesson.gopstopbank.repository;

import com.elesson.gopstopbank.DataBase;
import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Bank;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("bank")
public class BankDaoImpl implements Dao {

    private static Map<Integer, Bank> banks = DataBase.getBanks();

    @Override
    public AbstractEntity save(AbstractEntity entity) {
        Bank created = (Bank) entity;
        created.assignId();
        return banks.put(created.getId(), created);
    }

    @Override
    public AbstractEntity update(AbstractEntity entity) {
        if (banks.containsKey(entity.getId())) {
            Bank bank = banks.get(entity.getId());
            bank.setName(((Bank)entity).getName());
            return bank;
        }
        return null;
    }

    @Override
    public AbstractEntity get(Integer id) {
        return banks.get(id);
    }

    @Override
    public List<AbstractEntity> getAll() {
        return new ArrayList<>(banks.values());
    }

    @Override
    public boolean delete(Integer id) {
        return banks.remove(id) != null;
    }
}
