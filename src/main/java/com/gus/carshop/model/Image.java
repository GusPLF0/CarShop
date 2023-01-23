package com.gus.carshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "images")
public class Image implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id", nullable = false)
	private Long id;

	@Column(name = "image_name")
	private String imageName;

	@ManyToOne
	@JoinColumn(name = "car_id")
	@JsonIgnore
	private Car car;

	public Image() {
	}

	public Image(Long id, String imageName, Car car) {
		this.id = id;
		this.imageName = imageName;
		this.car = car;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Image image = (Image) o;
		return Objects.equals(id, image.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
