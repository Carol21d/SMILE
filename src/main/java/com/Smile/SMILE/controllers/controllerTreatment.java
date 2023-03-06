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

import com.Smile.SMILE.models.Treatment;

import com.Smile.SMILE.services.ServiceTreatment;


@RestController
@RequestMapping(path = "api/treatment")
public class controllerTreatment {
    @Autowired
    private ServiceTreatment service;

    // public controllerProfile(ServiceSmile service){
    //     this.service = service;
    // }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.findAll());
    } 
    @GetMapping(value = "/{id}")
    public ResponseEntity<?>get(@PathVariable Long id){
        Optional<Treatment> oTreatment = service.findById(id);
        if(oTreatment.isEmpty()){
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(oTreatment.get());
    }

    @PostMapping(value="")
    @ResponseStatus(value= HttpStatus.CREATED)
    public ResponseEntity<?> store(@RequestBody Treatment treatment){
        try{
            return ResponseEntity.ok(service.save(treatment));
        } catch (Exception e){
            return ResponseEntity.status(500).body("Error");
        }
    }

    @DeleteMapping(value="/{id}")
    public void erase(@PathVariable Long id){
        service.deleteById(id);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updating(@RequestBody Treatment treatmentDetails, @PathVariable Long id){
        Optional<Treatment> treatment = service.findById(id);
        if(!treatment.isPresent()){
            return ResponseEntity.notFound().build();
        }
        treatment.get().setTitle(treatmentDetails.getTitle());
        return ResponseEntity.ok().build();
    }

}

