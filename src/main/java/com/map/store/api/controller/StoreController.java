package com.map.store.api.controller;

import com.map.store.domain.model.Store;
import com.map.store.domain.service.IStoreService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stores/")
@Resource
public class StoreController {
    @Autowired
    private IStoreService storeService;

    @GetMapping
    public ResponseEntity<List<Store>> getAll() {
        List<Store> stores = storeService.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(stores);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Store> getById(@PathVariable Long id) {
        Store store = storeService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(store);
    }

    @PostMapping
    public ResponseEntity<Store> create(@RequestBody Store store) {
        Store createdStore = storeService.create(store);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdStore);
    }

    @PutMapping("{id}")
    public ResponseEntity<Store> update(@RequestBody Store store, @PathVariable Long id) {
        Store updatedStore = storeService.update(store, id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedStore);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        storeService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
