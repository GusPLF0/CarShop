package com.gus.carshop.repository;

import com.gus.carshop.model.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void itShouldReturnFilteredCarsWhenPassedAModel() {
        //given
        String model = "F-150";
        underTest.save(new Car(1L, "SUV", "BWM", "F-150", 2022, 500000D, "exampe@email.com"));
        underTest.save(new Car(2L, "SUV", "BWM", "F-150", 2022, 500000D, "exampe@email.com"));
        underTest.save(new Car(3L, "SUV", "BWM", "F-140", 2022, 500000D, "exampe@email.com"));
        //when
        List<Car> carsFiltered = underTest.findCarsByModel(model);
        //then
        assertEquals(2, carsFiltered.size());
        for (Car c :
                carsFiltered) {
            assertEquals(model, c.getModel());
        }

    }

    @Test
    void itShouldReturnFilteredCarsWhenPassedAYear() {
        //given
        int year = 2022;
        underTest.save(new Car(1L, "SUV", "BWM", "F-140", 2022, 500000D, "exampe@email.com"));
        underTest.save(new Car(2L, "SUV", "BWM", "F-140", 2021, 500000D, "exampe@email.com"));
        //when
        List<Car> carsFiltered = underTest.findCarsByYear(year);
        //then
        assertEquals(1, carsFiltered.size());
        for (Car c :
                carsFiltered) {
            assertEquals(2022, c.getYear());
        }
    }
}