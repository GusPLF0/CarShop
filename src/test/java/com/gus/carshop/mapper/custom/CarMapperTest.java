package com.gus.carshop.mapper.custom;

import com.gus.carshop.dto.CarDTO;
import com.gus.carshop.mapper.DozerMapper;
import com.gus.carshop.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarMapperTest {

    @Test
    void itShouldConvertCarEntityToCarDto() {
        Car car = new Car(1L, "SUV", "BWM", "F-150", 2022, 500000D, "exampe@email.com");

        CarDTO carDTO = DozerMapper.parseObject(car, CarDTO.class);

        assertNotNull(carDTO);

        assertEquals(car.getId(), carDTO.getKey());
        assertEquals(car.getVehicleType(), carDTO.getVehicleType());
        assertEquals(car.getBrand(), carDTO.getBrand());
        assertEquals(car.getModel(), carDTO.getModel());
        assertEquals(car.getYear(), carDTO.getYear());
        assertEquals(car.getPrice(), carDTO.getPrice());
        assertEquals(car.getSellerEmail(), carDTO.getSellerEmail());
    }

    @Test
    void convertDtoToEntity() {
        CarDTO carDTO = new CarDTO(1L, "SUV", "BWM", "F-150", 2022, 500000D, "exampe@email.com");

        Car car = DozerMapper.parseObject(carDTO, Car.class);

        assertNotNull(carDTO);

        assertEquals(carDTO.getKey(), car.getId());
        assertEquals(carDTO.getVehicleType(), car.getVehicleType());
        assertEquals(carDTO.getBrand(), car.getBrand());
        assertEquals(carDTO.getModel(), car.getModel());
        assertEquals(carDTO.getYear(), car.getYear());
        assertEquals(carDTO.getPrice(), car.getPrice());
        assertEquals(carDTO.getSellerEmail(), car.getSellerEmail());
    }
}