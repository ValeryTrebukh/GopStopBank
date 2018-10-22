package com.elesson.gopstopbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Client extends AbstractEntity {

    private static int clientIdCounter = 1001;

    private String name;

    public Client(@JsonProperty("name") String name) {
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
