package com.digitalhouse.Quality.integration;

import com.digitalhouse.Quality.exceptions.DistrictNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiPropertyIntegrationTest {

    String request = "{ \"propName\": \"Casa Rosada\", \"propDistrict\" : \"Bairro A\", "
            + "\"roons\" : ["
            + "{\"roomName\" : \"Sala\", \"roomWidth\" : 10.0, \"roomLength\" : 15.0 },"
            + "{ \"roomName\" : \"Quarto Suite\",\"roomWidth\" : 10.0, \"roomLength\" : 10.0 },"
            + "{ \"roomName\" : \"Escritorio\", \"roomWidth\" : 8.0, \"roomLength\" : 8.0 } "
            + "] }\"";

    String requestException = "{ \"propName\": \"Casa Rosada\", \"propDistrict\" : \"Bairro X\", "
            + "\"roons\" : ["
            + "{\"roomName\" : \"Sala\", \"roomWidth\" : 10.0, \"roomLength\" : 15.0 }"
            + "] }\"";

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getTotalAreaApiTest() throws Exception {
        this.mockMvc.perform(get("/proparea").contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath(
                 "$.propName"
                ).value(
                        "Casa Rosada"
                )
                )
                .andExpect(jsonPath("message").value("Total area: 314.0"));
    }

    @Test
    public void getPriceTest() throws Exception {
        this.mockMvc.perform(get("/price").contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.propName").value("Casa Rosada"))
                .andExpect(jsonPath("$.message").value("Total price: $ 471.0"));
    }


    @Test
    public void getPriceExceptionCaseTest() throws Exception {
        this.mockMvc.perform(get("/price").contentType(MediaType.APPLICATION_JSON)
                .content(requestException))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof DistrictNotFoundException));
    }

    @Test
    public void getBiggesTest() throws Exception {
        this.mockMvc.perform(get("/bigroom").contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roomName").value("Sala"))
                .andExpect(jsonPath("$.roomWidth").value(10.0))
                .andExpect(jsonPath("$.roomLength").value(15.0));
    }
}
