package com.map.store.api.controller;

import com.map.store.domain.model.City;
import com.map.store.domain.service.ICityService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cities/")
@Resource
@CrossOrigin(origins = "*")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        List<City> clients =  cityService.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @GetMapping("{id}")
    public ResponseEntity<City> getById(@PathVariable Long id) {
        City client = cityService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @PostMapping
    public ResponseEntity<City> create(@RequestBody City client) {
        City newCity = cityService.create(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCity);
    }

    @PutMapping("{id}")
    public ResponseEntity<City> update(@RequestBody City client, @PathVariable Long id) {
        City updatedCity = cityService.update(client, id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedCity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        cityService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
