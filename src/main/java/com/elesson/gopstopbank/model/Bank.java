package com.elesson.gopstopbank.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Bank extends AbstractEntity {

    private static int bankIdCounter = 101;

    private String name;

    public Bank(@JsonProperty("name") String name) {
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
