package com.gus.carshop.repository;

import com.gus.carshop.model.Car;
import com.gus.carshop.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
