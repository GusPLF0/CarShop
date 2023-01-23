package com.gus.carshop.controller;

import com.gus.carshop.dto.ImageDTO;
import com.gus.carshop.service.ImageStorageService;
import com.gus.carshop.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
public class ImageController {

	@Autowired
	private ImageStorageService service;

	public ImageController(ImageStorageService service) {
		this.service = service;
	}

	@PostMapping
	public ImageDTO create(@RequestParam("image") MultipartFile image, @RequestParam("car_id") Long id) {
		return service.create(image, id);
	}
}
