package com.map.store.domain.service;

import com.map.store.domain.model.Store;
import com.map.store.domain.repository.IStoreRepository;
import com.map.store.domain.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements IStoreService {
    @Autowired
    private IStoreRepository storeRepository;

    private final String STORE_NOT_EXIST = "Essa loja não existe ou não foi encontrada.";


    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store getById(Long id) {
        Optional<Store> store = storeRepository.findById(id);

        return store.orElseThrow(() ->
                new ResourceNotFoundException(STORE_NOT_EXIST));
    }

    @Override
    public Store create(Store store) {
        Store createdStore = storeRepository.save(store);

        return createdStore;
    }

    @Override
    public Store update(Store newStoreData, Long id) {
        try {
            Store storeData = storeRepository.findById(id).get();
            updateStoreData(storeData, newStoreData);
            
            storeRepository.save(storeData);

            return storeData;
        } catch (EntityNotFoundException error) {
            throw new ResourceNotFoundException(STORE_NOT_EXIST);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            if (storeRepository.existsById(id)) {
                storeRepository.deleteById(id);

                return;
            }
            throw new EntityNotFoundException();
        } catch (EntityNotFoundException error) {
            throw new ResourceNotFoundException(STORE_NOT_EXIST);
        }
    }

    private void updateStoreData(Store oldStoreData, Store newStoreData) {
        oldStoreData.setCity(newStoreData.getCity());
        oldStoreData.setLatitude(newStoreData.getLatitude());
        oldStoreData.setLongitude(newStoreData.getLongitude());
    }
}
