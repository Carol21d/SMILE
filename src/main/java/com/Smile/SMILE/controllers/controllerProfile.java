package com.Smile.SMILE.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Smile.SMILE.models.Profile;

import com.Smile.SMILE.services.ServiceProfile;


@RestController
@RequestMapping(path = "/api/profile")
public class controllerProfile {
    @Autowired
    private ServiceProfile service;

   

    @GetMapping (value = " ")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        Optional<Profile> oProfile = service.findById(id);
        if(oProfile.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oProfile.get());
    }

    @PostMapping(value="")
    @ResponseStatus(value= HttpStatus.CREATED)
    public ResponseEntity<?> store(@RequestBody Profile profile){
        try{
            return ResponseEntity.ok(service.save(profile));
        } catch (Exception e){
            return ResponseEntity.status(500).body("Error");
        }
    }

    @DeleteMapping(value="/{id}")
    public void erase(@PathVariable Long id){
        service.deleteById(id);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updating(@RequestBody Profile profileDetails, @PathVariable Long id){
       Optional<Profile> profile = service.findById(id);
        if(!profile.isPresent()){
            return ResponseEntity.notFound().build();
        }

        
        profile.get().setId_treatment(profileDetails.getId_treatment());
        return ResponseEntity.ok().build();
    }

}