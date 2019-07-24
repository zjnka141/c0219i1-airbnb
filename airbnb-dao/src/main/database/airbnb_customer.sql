CREATE TABLE `airbnb`.`customers` (
  `id` INT NOT NULL,
  `tenant` VARCHAR(45) NULL,
  `hire_date` DATE NULL,
  `house_type` VARCHAR(45) NULL,
  `house_address` VARCHAR(45) NULL,
  `price` INT(10) NULL,
  `deleted` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));