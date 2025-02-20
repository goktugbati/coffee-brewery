package com.dataflow.coffeeservice.web.controller;

import com.dataflow.coffeeservice.web.model.CoffeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/coffee")
@RestController
@Slf4j
public class CoffeeController {

    @GetMapping({"/{coffeeId}"})
    public ResponseEntity<CoffeeDto> getCoffeeById(@PathVariable UUID coffeeId) {
        //todo impl
        return ResponseEntity.ok(CoffeeDto.builder().build());
    }

    @PostMapping
    public ResponseEntity saveNewCoffee(@RequestBody CoffeeDto coffeeDto) {
        //todo impl
        return ResponseEntity.created(null).build();
    }

    @PutMapping({"/{coffeeId}"})
    public ResponseEntity updateCoffeeById(@PathVariable UUID coffeeId,
                                           @RequestBody CoffeeDto coffeeDto) {
        //todo impl
        return ResponseEntity.noContent().build();
    }
}
