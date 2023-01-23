CREATE TABLE `images`
(
    `image_id`  bigint      NOT NULL AUTO_INCREMENT,
    `image_name` varchar(80) NOT NULL,
    `car_id`    bigint      NOT NULL,
    PRIMARY KEY (`image_id`),
    CONSTRAINT `fk_car_image` FOREIGN KEY (`car_id`) REFERENCES `cars` (`car_id`)
);


