package com.Smile.SMILE.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.Smile.SMILE.models.Profile;

import com.Smile.SMILE.repository.repositoryProfile;

@Service

public class ServiceSmile {
    private repositoryProfile repository;
    public ServiceSmile(repositoryProfile repository){
        this.repository = repository;
    }
    public List<Profile> getAll(){
        return repository.findAll();
    }
    public Profile getOne(Long id){
        Profile Profile = repository.findById(id).orElse(null);
        return Profile;
    }
    public Profile save(Profile newProfile){
        Profile ProfileSaved = repository.save(newProfile);
        return ProfileSaved;
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
