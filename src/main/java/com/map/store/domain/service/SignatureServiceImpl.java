package com.map.store.domain.service;

import com.map.store.domain.model.Signature;
import com.map.store.domain.repository.ISignatureRepository;
import com.map.store.domain.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SignatureServiceImpl implements ISignatureService {
    @Autowired
    private ISignatureRepository signatureReposity;

    private final String SIGNATURE_NOT_EXIST = "Essa assinatura não existe ou não foi encontrada.";

     public List<Signature> getAll() {
         return signatureReposity.findAll();
     }

     public Signature getById(Long id) {
         Optional<Signature> client = signatureReposity.findById(id);

        return client.orElseThrow(() -> {
            throw new ResourceNotFoundException(SIGNATURE_NOT_EXIST);
        });
     }

     public Signature create(Signature client) {
         Signature newSignature = signatureReposity.save(client);

         return newSignature;
     }

     public Signature update(Signature newSignatureData, Long id) {
         try {
             Signature signatureData = signatureReposity.findById(id).get();
             updateSignatureData(signatureData, newSignatureData);
             
             signatureReposity.save(signatureData)

             return signatureData;
         } catch (EntityNotFoundException error) {
             throw new ResourceNotFoundException(SIGNATURE_NOT_EXIST);
         }
     }

     public void deleteById(Long id) {
         try {
             if (signatureReposity.existsById(id)) {
                 signatureReposity.deleteById(id);
             }
             throw new EntityNotFoundException();
         } catch (EntityNotFoundException error) {
             throw new ResourceNotFoundException(SIGNATURE_NOT_EXIST);
         }
     }

     private void updateSignatureData(Signature oldSignatureData, Signature newSignatureData) {
         oldSignatureData.setClient(newSignatureData.getClient());
     }
}
