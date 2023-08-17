package com.map.store.domain.service;

import com.map.store.domain.model.CustomerEntry;
import com.map.store.domain.model.Store;
import com.map.store.domain.repository.ICustomerEntryRepository;
import com.map.store.domain.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerEntryServiceImpl implements ICustomerEntryService {

    @Autowired
    private ICustomerEntryRepository customerEntryRepository;

    private final String CUSTOMER_ENTRY_NOT_EXIST = "Essa entrada cliente não existe ou não foi encontrada.";

    @Override
    public List<CustomerEntry> getAll() {
        return customerEntryRepository.findAll();
    }

    @Override
    public CustomerEntry getById(Long id) {
        Optional<CustomerEntry> customerEntry = customerEntryRepository.findById(id);

        return customerEntry.orElseThrow(() -> {
            throw new ResourceNotFoundException(CUSTOMER_ENTRY_NOT_EXIST);
        });
    }

    @Override
    public CustomerEntry create(CustomerEntry customerEntry) {
        CustomerEntry newCustomerEntry = customerEntryRepository.save(customerEntry);

        return newCustomerEntry;
    }

    @Override
    public CustomerEntry update(CustomerEntry newCustomerEntryData, Long id) {
        try {
            CustomerEntry customerEntryData = customerEntryRepository.getReferenceById(id);
            updateCustomerEntryData(customerEntryData, newCustomerEntryData);

            return customerEntryData;
        } catch (EntityNotFoundException error) {
            throw new ResourceNotFoundException(CUSTOMER_ENTRY_NOT_EXIST);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            if (customerEntryRepository.existsById(id)) {
                customerEntryRepository.deleteById(id);

                return;
            }

            throw new EntityNotFoundException();
        } catch (EntityNotFoundException error) {
            throw new ResourceNotFoundException(CUSTOMER_ENTRY_NOT_EXIST);
        }
    }

    private void updateCustomerEntryData(CustomerEntry oldCustomerEntryData, CustomerEntry newCustomerEntryData) {
        oldCustomerEntryData.setDay(newCustomerEntryData.getDay());
        oldCustomerEntryData.setMonth(newCustomerEntryData.getMonth());
        oldCustomerEntryData.setCustomerQuantity(newCustomerEntryData.getCustomerQuantity());
    }
}
