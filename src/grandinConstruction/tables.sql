CREATE DATABASE IF NOT EXISTS `pricesDB`;
USE `pricesDB`;

DROP TABLE IF EXISTS `floor_materials`;
DROP TABLE IF EXISTS `countertop_materials`;
DROP TABLE IF EXISTS `cabinets`;
DROP TABLE IF EXISTS `plumbing_fixtures`;

CREATE TABLE IF NOT EXISTS `floor_materials` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(128) NOT NULL,
	`dollars` DECIMAL(12,2) NOT NULL, -- per square foot
	`supplier` VARCHAR(128),
	PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `countertop_materials` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(128) NOT NULL,
	`dollars` DECIMAL(12,2) NOT NULL, -- per square foot
	`supplier` VARCHAR(128),
    :wq
	PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `cabinets` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(128) NOT NULL,
	`dollars` DECIMAL(12,2) NOT NULL,
	`supplier` VARCHAR(128),
	PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `plumbing_fixtures` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(128) NOT NULL,
	`dollars` DECIMAL(12,2) NOT NULL,
	`supplier` VARCHAR(128),
	PRIMARY KEY(`id`)
);
