package com.map.store.domain.service;

import com.map.store.domain.model.Signature;

import java.util.List;

public interface ISignatureService {
    List<Signature> getAll();
    Signature getById(Long id);
    Signature create(Signature signature);
    Signature update(Signature signature, Long id);
    void deleteById(Long id);
}
