package com.gus.carshop.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private Long id;

	@Column(name = "vehicle_type")
	private String vehicleType;

	@Column
	private String brand;

	@Column
	private String model;

	@Column(name = "car_year",length = 4)
	private Integer year;

	@Column
	private Double price;

	@OneToMany(mappedBy = "car")
	private List<Image> images = new ArrayList<>();

	@Column(name = "seller_email")
	private String sellerEmail;

	public Car() {
	}

	public Car(Long id, String vehicleType, String brand, String model, Integer year, Double price, String emailVendedor) {
		this.id = id;
		this.vehicleType = vehicleType;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
		this.sellerEmail = emailVendedor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return Objects.equals(id, car.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
