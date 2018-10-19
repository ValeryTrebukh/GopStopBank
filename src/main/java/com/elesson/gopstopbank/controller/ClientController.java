package com.elesson.gopstopbank.controller;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final Dao clientDao;

    @Autowired
    public ClientController(@Qualifier("client") Dao clientDao) {
        this.clientDao = clientDao;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AbstractEntity> getAll() {
        return clientDao.getAll();
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AbstractEntity get(@PathVariable("id") int id) {
        return clientDao.get(id);
    }

}
