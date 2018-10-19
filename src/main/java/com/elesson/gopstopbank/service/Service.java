package com.elesson.gopstopbank.service;

import com.elesson.gopstopbank.model.AbstractEntity;

import java.util.List;

public interface Service {

    AbstractEntity save(AbstractEntity entity);

    AbstractEntity get(Integer id);

    List<AbstractEntity> getAll();

    boolean delete(Integer id);
}
