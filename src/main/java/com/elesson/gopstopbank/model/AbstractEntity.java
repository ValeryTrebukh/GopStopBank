package com.elesson.gopstopbank.model;

public abstract class AbstractEntity {
    protected int id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
