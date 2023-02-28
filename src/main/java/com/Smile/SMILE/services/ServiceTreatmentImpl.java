package com.Smile.SMILE.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Smile.SMILE.models.Treatment;
import com.Smile.SMILE.repository.repositoryTreatment;

@Service
public class ServiceTreatmentImpl implements ServiceTreatment {

    @Autowired
    private repositoryTreatment repositoryTreatment;

    @Transactional(readOnly = true)
    @Override
    public List<Treatment> findAll() {
        return repositoryTreatment.findAll();
    }

    @Transactional
    @Override
    public Optional<Treatment> findById(Long Id) {
        return repositoryTreatment.findById(Id);
    }

    @Transactional
    @Override
    public Treatment save(Treatment treatment) {
        return repositoryTreatment.save(treatment);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
       repositoryTreatment.deleteById(id);
    }
    
}
