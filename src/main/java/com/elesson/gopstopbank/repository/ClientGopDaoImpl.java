package com.elesson.gopstopbank.repository;

import com.elesson.gopstopbank.DataBase;
import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("client")
public class ClientGopDaoImpl implements GopDao {
    private static Map<Integer, Client> clients = DataBase.getClients();

    @Override
    public AbstractEntity save(AbstractEntity entity) {
        Client created = (Client) entity;
        created.assignId();
        return clients.putIfAbsent(created.getId(), created) != null ? created : null;
    }

    @Override
    public AbstractEntity update(AbstractEntity entity) {
        if (clients.containsKey(entity.getId())) {
            return clients.put(entity.getId(), (Client)entity);
        }
        return null;
    }

    @Override
    public AbstractEntity get(Integer id) {
        return clients.get(id);
    }

    @Override
    public List<AbstractEntity> getAll() {
        return new ArrayList<>(clients.values());
    }

    @Override
    public AbstractEntity delete(Integer id) {
        return clients.remove(id);
    }
}
