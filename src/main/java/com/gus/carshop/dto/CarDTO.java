package com.gus.carshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import com.gus.carshop.model.Image;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({"key", "vehicle_type", "brand", "model", "year", "price"})
public class CarDTO  implements Serializable {

    @JsonProperty("id")
    @Mapping("id")
    private Long key;

    @JsonProperty("vehicle_type")
    private String vehicleType;

    private String brand;

    private String model;

    private Integer year;

    private Double price;

	@JsonProperty("seller_email")
	private String sellerEmail;

	private List<Image> images = new ArrayList<>();

	public CarDTO(Long key, String vehicleType, String brand, String model, Integer year, Double price, String sellerEmail) {
		this.key = key;
		this.vehicleType = vehicleType;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
		this.sellerEmail = sellerEmail;
	}

	public CarDTO() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		CarDTO carDTO = (CarDTO) o;
		return Objects.equals(key, carDTO.key);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), key);
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
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

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
}
