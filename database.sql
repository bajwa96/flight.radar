CREATE DATABASE `flightRadar` ;
-- flightRadar.Country definition

CREATE TABLE `Country` (
  `name` varchar(100) NOT NULL,
  `code` varchar(100) NOT NULL,
  `code3` varchar(100) NOT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) DEFAULT 'System',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(100) DEFAULT 'System',
  PRIMARY KEY (`code`)
) ;

-- flightRadar.flight_info definition

CREATE TABLE `flight_info` (
  `flight_info_pk_id` int NOT NULL AUTO_INCREMENT,
  `hex` varchar(100) DEFAULT NULL,
  `flag` varchar(100) DEFAULT NULL,
  `reg_number` varchar(100),
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `altitude` int DEFAULT NULL,
  `direction` int DEFAULT NULL,
  `vertical_velocity` int DEFAULT NULL,
  `squawk` varchar(100) DEFAULT NULL,
  `flight_number` varchar(100) DEFAULT NULL,
  `flight_icao` varchar(100) DEFAULT NULL,
  `flight_iata` varchar(100) DEFAULT NULL,
  `dep_icao` varchar(100) DEFAULT NULL,
  `dep_iata` varchar(100) DEFAULT NULL,
  `arr_icao` varchar(100) DEFAULT NULL,
  `airline_icao` varchar(100) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `update_user` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `aircraft_icao` varchar(100) DEFAULT NULL,
  `speed` int DEFAULT NULL,
  `airline_iata` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`flight_info_pk_id`),
  KEY `flight_data_FK` (`flag`)
) ;

-- flightRadar.update_history definition

CREATE TABLE `update_history` (
  `pk_update_history_id` int NOT NULL AUTO_INCREMENT,
  `table_name` varchar(100) NOT NULL,
  `last_update` datetime DEFAULT NULL,
  `update_user` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_update_history_id`),
  UNIQUE KEY `update_history_UN` (`table_name`)
);

CREATE TRIGGER `update_history_trigger_country_in` AFTER INSERT ON `country` FOR EACH ROW INSERT IGNORE INTO flightRadar.update_history (table_name, last_update, update_user,update_time,create_user,create_time) 
VALUES('country', now(), 'Trigger', now(),'Trigger', now())  ON DUPLICATE KEY UPDATE last_update=now(), update_user='Trigger', update_time=now();

CREATE TRIGGER `update_history_trigger_country_in` AFTER UPDATE ON `country` FOR EACH ROW INSERT IGNORE INTO flightRadar.update_history (table_name, last_update, update_user,update_time,create_user,create_time) 
VALUES('country', now(), 'Trigger', now(),'Trigger', now())  ON DUPLICATE KEY UPDATE last_update=now(), update_user='Trigger', update_time=now();

CREATE TRIGGER `update_history_trigger` AFTER INSERT ON `flight_info` FOR EACH ROW INSERT IGNORE INTO flightRadar.update_history (table_name, last_update, update_user,update_time,create_user,create_time) 
VALUES('flight_info', now(), 'Trigger', now(),'Trigger', now())  ON DUPLICATE KEY UPDATE last_update=now(), update_user='Trigger', update_time=now();

CREATE TRIGGER `update_history_trigger_up` AFTER UPDATE ON `flight_info` FOR EACH ROW INSERT IGNORE INTO flightRadar.update_history (table_name, last_update, update_user,update_time,create_user,create_time) 
VALUES('flight_info', now(), 'Trigger', now(),'Trigger', now())  ON DUPLICATE KEY UPDATE last_update=now(), update_user='Trigger', update_time=now();

CREATE DATABASE `login_service`;

-- login_service.lu_user_role definition

CREATE TABLE `lu_user_role` (
  `pk_user_role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pk_user_role_id`)
) ;

-- login_service.lu_users definition

CREATE TABLE `lu_users` (
  `pk_user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `fk_user_role_id` int DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `create_user` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `password` varchar(100) NOT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`pk_user_id`),
  KEY `lu_users_FK` (`fk_user_role_id`),
  CONSTRAINT `lu_users_FK` FOREIGN KEY (`fk_user_role_id`) REFERENCES `lu_user_role` (`pk_user_role_id`)
);

INSERT INTO login_service.lu_user_role (role_name) VALUES
	 ('ADMIN'),
	 ('Client');

INSERT INTO login_service.lu_users (user_name,fk_user_role_id,email,create_user,create_time,update_user,update_time,password,is_deleted) VALUES
	 ('admin',3,'abcd@gmail.com',NULL,'2022-11-11 00:37:27',NULL,'2022-11-11 00:37:27','$2a$10$Czh54dcHKoQYABgKuTy5qOLBaBF0ODL5dvzHCUp8jtLruJsklfPmS',0);
-- adding query for adding one user with userName:admin, password:password

-- inorder to configure db in the project please check db.properties, and application.properties file

