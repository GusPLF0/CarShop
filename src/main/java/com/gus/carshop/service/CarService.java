package com.gus.carshop.service;

import com.gus.carshop.controller.CarController;
import com.gus.carshop.dto.CarDTO;
import com.gus.carshop.exception.CarNotFoundException;
import com.gus.carshop.mapper.DozerMapper;
import com.gus.carshop.model.Car;
import com.gus.carshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CarService {

    private CarRepository repository;

    @Autowired
    public CarService(CarRepository repository) {
        this.repository = repository;
    }


    public CarDTO findById(Long id) {
		CarDTO carDTO = DozerMapper.parseObject(repository.findById(id).orElseThrow(CarNotFoundException::new), CarDTO.class);
//		carDTO.add(linkTo(methodOn(CarController.class).findOneCar(id)).withSelfRel());
		return carDTO;
    }

    public List<CarDTO> findAll() {
		List<CarDTO> carDTOS = DozerMapper.parseListObject(repository.findAll(), CarDTO.class);

//		for (CarDTO carDTO : carDTOS) {
//			carDTO.add(linkTo(methodOn(CarController.class).findAllCars()).withSelfRel());
//		}

		return carDTOS;
    }

    public CarDTO create(CarDTO car) {


        Car convertedCar = DozerMapper.parseObject(car, Car.class);

		CarDTO carDTO = DozerMapper.parseObject(repository.save(convertedCar), CarDTO.class);

//		carDTO.add(linkTo(methodOn(CarController.class).create(car)).withSelfRel());
		return carDTO;
    }

    public CarDTO update(CarDTO car) {
        Car carFound = repository.findById(car.getKey()).orElseThrow(CarNotFoundException::new);

        carFound.setBrand(car.getBrand());
        carFound.setModel(car.getModel());
        carFound.setPrice(car.getPrice());
        carFound.setYear(car.getYear());
        carFound.setVehicleType(car.getVehicleType());

		CarDTO carDTO = DozerMapper.parseObject(repository.save(carFound), CarDTO.class);

//		carDTO.add(linkTo(methodOn(CarController.class).update(car)).withSelfRel());

		return carDTO;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
