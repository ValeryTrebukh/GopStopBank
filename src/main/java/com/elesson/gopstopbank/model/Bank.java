package com.elesson.gopstopbank.model;


import com.elesson.gopstopbank.DataBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank extends AbstractEntity {

    private static Integer bankIdCounter = 100;
    private Integer accountIdCounter = 100_000;

    private String name;

    @JsonIgnore
    private Map<Integer, BankAccount> bankAccountsMap;

    public Bank(@JsonProperty("name") String name) {
        this.name = name;
        bankAccountsMap = DataBase.getBankAccounts().values().stream()
                .filter(b -> b.getBankId().equals(this.id))
                .collect(Collectors.toMap(AbstractEntity::getId, b -> b));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void assignId() {
        this.setId(++bankIdCounter);
    }

    @JsonIgnore
    public Integer getNextAccountId() {
        return ++accountIdCounter;
    }

    @JsonIgnore
    public List<BankAccount> getBankAccounts() {
        return new ArrayList<>(bankAccountsMap.values());
    }

    public Map<Integer, BankAccount> getBankAccountsMap() {
        return bankAccountsMap;
    }
}
