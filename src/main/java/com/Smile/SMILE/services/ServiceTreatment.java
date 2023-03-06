package com.Smile.SMILE.services;

import java.util.Optional;
import java.util.List;

import com.Smile.SMILE.models.Treatment;

public interface ServiceTreatment {
    
    public List<Treatment>findAll();
    public Optional<Treatment>findById(Long Id);
    public Treatment save(Treatment treatment);
    public void deleteById(Long id);
  
}
