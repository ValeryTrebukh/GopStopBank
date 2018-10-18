package com.elesson.gopstopbank.model;

import java.util.List;

public class Bank extends AbstractEntity {

    private static int bankIdCounter = 101;

    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        id = bankIdCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
