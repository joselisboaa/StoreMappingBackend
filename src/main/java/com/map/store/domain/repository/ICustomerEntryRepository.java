package com.map.store.domain.repository;

import com.map.store.domain.model.CustomerEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerEntryRepository extends JpaRepository<CustomerEntry, Long> {}
