package com.Smile.SMILE.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;



@Entity
@Table(name="treatments")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_treatment", nullable = false)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;

    public Treatment(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Treatment(){
        
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    

    }
