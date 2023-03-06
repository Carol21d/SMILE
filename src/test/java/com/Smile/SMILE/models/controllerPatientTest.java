
package com.Smile.SMILE.models;


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

import com.Smile.SMILE.controllers.controllerPatient;
import com.Smile.SMILE.services.ServicePatient;




@WebMvcTest(controllers = controllerPatient.class)
public class controllerPatientTest {
  @Autowired
  private MockMvc mockMvc;


  @MockBean 
   private ServicePatient service;




    @Test
    void test_return__all_patient()  throws Exception{
        List<Patient> patients = new ArrayList<>();


        Patient patientMale =  new Patient(0l,"Bryan");
        Patient patienTFemale = new Patient(2l, "Sofia");

        patients.add(patientMale);
        patients.add(patienTFemale);


        when(service.findAll()).thenReturn(patients);
        MockHttpServletResponse resp = mockMvc.perform(get("/api/patient").accept("application/json"))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse();

        assertThat(resp.getStatus()).isEqualTo(200);
        assertThat(resp.getContentAsString()).contains("Bryan");
        assertThat(resp.getContentAsString()).contains("Sofia");
        
    }

}
