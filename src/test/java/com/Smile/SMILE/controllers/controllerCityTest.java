
package com.Smile.SMILE.controllers;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.Smile.SMILE.models.City;
import com.Smile.SMILE.services.ServiceCity;


@WebMvcTest(controllers = controllerCity.class)
public class controllerCityTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceCity service;
    @Test
    void tes_return__all_city() throws Exception {
        List<City> cities = new ArrayList<>();

        City murcia = new City(1l,"Murcia");
        cities.add(murcia);

        when(service.findAll()).thenReturn(cities);
        MockHttpServletResponse resp = mockMvc.perform(get("/api/city").accept("application/json"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

         assertThat(resp.getStatus()).isEqualTo(200);
         assertThat(resp.getContentAsString()).contains("Murcia");





    }
}
