package com.elesson.gopstopbank.repository;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Bank;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("bank")
public class BankDaoImpl implements Dao {

    private static Map<Integer, Bank> banks = new HashMap<>();

    @Override
    public AbstractEntity save(AbstractEntity entity) {
        return banks.put(entity.getId(), (Bank)entity);
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
