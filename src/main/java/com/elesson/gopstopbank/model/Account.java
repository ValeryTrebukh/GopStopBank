package com.elesson.gopstopbank.model;

public class Account extends AbstractEntity {

    private static int accountIdCounter = 100_001;

//    private Client owner;
//    private Bank bank;
    private double moneyAmount;
    private Integer ownerId;
    private Integer bankId;

//    public Account(Client owner, Bank bank) {
//        id = accountIdCounter++;
//        this.owner = owner;
//        this.bank = bank;
//        moneyAmount = 0;
//    }

    public Account(Integer ownerId, Integer bankId) {
        id = accountIdCounter++;
        this.ownerId = ownerId;
        this.bankId = bankId;
        moneyAmount = 0;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

//    public Client getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Client owner) {
//        this.owner = owner;
//    }
//
//    public Bank getBank() {
//        return bank;
//    }
//
//    public void setBank(Bank bank) {
//        this.bank = bank;
//    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
