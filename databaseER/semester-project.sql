-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sysproject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sysproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sysproject` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `sysproject` ;

-- -----------------------------------------------------
-- Table `sysproject`.`RENAMEME`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sysproject`.`RENAMEME` ;

CREATE TABLE IF NOT EXISTS `sysproject`.`RENAMEME` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `DUMMYSTR1` VARCHAR(255) NULL DEFAULT NULL,
  `DUMMYSTR2` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sysproject`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sysproject`.`address` ;

CREATE TABLE IF NOT EXISTS `sysproject`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(255) NULL DEFAULT NULL,
  `ipaddress` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sysproject`.`location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sysproject`.`location` ;

CREATE TABLE IF NOT EXISTS `sysproject`.`location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ip` VARCHAR(45) NULL DEFAULT NULL,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `zipcode` INT NULL DEFAULT NULL,
  `street` VARCHAR(45) NULL DEFAULT NULL,
  `streetnumber` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sysproject`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sysproject`.`users` ;

CREATE TABLE IF NOT EXISTS `sysproject`.`users` (
  `user_name` VARCHAR(25) NOT NULL,
  `user_pass` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`user_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sysproject`.`car`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sysproject`.`car` ;

CREATE TABLE IF NOT EXISTS `sysproject`.`car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `make` VARCHAR(255) NULL DEFAULT NULL,
  `model` VARCHAR(255) NULL DEFAULT NULL,
  `price` INT NULL DEFAULT NULL,
  `year` INT NULL DEFAULT NULL,
  `user_name` VARCHAR(25) NOT NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_car_users1_idx` (`user_name` ASC) VISIBLE,
  INDEX `fk_car_address1_idx` (`location_id` ASC) VISIBLE,
  CONSTRAINT `fk_car_address1`
    FOREIGN KEY (`location_id`)
    REFERENCES `sysproject`.`location` (`id`),
  CONSTRAINT `fk_car_users1`
    FOREIGN KEY (`user_name`)
    REFERENCES `sysproject`.`users` (`user_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sysproject`.`booking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sysproject`.`booking` ;

CREATE TABLE IF NOT EXISTS `sysproject`.`booking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `startdate` VARCHAR(45) NULL DEFAULT NULL,
  `enddate` VARCHAR(45) NULL DEFAULT NULL,
  `user_name` VARCHAR(25) NOT NULL,
  `car_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_booking_users1_idx` (`user_name` ASC) VISIBLE,
  INDEX `fk_booking_car1_idx` (`car_id` ASC) VISIBLE,
  CONSTRAINT `fk_booking_car1`
    FOREIGN KEY (`car_id`)
    REFERENCES `sysproject`.`car` (`id`),
  CONSTRAINT `fk_booking_users1`
    FOREIGN KEY (`user_name`)
    REFERENCES `sysproject`.`users` (`user_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sysproject`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sysproject`.`roles` ;

CREATE TABLE IF NOT EXISTS `sysproject`.`roles` (
  `role_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`role_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sysproject`.`user_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sysproject`.`user_roles` ;

CREATE TABLE IF NOT EXISTS `sysproject`.`user_roles` (
  `user_name` VARCHAR(25) NOT NULL,
  `role_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`user_name`, `role_name`),
  INDEX `FK_user_roles_role_name` (`role_name` ASC) VISIBLE,
  CONSTRAINT `FK_user_roles_role_name`
    FOREIGN KEY (`role_name`)
    REFERENCES `sysproject`.`roles` (`role_name`),
  CONSTRAINT `FK_user_roles_user_name`
    FOREIGN KEY (`user_name`)
    REFERENCES `sysproject`.`users` (`user_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
