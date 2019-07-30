CREATE TABLE `airbnb`.`booking` (
  `id` INT NOT NULL,
  `full_name` VARCHAR(45) NULL,
  `check_in` DATE NULL,
  `check_out` DATE NULL,
  `gender` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  `relationship` VARCHAR(255) NULL,
  `birthday` INT(10) NULL,

  `deleted` VARCHAR(45) NULL,
  `version` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(245) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `created_by` varchar(245) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,

  PRIMARY KEY (`id`));

  ALTER TABLE `airbnb`.`booking`
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;
ALTER TABLE `airbnb`.`booking`
ADD COLUMN `description_booking_house` TEXT NULL AFTER `created_by`;
ADD COLUMN `amount` INT NULL AFTER `description_booking_house`;
CHANGE COLUMN `birthday` `birthday` DATE NULL DEFAULT NULL ;