package com.map.store.api.controller;

import com.map.store.domain.model.Signature;
import com.map.store.domain.service.ISignatureService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("signatures/")
@Resource
public class SignatureController {
    @Autowired
    private ISignatureService signatureService;

    @GetMapping
    public ResponseEntity<List<Signature>> getAll() {
        List<Signature> clients =  signatureService.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @GetMapping("{id}")
    public ResponseEntity<Signature> getById(@PathVariable Long id) {
        Signature client = signatureService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @PostMapping
    public ResponseEntity<Signature> create(@RequestBody Signature client) {
        Signature newSignature = signatureService.create(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(newSignature);
    }

    @PutMapping("{id}")
    public ResponseEntity<Signature> update(@RequestBody Signature client, @PathVariable Long id) {
        Signature updatedSignature = signatureService.update(client, id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedSignature);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        signatureService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
