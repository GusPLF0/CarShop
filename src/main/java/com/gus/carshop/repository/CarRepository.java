package com.gus.carshop.repository;

import com.gus.carshop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarsByModel(String model);
    List<Car> findCarsByYear(Integer year);
}

