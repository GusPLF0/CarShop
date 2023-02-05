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


<<<<<<< HEAD
	public CarDTO findById(Long id) {
		CarDTO carDTO = DozerMapper.parseObject(repository.findById(id).orElseThrow(CarNotFoundException::new), CarDTO.class);

		return carDTO;
	}

	public List<CarDTO> findAll() {
		List<CarDTO> carDTOS = DozerMapper.parseListObject(repository.findAll(), CarDTO.class);

		return carDTOS;
	}
=======
    public CarDTO findById(Long id) {
        CarDTO carDTO = DozerMapper.parseObject(repository.findById(id).orElseThrow(CarNotFoundException::new), CarDTO.class);
//		carDTO.add(linkTo(methodOn(CarController.class).findOneCar(id)).withSelfRel());
        return carDTO;
    }

    public List<CarDTO> findAll() {
        List<CarDTO> carDTOS = DozerMapper.parseListObject(repository.findAll(), CarDTO.class);

        return carDTOS;
    }
>>>>>>> 85c8cd2333108de9fe93f1322f8a0aadd1684e68

	public CarDTO create(CarDTO car) {


		Car convertedCar = DozerMapper.parseObject(car, Car.class);

        CarDTO carDTO = DozerMapper.parseObject(repository.save(convertedCar), CarDTO.class);

<<<<<<< HEAD
		return carDTO;
	}
=======
//		carDTO.add(linkTo(methodOn(CarController.class).create(car)).withSelfRel());
        return carDTO;
    }
>>>>>>> 85c8cd2333108de9fe93f1322f8a0aadd1684e68

	public CarDTO update(CarDTO car) {
		Car carFound = repository.findById(car.getKey()).orElseThrow(CarNotFoundException::new);

		carFound.setBrand(car.getBrand());
		carFound.setModel(car.getModel());
		carFound.setPrice(car.getPrice());
		carFound.setYear(car.getYear());
		carFound.setVehicleType(car.getVehicleType());

        CarDTO carDTO = DozerMapper.parseObject(repository.save(carFound), CarDTO.class);


<<<<<<< HEAD
		return carDTO;
	}
=======
        return carDTO;
    }
>>>>>>> 85c8cd2333108de9fe93f1322f8a0aadd1684e68

	public void delete(Long id) {
		repository.deleteById(id);
	}


}
