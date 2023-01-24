CREATE TABLE `users`
(
    `id`       bigint      NOT NULL AUTO_INCREMENT,
    `username` varchar(80) NOT NULL,
    `password` varchar(255) DEFAULT NULL,
    `role` varchar(100) DEFAULT NULL,

    PRIMARY KEY (`id`)
);


