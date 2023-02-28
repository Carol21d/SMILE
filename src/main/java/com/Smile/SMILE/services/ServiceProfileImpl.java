package com.Smile.SMILE.services;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Smile.SMILE.models.Profile;
import com.Smile.SMILE.repository.repositoryProfile;

@Service
public class ServiceProfileImpl implements ServiceProfile{

    @Autowired
    private repositoryProfile repositoryProfile;

    @Transactional(readOnly = true)
    @Override
    public List<Profile> findAll() {
        return repositoryProfile.findAll();
    }

    @Transactional
    @Override
    public Optional<Profile> findById(Long Id) {
        return repositoryProfile.findById(Id);
    }

    @Transactional
    @Override
    public Profile save(Profile profile) {
        return repositoryProfile.save(profile);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repositoryProfile.deleteById(id);
    }
    
}
