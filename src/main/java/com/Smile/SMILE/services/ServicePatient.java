package com.Smile.SMILE.services;

import java.util.List;
import java.util.Optional;

import com.Smile.SMILE.models.Patient;


public interface ServicePatient {

    public List<Patient> findAll();
    public Optional<Patient> findById(Long Id);
    public Patient save(Patient  patient);
    public void deleteById(Long id);
  

}
