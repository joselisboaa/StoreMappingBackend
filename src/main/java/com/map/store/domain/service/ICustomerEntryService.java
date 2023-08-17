package com.map.store.domain.service;

import com.map.store.domain.model.CustomerEntry;

import java.util.List;

public interface ICustomerEntryService {
    List<CustomerEntry> getAll();
    CustomerEntry getById(Long id);
    CustomerEntry create(CustomerEntry customerEntry);
    CustomerEntry update(CustomerEntry customerEntry, Long id);
    void deleteById(Long id);
}
