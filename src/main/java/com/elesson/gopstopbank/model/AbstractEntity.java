package com.elesson.gopstopbank.model;

public abstract class AbstractEntity {
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
