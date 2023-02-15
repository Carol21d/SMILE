package com.Smile.SMILE.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PACIENTE")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DNI", nullable = false)
    private Long id;
    @Column(nullable = false, length = 45)
    private String name;
   
    public Patient(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Patient(){

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   
     @OneToOne 
     @JoinColumn(name="DNI", nullable = true)
     Profile profile;
    
}
