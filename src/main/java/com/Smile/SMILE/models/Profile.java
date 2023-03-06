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
@Table(name = "profilies")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "id_city")
    private String city;
    @Column(name = "age")
    private int age;
    @Column(name = "phone")
    private int phone;
    @Column(name = "direction")
    private String direction;
    @Column(name = "id_treatment")
    private String id_treatment;

    public Profile(Long id, String city, int age, int phone, String direction, String id_treatment) {
        this.id = id;
        this.city = city;
        this.age = age;
        this.phone = phone;
        this.direction = direction;
        this.id_treatment = id_treatment;
    }

    public Profile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getId_treatment() {
        return id_treatment;
    }

    public void setId_treatment(String id_treatment) {
        this.id_treatment = id_treatment;
    }

    @OneToOne
    @JoinColumn(name = "id_patient" ,nullable=true)
    private Patient patient;

}
