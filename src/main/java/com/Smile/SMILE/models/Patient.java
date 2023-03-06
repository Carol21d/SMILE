package com.Smile.SMILE.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
  
    @Column(name = "dni", nullable = false)
    private Long dni;
    @Column(nullable = false, length = 45)
    private String name;

    public Patient(Long dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public Patient() {

    }

    public Long getId() {
        return dni;
    }

    public void setId(Long dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    private List<Treatment> treatment;
    

}
