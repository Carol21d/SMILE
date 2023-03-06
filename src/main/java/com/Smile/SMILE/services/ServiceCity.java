package com.Smile.SMILE.services;

import java.util.Optional;
import java.util.List;

import com.Smile.SMILE.models.City;

public interface ServiceCity {

  public City save(City city);

  public void deleteById(Long id);

  public List<City> findAll();

  public Optional<City> findById(Long id);


}
