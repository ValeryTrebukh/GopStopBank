package com.elesson.gopstopbank.repository;

import com.elesson.gopstopbank.model.AbstractEntity;
import java.util.List;

public interface GopDao {

    AbstractEntity save(AbstractEntity entity);

    AbstractEntity update(AbstractEntity entity);

    AbstractEntity get(Integer id);

    List<AbstractEntity> getAll();

    AbstractEntity delete(Integer id);
}
