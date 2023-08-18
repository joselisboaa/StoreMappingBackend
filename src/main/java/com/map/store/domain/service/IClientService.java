package com.map.store.domain.service;

import com.map.store.domain.model.Client;

import java.util.List;

public interface IClientService {
    List<Client> getAll();
    Client getById(Long id);
    Client create(Client client);
    Client update(Client client, Long id);
    void deleteById(Long id);
}
