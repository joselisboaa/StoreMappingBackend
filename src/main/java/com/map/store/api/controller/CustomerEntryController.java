package com.map.store.api.controller;

import com.map.store.domain.model.CustomerEntry;
import com.map.store.domain.service.ICustomerEntryService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer-entry/")
@Resource
public class CustomerEntryController {
    @Autowired
    private ICustomerEntryService customerEntryService;

    @GetMapping
    public ResponseEntity<List<CustomerEntry>> getAll() {
        List<CustomerEntry> customerEntries = customerEntryService.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(customerEntries);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CustomerEntry> getById(@PathVariable Long id) {
        CustomerEntry customerEntry = customerEntryService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(customerEntry);
    }

    @PostMapping
    public ResponseEntity<CustomerEntry> create(@RequestBody CustomerEntry customerEntry) {
        CustomerEntry newCustomerEntry = customerEntryService.create(customerEntry);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomerEntry);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CustomerEntry> update(@RequestBody CustomerEntry customerEntry, @PathVariable Long id) {
        CustomerEntry updatedCustomerEntry = customerEntryService.update(customerEntry, id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedCustomerEntry);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        customerEntryService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
