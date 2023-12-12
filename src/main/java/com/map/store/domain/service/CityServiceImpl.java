package com.map.store.domain.service;

import com.map.store.domain.model.City;
import com.map.store.domain.repository.ICityRepository;
import com.map.store.domain.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {
    @Autowired
    private ICityRepository cityRepository;

    private final String CITY_NOT_EXIST = "Essa cidade não existe ou não foi encontrada.";

     public List<City> getAll() {
         return cityRepository.findAll();
     }

     public City getById(Long id) {
         Optional<City> client = cityRepository.findById(id);

        return client.orElseThrow(() -> {
            throw new ResourceNotFoundException(CITY_NOT_EXIST);
        });
     }

     public City create(City client) {
         City newCity = cityRepository.save(client);

         return newCity;
     }

     public City update(City newCityData, Long id) {
         try {
             City cityData = cityRepository.findById(id).get();
             updateCityData(cityData, newCityData);
             
             cityRepository.save(cityData);

             return cityData;
         } catch (EntityNotFoundException error) {
             throw new ResourceNotFoundException(CITY_NOT_EXIST);
         }
     }

     public void deleteById(Long id) {
         try {
             if (cityRepository.existsById(id)) {
                 cityRepository.deleteById(id);
             }
             throw new EntityNotFoundException();
         } catch (EntityNotFoundException error) {
             throw new ResourceNotFoundException(CITY_NOT_EXIST);
         }
     }

     private void updateCityData(City oldCityData, City newCityData) {
         oldCityData.setName(newCityData.getName());
     }
}
