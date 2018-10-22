package com.elesson.gopstopbank.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Bank extends AbstractEntity {

    private static Integer bankIdCounter = 100;

    private String name;

    public Bank(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void assignId() {
        this.setId(++bankIdCounter);
    }
}
