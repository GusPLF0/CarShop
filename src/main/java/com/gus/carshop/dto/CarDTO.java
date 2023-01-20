package com.gus.carshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;


public class CarDTO extends RepresentationModel<CarDTO> implements Serializable {

    @JsonProperty("id")
    @Mapping("id")
    private Long key;

    private String vehicleType;

    private String brand;

    private String model;

    private Integer year;

    private Double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDTO car = (CarDTO) o;
        return Objects.equals(key, car.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    public CarDTO() {
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public Long getKey() {
        return key;
    }
}
