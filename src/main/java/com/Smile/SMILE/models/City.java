package com.Smile.SMILE.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.GenerationType;


@Entity
@Table(name="cities")
public class City {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id_city",nullable = false)
  private Long id;
    @Column(name="name", nullable = false)
    private String name;

    public City(){
    }

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @OneToMany
    private List<Profile> profiles;
    

}
