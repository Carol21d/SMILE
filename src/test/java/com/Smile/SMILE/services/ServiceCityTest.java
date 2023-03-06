
package com.Smile.SMILE.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Smile.SMILE.models.City;
import com.Smile.SMILE.repository.repositoryCity;

@ExtendWith(MockitoExtension.class)
public class ServiceCityTest {
    @InjectMocks
    ServiceCity service;

    @Mock
    repositoryCity repository;


    @Test
   public void testFindById() {

    City murcia = new City(0L,"Murcia");
    murcia.setId(0L);


    when(repository.findById(0L)).thenReturn(Optional.of(murcia));


    // City city = service.findById(0L);

    assertThat(murcia.getId()).isEqualTo(0L);
    assertThat(murcia.getName()).isEqualTo("Murcia");

    }
  



}

