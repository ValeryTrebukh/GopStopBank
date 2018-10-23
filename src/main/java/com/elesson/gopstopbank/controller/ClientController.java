package com.elesson.gopstopbank.controller;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Client;
import com.elesson.gopstopbank.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

//    curl -s -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/gopstop/clients
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AbstractEntity> getClients() {
        return clientDao.getAll();
    }

//    curl -s -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/gopstop/clients/1001
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AbstractEntity getClientById(@PathVariable("id") Integer id) {
        return clientDao.get(id);
    }

//    curl -s -X POST -d '{"name":"Joe Doane"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/gopstop/clients
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbstractEntity> createClient(@RequestBody Client client) {
        clientDao.save(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    curl -X DELETE http://localhost:8080/gopstop/clients/1002
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AbstractEntity> deleteClient(@PathVariable("id") Integer id) {
        clientDao.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    curl -s -X PUT -d '{"name":"James Dean"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/gopstop/clients/1001
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbstractEntity> updateClient(@RequestBody Client client, @PathVariable("id") Integer id) {
        client.setId(id);
        clientDao.update(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
