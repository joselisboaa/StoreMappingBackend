package com.map.store.api.controller;

import com.map.store.domain.model.Client;
import com.map.store.domain.service.IClientService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients/")
@Resource
public class ClientController {
    @Autowired
    private IClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients =  clientService.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        Client client = clientService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        Client newClient = clientService.create(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable Long id) {
        Client updatedClient = clientService.update(client, id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedClient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        clientService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
