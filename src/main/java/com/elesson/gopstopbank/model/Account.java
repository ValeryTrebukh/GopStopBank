package com.elesson.gopstopbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account extends AbstractEntity {

    private static Integer accountIdCounter = 100_000;

    private double moneyAmount;
    private Integer bankId;
    private Integer ownerId;


    public Account(@JsonProperty("ownerId")Integer ownerId, @JsonProperty("bankId")Integer bankId) {
        this.ownerId = ownerId;
        this.bankId = bankId;
        moneyAmount = 0;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public void assignId() {
        this.setId(++accountIdCounter);
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
