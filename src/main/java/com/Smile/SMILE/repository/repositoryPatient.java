package com.Smile.SMILE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Smile.SMILE.models.Patient;

public interface repositoryPatient extends JpaRepository <Patient, Long> {
    
}
