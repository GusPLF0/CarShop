package com.gus.carshop.controller;

import com.gus.carshop.dto.CarDTO;
import com.gus.carshop.model.Car;
import com.gus.carshop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public CarDTO findOneCar(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping()
    public List<CarDTO> findAllCars() {
        return service.findAll();
    }

    @PostMapping()
    public CarDTO create(@RequestBody CarDTO car) {
        return service.create(car);
    }

    @PutMapping()
    public CarDTO update(@RequestBody CarDTO car) {
        return service.update(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
