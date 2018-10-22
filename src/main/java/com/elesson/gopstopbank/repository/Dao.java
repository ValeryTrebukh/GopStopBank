package com.elesson.gopstopbank.repository;

import com.elesson.gopstopbank.model.AbstractEntity;
import java.util.List;

public interface Dao {

    AbstractEntity save(AbstractEntity entity);

    AbstractEntity update(AbstractEntity entity);

    AbstractEntity get(Integer id);

    List<AbstractEntity> getAll();

    boolean delete(Integer id);
}
