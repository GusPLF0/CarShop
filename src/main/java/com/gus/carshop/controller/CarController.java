package com.gus.carshop.controller;

import com.gus.carshop.dto.CarDTO;
import com.gus.carshop.model.Car;
import com.gus.carshop.service.CarService;
import com.gus.carshop.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gus.carshop.util.MediaType.APPLICATION_JSON;
import static com.gus.carshop.util.MediaType.APPLICATION_XML;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CarDTO findOneCar(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<CarDTO> findAllCars() {
        return service.findAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CarDTO create(@RequestBody CarDTO car) {
        return service.create(car);
    }

    @PutMapping(consumes = {APPLICATION_JSON, APPLICATION_XML}, produces = {APPLICATION_JSON, APPLICATION_XML})
    public CarDTO update(@RequestBody CarDTO car) {
        return service.update(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
