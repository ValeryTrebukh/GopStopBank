package com.elesson.gopstopbank.model;

public class Client extends AbstractEntity {

    private static int clientIdCounter = 1001;

    private String name;

    public Client(String name) {
        id = clientIdCounter++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
