package com.Smile.SMILE.controllers;

import java.util.List;

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
import com.Smile.SMILE.services.ServicePatient;
import com.Smile.SMILE.services.ServiceProfile;


@RestController
@RequestMapping(path = "/api/clinicadental/patient")
public class controllerPatient {
    @Autowired
    private ServicePatient service;

  

    @GetMapping(value="")
    public List<Profile> index(){
        return service.getAll();
    }
    @GetMapping(value = "/{id}")
    public Profile show(@PathVariable Long id){
        return service.getOne(id);
    }

    @PostMapping(value="")
    @ResponseStatus(value= HttpStatus.CREATED)
    public ResponseEntity<?> store(@RequestBody Profile newProfile){
        try{
            return ResponseEntity.ok(service.save(newProfile));
        } catch (Exception e){
            return ResponseEntity.status(500).body("Error");
        }
    }

    @DeleteMapping(value="/{id}")
    public void erase(@PathVariable Long id){
        service.deleteById(id);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updating(@RequestBody Profile newProfile){
        try{
            return ResponseEntity.ok(service.save(newProfile));
        } catch (Exception e){
            return ResponseEntity.status(500).body("Error");
        }
    }

}

