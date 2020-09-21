-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema moviecrusier
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema moviecrusier
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moviecrusier` DEFAULT CHARACTER SET utf8 ;
USE `moviecrusier` ;

-- -----------------------------------------------------
-- Table `moviecrusier`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecrusier`.`movie` (
  `mv_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `mv_name` VARCHAR(100) NULL DEFAULT NULL,
  `mv_gross` BIGINT(23) NULL DEFAULT NULL,
  `mv_active` TINYINT(1) NULL DEFAULT NULL,
  `mv_date_of_launch` DATE NULL DEFAULT NULL,
  `mv_genre` VARCHAR(45) NULL DEFAULT NULL,
  `mv_has_teaser` TINYINT(1) NULL DEFAULT NULL,
  `mv_image_url` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`mv_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moviecrusier`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecrusier`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_username` VARCHAR(60) NULL DEFAULT NULL,
  `us_firstname` VARCHAR(60) NULL DEFAULT NULL,
  `us_lastname` VARCHAR(60) NULL DEFAULT NULL,
  `us_password` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moviecrusier`.`favorites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecrusier`.`favorites` (
  `fv_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fv_us_id` INT(11) NULL DEFAULT NULL,
  `fv_pr_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`fv_id`),
  INDEX `fv_us_fk_idx` (`fv_us_id` ASC),
  INDEX `fv_pr_fk_idx` (`fv_pr_id` ASC),
  CONSTRAINT `fv_pr_fk`
    FOREIGN KEY (`fv_pr_id`)
    REFERENCES `moviecrusier`.`movie` (`mv_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fv_us_fk`
    FOREIGN KEY (`fv_us_id`)
    REFERENCES `moviecrusier`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moviecrusier`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecrusier`.`role` (
  `ro_id` INT(11) NOT NULL,
  `ro_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ro_id`),
  UNIQUE INDEX `ro_id_UNIQUE` (`ro_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moviecrusier`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecrusier`.`user_role` (
  `ur_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ur_us_id` INT(11) NOT NULL,
  `ur_ro_id` INT(11) NOT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `fk_user_role_user_idx` (`ur_us_id` ASC),
  INDEX `fk_user_role_role1_idx` (`ur_ro_id` ASC),
  CONSTRAINT `fk_user_role_role1`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES `moviecrusier`.`role` (`ro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_user`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES `moviecrusier`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
