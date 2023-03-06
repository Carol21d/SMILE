package com.Smile.SMILE.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Smile.SMILE.models.Patient;

import com.Smile.SMILE.repository.repositoryPatient;

@Service
public class ServicePatientImpl implements ServicePatient {

    @Autowired
    private repositoryPatient repositoryPatient;

    @Transactional(readOnly = true)
    @Override
    public List<Patient> findAll() {
        
        return repositoryPatient.findAll();
    }
    
    @Transactional
    @Override
    public void deleteById(Long id) {
        repositoryPatient.deleteById(id);
        
    }

    @Transactional
    @Override
    public Optional<Patient> findById(Long Id) {
        
        return repositoryPatient.findById(Id);
    }

    @Transactional
    @Override
    public Patient save(Patient patient) {
        
        return repositoryPatient.save(patient);
    }


   

   

   

}
