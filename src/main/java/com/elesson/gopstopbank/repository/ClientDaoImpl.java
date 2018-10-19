package com.elesson.gopstopbank.repository;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("client")
public class ClientDaoImpl implements Dao {
    private static Map<Integer, Client> clients = new HashMap<>();


    static {
        Client joe = new Client("Joe");
        clients.put(joe.getId(), joe);

        Client jeem = new Client("Jeem");
        clients.put(jeem.getId(), jeem);
    }



    @Override
    public AbstractEntity save(AbstractEntity entity) {
        return clients.put(entity.getId(), (Client)entity);
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
    public boolean delete(Integer id) {
        return clients.remove(id) != null;
    }
}
