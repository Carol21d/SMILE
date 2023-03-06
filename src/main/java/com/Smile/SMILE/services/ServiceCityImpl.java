package com.Smile.SMILE.services;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Smile.SMILE.models.City;

import com.Smile.SMILE.repository.repositoryCity;

@Service
public class ServiceCityImpl implements ServiceCity{
    
    @Autowired
    public repositoryCity repositoryCity;

    @Transactional(readOnly = true)
    @Override
    public List<City> findAll() {
        return repositoryCity.findAll();
    }

    @Transactional
    @Override
    public void deleteById(Long id){
        repositoryCity.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<City> findById(Long Id) {
        return repositoryCity.findById(Id);
    }


    @Transactional
    @Override
    public City save(City city) {
        
        return repositoryCity.save(city);
    }

}
