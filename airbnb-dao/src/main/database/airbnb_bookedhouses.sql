CREATE TABLE `booked_houses` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `customer` varchar(45) NOT NULL,
  `address` varchar(255) NOT NULL,
  `area` varchar(45) NOT NULL,
  `type_house` varchar(255) NOT NULL,
  `number_of_bathrooms` int(11) NOT NULL,
  `price` varchar(45) NOT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated_date` datetime DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci