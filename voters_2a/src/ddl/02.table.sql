CREATE TABLE `voters`.`user` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `nif` VARCHAR(255) NOT NULL,
  `codigo_mesa` INT NOT NULL,
  `password` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));
