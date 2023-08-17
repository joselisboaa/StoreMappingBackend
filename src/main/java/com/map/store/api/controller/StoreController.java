package com.map.store.api.controller;

import com.map.store.domain.model.Store;
import com.map.store.domain.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("store/")
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

        return ResponseEntity.status(HttpStatus.CREATED).body(store);
    }
}
