package com.Smile.SMILE.services;

import java.util.Optional;
import java.util.List;

import com.Smile.SMILE.models.Profile;


public interface ServiceProfile {
    
    public Profile save(Profile profile);
    public void deleteById(Long id);
    public List<Profile>findAll();
    public Optional<Profile> findById(Long Id);
   
}
