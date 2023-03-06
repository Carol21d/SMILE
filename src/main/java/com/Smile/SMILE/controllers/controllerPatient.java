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

import com.Smile.SMILE.models.Patient;
import com.Smile.SMILE.services.ServicePatient;



@RestController
@RequestMapping(path = "/api/patient")
public class controllerPatient {
    @Autowired
    private ServicePatient service;

  

    @GetMapping(value = "")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?>get(@PathVariable Long id){
        Optional<Patient> oPatient = service.findById(id);
        if(oPatient.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oPatient.get());
    }

    @PostMapping(value="")
    @ResponseStatus(value= HttpStatus.CREATED)
    public ResponseEntity<?> store(@RequestBody Patient patient){
        try{
            return ResponseEntity.ok(service.save(patient));
        } catch (Exception e){
            return ResponseEntity.status(500).body("Error");
        }
    }

    @DeleteMapping(value="/{id}")
    public void erase(@PathVariable Long id){
        service.deleteById(id);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updating(@RequestBody Patient patientDetails, @PathVariable Long id){
       Optional<Patient> patient = service.findById(id);
       if(!patient.isPresent()){
        return ResponseEntity.notFound().build();
       }
       patient.get().setName(patientDetails.getName());
       return ResponseEntity.ok().build();
       
    }

}

