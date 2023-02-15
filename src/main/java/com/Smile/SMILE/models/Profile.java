package com.Smile.SMILE.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERFIL")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DNI")
    private Long id;
    @Column (name="id_ciudad")
    private String ciudad;
    @Column(name = "edad")
    private int edad;
    @Column (name="TLF Contacto")
    private int contacto;
    @Column (name= "direccion")
    private String direccion;
    @Column(name="id_tratamiento")
    private String id_tratamiento;

    public Profile(Long id, String ciudad, int edad, int contacto, String direccion, String id_tratamiento) {
        this.id = id;
        this.ciudad = ciudad;
        this.edad = edad;
        this.contacto = contacto;
        this.direccion = direccion;
        this.id_tratamiento = id_tratamiento;
    }

    public Profile(){

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getContacto() {
        return contacto;
    }
    public void setContacto(int contacto) {
        this.contacto = contacto;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getId_tratamiento() {
        return id_tratamiento;
    }
    public void setId_tratamiento(String id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }
    
    @OneToOne(mappedBy = "Profile")
    private List <Patient> PACIENTE;
}
