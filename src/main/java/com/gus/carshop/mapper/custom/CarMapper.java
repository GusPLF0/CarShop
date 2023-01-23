package com.gus.carshop.mapper.custom;

import com.gus.carshop.dto.ImageDTO;
import com.gus.carshop.model.Image;
import org.springframework.stereotype.Service;

@Service
public class CarMapper {

	public static ImageDTO convertEntityToDto(Image image){
		ImageDTO imageDTO = new ImageDTO();
		imageDTO.setId(image.getId());
		imageDTO.setImageName(image.getImageName());
		return imageDTO;
	}

	public static Image convertDtoToEntity(ImageDTO imageDTO){
		Image image = new Image();
		image.setId(imageDTO.getId());
		image.setImageName(imageDTO.getImageName());
		return image;
	}
}
