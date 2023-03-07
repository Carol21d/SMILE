
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
    ServiceCityImpl service;

    @Mock
    repositoryCity repository;

    public ServiceCityTest() {
        this.service = new ServiceCityImpl();
    }

    @Test
    public void testFindById() {

        City badCity = new City(null, null);
        City murcia = new City(1L, "Murcia");
        murcia.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(murcia));
        City city = service.findById(1L).orElse(badCity);

        assertThat(city.getId()).isEqualTo(1L);
        assertThat(city.getName()).isEqualTo("Murcia");

    }

}
