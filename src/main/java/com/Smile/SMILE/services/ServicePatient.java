package com.Smile.SMILE.services;

import java.util.List;
import java.util.Optional;

import com.Smile.SMILE.models.Patient;
import com.Smile.SMILE.models.Profile;

public interface ServicePatient {

    public List<Patient> findAll();
    public Optional<Patient> findById(Long Id);
    public Patient save(Profile newProfile);
    public void deleteById(Long id);
    public List<Profile> getAll();
    public Profile getOne(Long id);

}
