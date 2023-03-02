package com.Smile.SMILE.services;

import java.util.Optional;
import java.util.List;

import com.Smile.SMILE.models.City;
import com.Smile.SMILE.models.Profile;

public interface ServiceCity {
    
  public List<City>findAll();
  public Optional <City> findById(Long Id);
  public City save(Profile newProfile);
  public void deleteById(Long id);
  public List<Profile> getAll();
  public Profile getOne(Long id);
  
}
