package com.Smile.SMILE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Smile.SMILE.models.Treatment;

public interface repositoryTreatment extends JpaRepository <Treatment,Long> {
    
}
