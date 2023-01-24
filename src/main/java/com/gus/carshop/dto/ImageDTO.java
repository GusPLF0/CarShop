package com.gus.carshop.dto;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class ImageDTO implements Serializable {

	private Long id;
	private String imageName;

	public ImageDTO() {
	}

	public ImageDTO(Long id, String imageName) {
		this.id = id;
		this.imageName = imageName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ImageDTO imageDTO = (ImageDTO) o;
		return Objects.equals(id, imageDTO.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
