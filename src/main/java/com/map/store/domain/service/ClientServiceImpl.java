package com.map.store.domain.service;

import com.map.store.domain.model.Client;
import com.map.store.domain.repository.IClientRepository;
import com.map.store.domain.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private IClientRepository clientRepository;

    private final String CLIENT_NOT_EXIST = "Esse cliente não existe ou não foi encontrado.";

     public List<Client> getAll() {
         return clientRepository.findAll();
     }

     public Client getById(Long id) {
         Optional<Client> client = clientRepository.findById(id);

        return client.orElseThrow(() -> {
            throw new ResourceNotFoundException(CLIENT_NOT_EXIST);
        });
     }

     public Client create(Client client) {
         Client newClient = clientRepository.save(client);

         return newClient;
     }

     public Client update(Client newClientData, Long id) {
         try {
             Client clientData = clientRepository.getReferenceById(id);
             updateClientData(clientData, newClientData);
             
             if (clientData == null) {
                 throw new ResourceNotFoundException("Teste");
             }

             return clientData;
         } catch (EntityNotFoundException error) {
             throw new ResourceNotFoundException(CLIENT_NOT_EXIST);
         }
     }

     public void deleteById(Long id) {
         try {
             if (clientRepository.existsById(id)) {
                 clientRepository.deleteById(id);
             }
             throw new EntityNotFoundException();
         } catch (EntityNotFoundException error) {
             throw new ResourceNotFoundException(CLIENT_NOT_EXIST);
         }
     }

     private void updateClientData(Client oldClientData, Client newClientData) {
         oldClientData.setName(newClientData.getName());
     }
}
