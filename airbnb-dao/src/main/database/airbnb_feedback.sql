CREATE TABLE `feedbacks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) NOT NULL,
  `rating` int(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `houses_id` int(11) NOT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated_date` datetime DEFAULT NULL,
  `last_updated_by` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  `version` bigint(20) DEFAULT '1',
  PRIMARY KEY (`id`,`houses_id`),
  KEY `fk_feedback_houses1_idx` (`houses_id`),
  CONSTRAINT `fk_feedback_houses1` FOREIGN KEY (`houses_id`) REFERENCES `houses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
