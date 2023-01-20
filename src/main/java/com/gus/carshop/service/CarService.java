package com.gus.carshop.service;

import com.gus.carshop.dto.CarDTO;
import com.gus.carshop.exception.CarNotFoundException;
import com.gus.carshop.mapper.DozerMapper;
import com.gus.carshop.model.Car;
import com.gus.carshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository repository;

    @Autowired
    public CarService(CarRepository repository) {
        this.repository = repository;
    }


    public CarDTO findById(Long id) {
        return DozerMapper.parseObject(repository.findById(id).orElseThrow(CarNotFoundException::new), CarDTO.class);
    }

    public List<CarDTO> findAll() {
        return DozerMapper.parseListObject(repository.findAll(), CarDTO.class);
    }

    public CarDTO create(CarDTO car) {

        Car convertedCar = DozerMapper.parseObject(car, Car.class);

        return DozerMapper.parseObject(repository.save(convertedCar), CarDTO.class);
    }

    public CarDTO update(CarDTO car) {
        Car carFound = repository.findById(car.getKey()).orElseThrow(CarNotFoundException::new);

        carFound.setBrand(car.getBrand());
        carFound.setModel(car.getModel());
        carFound.setPrice(car.getPrice());
        carFound.setYear(car.getYear());
        carFound.setVehicleType(car.getVehicleType());

        return DozerMapper.parseObject(repository.save(carFound), CarDTO.class);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
