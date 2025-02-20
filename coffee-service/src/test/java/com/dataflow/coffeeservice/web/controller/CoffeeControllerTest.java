package com.dataflow.coffeeservice.web.controller;

import com.dataflow.coffeeservice.web.model.CoffeeDto;
import com.dataflow.coffeeservice.web.model.CoffeeStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CoffeeController.class)
class CoffeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getCoffeeById() throws Exception {
        mockMvc.perform(get("/api/v1/coffee/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewCoffee() throws Exception {
        CoffeeDto coffeeDto = CoffeeDto.builder()
                .version(1)
                .coffeeName("Coffee")
                .coffeeStyle(CoffeeStyleEnum.AMERICANO)
                .createdDate(null)
                .upc(1234567890L)
                .price(BigDecimal.valueOf(123.000))
                .build();
        String cofeeToJson = objectMapper.writeValueAsString(coffeeDto);

        mockMvc.perform(post("/api/v1/coffee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cofeeToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateCoffeeById() throws Exception {
        CoffeeDto coffeeDto = CoffeeDto.builder().build();
        String cofeeToJson = objectMapper.writeValueAsString(coffeeDto);
        mockMvc.perform(put("/api/v1/coffee/" + UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cofeeToJson))
                .andExpect(status().isNoContent());
    }

}