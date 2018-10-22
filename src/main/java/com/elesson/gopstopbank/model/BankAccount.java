package com.elesson.gopstopbank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankAccount extends AbstractEntity {
    private double moneyAmount;
    private Bank bank;
    private Integer ownerId;


    public BankAccount(@JsonProperty("ownerId")Integer ownerId) {
        this.ownerId = ownerId;
        moneyAmount = 0;
    }

    public void assignId(Bank bank) {
        this.bank = bank;
        setId(bank.getNextAccountId());
        bank.getBankAccountsMap().put(id, this);
    }

    @JsonIgnore
    public Integer getBankId() {
        return bank.getId();
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
