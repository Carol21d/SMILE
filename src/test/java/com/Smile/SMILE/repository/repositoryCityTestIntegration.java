
package com.Smile.SMILE.repository;

import static org.assertj.core.api.Assertions.assertThat;



import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.Smile.SMILE.models.City;

@DataJpaTest
public class repositoryCityTestIntegration {


    @Autowired
    repositoryCity repository;

    @Autowired
    EntityManager entityManager;


    @BeforeEach

    public void init(){
        City gijon = new City(1L,"Gijon");
        entityManager.persist(gijon);

    }

    @Test
    public void testFindById() {
         City city = repository.findById(0L).orElseThrow();
        assertThat(city.getId()).isEqualTo(0L);
        assertThat(city.getName()).isEqualTo("Murcia");
    }

    @Test
    public void test_find_by_New_City(){
        City gijon = new City(1L,"Gijon");
        entityManager.persist(gijon);
        entityManager.flush();
        City city = repository.findById(1L).orElse(gijon);
        assertThat(city.getId()).isEqualTo(1L);
        assertThat(city.getName()).isEqualTo("Gijon");


    }

}
