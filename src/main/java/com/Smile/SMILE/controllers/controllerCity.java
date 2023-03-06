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

import com.Smile.SMILE.models.City;
import com.Smile.SMILE.services.ServiceCity;



@RestController
@RequestMapping(path = "/api/city")
public class controllerCity {
    @Autowired
    private ServiceCity service;

  

    @GetMapping(value = "")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?>get(@PathVariable Long id){
        Optional<City> oCity = service.findById(id);
        if(oCity.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oCity.get());
    }

    @PostMapping(value="")
    @ResponseStatus(value= HttpStatus.CREATED)
    public ResponseEntity<?> store(@RequestBody City city){
        try{
            return ResponseEntity.ok(service.save(city));
        } catch (Exception e){
            return ResponseEntity.status(500).body("Error");
        }
    }

    @DeleteMapping(value="/{id}")
    public void erase(@PathVariable Long id){
        service.deleteById(id);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updating(@RequestBody City cityDetails, @PathVariable Long id){
       Optional<City> city = service.findById(id);
       if(!city.isPresent()){
        return ResponseEntity.notFound().build();
       }
       city.get().setName(cityDetails.getName());
       return ResponseEntity.ok().build();

    }

}
