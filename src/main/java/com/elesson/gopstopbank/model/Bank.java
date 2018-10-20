package com.elesson.gopstopbank.model;


public class Bank extends AbstractEntity {

    private static int bankIdCounter = 101;

    private String name;

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
}
