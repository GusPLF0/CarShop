package com.gus.carshop.service;

import com.gus.carshop.config.ImageStorageConfig;
import com.gus.carshop.dto.ImageDTO;
import com.gus.carshop.exception.CarNotFoundException;
import com.gus.carshop.exception.FileStorageException;
import com.gus.carshop.exception.ImageNotFoundException;
import com.gus.carshop.mapper.DozerMapper;
import com.gus.carshop.mapper.custom.CustomImageMapper;
import com.gus.carshop.model.Car;
import com.gus.carshop.model.Image;
import com.gus.carshop.repository.CarRepository;
import com.gus.carshop.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

<<<<<<< HEAD
=======
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
>>>>>>> 85c8cd2333108de9fe93f1322f8a0aadd1684e68

@Service
public class ImageStorageService {

	private final Path fileStorageLocation;
	private ImageRepository imageRepository;
	private CarRepository carRepository;

	@Autowired
	public ImageStorageService(ImageRepository imageRepository, CarRepository carRepository, ImageStorageConfig imageStorageConfig) {
		this.imageRepository = imageRepository;
		this.carRepository = carRepository;

		Path path = Paths.get(imageStorageConfig.getUploadDir())
			.toAbsolutePath().normalize();

		this.fileStorageLocation = path;

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception e) {
			throw new FileStorageException("Could not create directory", e);
		}
	}

	public ImageDTO create(MultipartFile image, Long car_id) {
		Image imageEntity = new Image();

		Car car = carRepository.findById(car_id).orElseThrow(CarNotFoundException::new);

		String imageName = StringUtils.cleanPath(Objects.requireNonNull(image.getOriginalFilename()));
		try {
			Path targetLocation = this.fileStorageLocation.resolve(imageName);
			Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new FileStorageException("Couldn't store file " + imageName + ". Please try again");
		}

		imageEntity.setCar(car);
		imageEntity.setImageName(imageName);

		Image save = imageRepository.save(imageEntity);

		ImageDTO imageDTO = CustomImageMapper.convertEntityToDto(save);

		return imageDTO;

	}

	public List<ImageDTO> findAll() {
		List<ImageDTO> imageDTOS = DozerMapper.parseListObject(imageRepository.findAll(), ImageDTO.class);


		return imageDTOS;
	}

	public ImageDTO findById(Long id) {
		Image imageFound = imageRepository.findById(id).orElseThrow(() -> new ImageNotFoundException("Image of id " + id + " not found"));

		ImageDTO imageDTO = DozerMapper.parseObject(imageFound, ImageDTO.class);

		return imageDTO;
	}


	public void deleteImage(Long id) {
		Image imageFound = imageRepository.findById(id).orElseThrow(() -> new ImageNotFoundException("Image of id " + id + " not found"));

		String imageName = imageFound.getImageName();

		try {
			Path targetLocation = this.fileStorageLocation.resolve(imageName);
			Files.deleteIfExists(targetLocation);
		} catch (Exception e) {
			throw new FileStorageException("Couldn't delete file " + imageName + ". Please try again");
		}

		imageRepository.delete(imageFound);
	}
}
