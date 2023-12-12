package com.map.store.domain.repository;

import com.map.store.domain.model.Signature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISignatureRepository extends JpaRepository<Signature, Long> {}
