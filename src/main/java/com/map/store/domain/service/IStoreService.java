package com.map.store.domain.service;

import com.map.store.domain.model.Store;

import java.util.List;

public interface IStoreService {
    List<Store> getAll();
    Store getById(Long id);
    Store create(Store store);
    Store update(Store store, Long id);
    void deleteById(Long id);
}
