CREATE TABLE `cars`
(
    `id`          bigint      NOT NULL AUTO_INCREMENT,
    `vehicle_type` varchar(80) NOT NULL,
    `brand`       varchar(80) DEFAULT NULL,
    `model`       varchar(80) NOT NULL,
    `year`        smallint    NOT NULL,
    `price`       decimal(10,2)     NOT NULL,
        PRIMARY KEY (`id`)
);


