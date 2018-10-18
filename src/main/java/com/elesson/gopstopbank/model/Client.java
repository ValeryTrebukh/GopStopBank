package com.elesson.gopstopbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Client extends AbstractEntity {

    private static Integer clientIdCounter = 1000;

    private String name;

    public Client(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void assignId() {
        this.setId(++clientIdCounter);
    }
}
