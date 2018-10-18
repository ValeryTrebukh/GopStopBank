package com.elesson.gopstopbank.model;

public class Account extends AbstractEntity {

    private static int accountIdCounter = 100_001;

    private Client owner;
    private double moneyAmount;
    private Bank bank;

    public Account(Client owner, Bank bank) {
        id = accountIdCounter++;
        this.owner = owner;
        this.bank = bank;
        moneyAmount = 0;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
