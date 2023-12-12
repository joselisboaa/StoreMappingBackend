package com.map.store.domain.service;

import com.map.store.domain.model.City;

import java.util.List;

public interface ICityService {
    List<City> getAll();
    City getById(Long id);
    City create(City city);
    City update(City city, Long id);
    void deleteById(Long id);
}
