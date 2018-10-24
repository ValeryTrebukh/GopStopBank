package com.elesson.gopstopbank.controller;

import com.elesson.gopstopbank.model.AbstractEntity;
import com.elesson.gopstopbank.model.Client;
import com.elesson.gopstopbank.repository.GopDao;
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

    private final GopDao clientGopDao;
    static final String CLIENT_URL = "/clients";

    @Autowired
    public ClientController(@Qualifier("clientRepository") GopDao clientGopDao) {
        this.clientGopDao = clientGopDao;
    }

    //    curl -s -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/gopstop/clients
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AbstractEntity>> getClients() {
        List<AbstractEntity> result = clientGopDao.getAll();
        return result == null || result.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(result, HttpStatus.OK);
    }

    //    curl -s -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/gopstop/clients/1001
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbstractEntity> getClientById(@PathVariable("id") Integer id) {
        Client result = (Client) clientGopDao.get(id);
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(result, HttpStatus.OK);
    }

    //    curl -s -X POST -d '{"name":"Joe Doane"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/gopstop/clients
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbstractEntity> createClient(@RequestBody Client client) {
        Client created = (Client)clientGopDao.save(client);
        return created == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(created, HttpStatus.OK);
    }

    //    curl -X DELETE http://localhost:8080/gopstop/clients/1002
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AbstractEntity> deleteClient(@PathVariable("id") Integer id) {
        Client deleted = (Client) clientGopDao.delete(id);
        return deleted == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    //    curl -s -X PUT -d '{"name":"James Dean"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/gopstop/clients/1001
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbstractEntity> updateClient(@RequestBody Client client, @PathVariable("id") Integer id) {
        client.setId(id);
        Client updated = (Client) clientGopDao.update(client);
        return updated == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(HttpStatus.OK);
    }
}
