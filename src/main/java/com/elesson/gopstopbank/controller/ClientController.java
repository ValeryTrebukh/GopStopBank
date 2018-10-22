package com.elesson.gopstopbank.controller;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Client;
import com.elesson.gopstopbank.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(ClientController.CLIENT_URL)
public class ClientController {

    private final Dao clientDao;
    static final String CLIENT_URL = "/clients";

    @Autowired
    public ClientController(@Qualifier("client") Dao clientDao) {
        this.clientDao = clientDao;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AbstractEntity> getClients() {
        return clientDao.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AbstractEntity getClientById(@PathVariable("id") Integer id) {
        return clientDao.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbstractEntity> createClient(@RequestBody Client client) {
        Client saved = (Client) clientDao.save(client);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(CLIENT_URL + "/{id}")
                .buildAndExpand(saved.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(saved);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable("id") Integer id) {
        clientDao.delete(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateClient(@RequestBody Client client, @PathVariable("id") Integer id) {
        client.setId(id);
        clientDao.update(client);
    }
}
