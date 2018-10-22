package com.elesson.gopstopbank.repository;

import com.elesson.gopstopbank.model.BankAccount;

import java.util.List;

public interface BankAccountDao {

    BankAccount save(Integer bankId, BankAccount entity);

    BankAccount update(Integer bankId, BankAccount entity);

    BankAccount get(Integer bankId, Integer accountId);

    List<BankAccount> getAll(Integer bankId);

    boolean delete(Integer bankId, Integer id);
}
