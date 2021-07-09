-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gollajodb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gollajodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gollajodb` DEFAULT CHARACTER SET utf8 ;
USE `gollajodb` ;

-- -----------------------------------------------------
-- Table `gollajodb`.`foods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gollajodb`.`foods` (
  `food_idx` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `url` VARCHAR(2083) NOT NULL,
  PRIMARY KEY (`food_idx`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gollajodb`.`tastes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gollajodb`.`tastes` (
  `taste_idx` INT NOT NULL AUTO_INCREMENT,
  `taste` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`taste_idx`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gollajodb`.`foods_tastes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gollajodb`.`foods_tastes` (
  `food_taste_idx` INT NOT NULL AUTO_INCREMENT,
  `food_idx` INT NOT NULL,
  `taste_idx` INT NOT NULL,
  PRIMARY KEY (`food_taste_idx`),
  INDEX `fk_foods_tastes_foods_idx` (`food_idx` ASC) VISIBLE,
  INDEX `fk_foods_tastes_tastes1_idx` (`taste_idx` ASC) VISIBLE,
  CONSTRAINT `fk_foods_tastes_foods`
    FOREIGN KEY (`food_idx`)
    REFERENCES `gollajodb`.`foods` (`food_idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_foods_tastes_tastes1`
    FOREIGN KEY (`taste_idx`)
    REFERENCES `gollajodb`.`tastes` (`taste_idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gollajodb`.`cases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gollajodb`.`cases` (
  `case_idx` INT NOT NULL AUTO_INCREMENT,
  `case` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`case_idx`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gollajodb`.`foods_cases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gollajodb`.`foods_cases` (
  `food_case_idx` INT NOT NULL AUTO_INCREMENT,
  `food_idx` INT NOT NULL,
  `case_idx` INT NOT NULL,
  PRIMARY KEY (`food_case_idx`),
  INDEX `fk_foods_cases_foods1_idx` (`food_idx` ASC) VISIBLE,
  INDEX `fk_foods_cases_cases1_idx` (`case_idx` ASC) VISIBLE,
  CONSTRAINT `fk_foods_cases_foods1`
    FOREIGN KEY (`food_idx`)
    REFERENCES `gollajodb`.`foods` (`food_idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_foods_cases_cases1`
    FOREIGN KEY (`case_idx`)
    REFERENCES `gollajodb`.`cases` (`case_idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gollajodb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gollajodb`.`users` (
  `user_idx` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(20) NOT NULL,
  `pwd` VARCHAR(20) NOT NULL,
  `nickname` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`user_idx`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gollajodb`.`boards`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gollajodb`.`boards` (
  `board_idx` INT NOT NULL AUTO_INCREMENT,
  `user_idx` INT NOT NULL,
  `title` VARCHAR(200) NOT NULL,
  `question` VARCHAR(2000) NOT NULL,
  `answer1` VARCHAR(200) NOT NULL,
  `answer2` VARCHAR(200) NOT NULL,
  `view_count` INT NOT NULL,
  `register_datetime` DATETIME NOT NULL,
  `modify_datetime` DATETIME NOT NULL,
  PRIMARY KEY (`board_idx`),
  INDEX `fk_boards_users1_idx` (`user_idx` ASC) VISIBLE,
  CONSTRAINT `fk_boards_users1`
    FOREIGN KEY (`user_idx`)
    REFERENCES `gollajodb`.`users` (`user_idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gollajodb`.`board_votes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gollajodb`.`board_votes` (
  `board_vote_idx` INT NOT NULL AUTO_INCREMENT,
  `user_idx` INT NOT NULL,
  `board_idx` INT NOT NULL,
  `vote` TINYINT(1) NOT NULL DEFAULT 0 COMMENT 'true - 1 false - 0',
  PRIMARY KEY (`board_vote_idx`),
  INDEX `fk_board_votes_users1_idx` (`user_idx` ASC) VISIBLE,
  INDEX `fk_board_votes_boards1_idx` (`board_idx` ASC) VISIBLE,
  CONSTRAINT `fk_board_votes_users1`
    FOREIGN KEY (`user_idx`)
    REFERENCES `gollajodb`.`users` (`user_idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_board_votes_boards1`
    FOREIGN KEY (`board_idx`)
    REFERENCES `gollajodb`.`boards` (`board_idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gollajodb`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gollajodb`.`comments` (
  `comment_idx` INT NOT NULL AUTO_INCREMENT,
  `user_idx` INT NOT NULL,
  `board_idx` INT NOT NULL,
  `comment` VARCHAR(2000) NOT NULL,
  `register_datetime` DATETIME NOT NULL,
  `modify_datetime` DATETIME NOT NULL,
  PRIMARY KEY (`comment_idx`),
  INDEX `fk_comments_users1_idx` (`user_idx` ASC) VISIBLE,
  INDEX `fk_comments_boards1_idx` (`board_idx` ASC) VISIBLE,
  CONSTRAINT `fk_comments_users1`
    FOREIGN KEY (`user_idx`)
    REFERENCES `gollajodb`.`users` (`user_idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_boards1`
    FOREIGN KEY (`board_idx`)
    REFERENCES `gollajodb`.`boards` (`board_idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gollajodb`.`comment_likes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gollajodb`.`comment_likes` (
  `comment_like_idx` INT NOT NULL AUTO_INCREMENT,
  `user_idx` INT NOT NULL,
  `comment_idx` INT NOT NULL,
  PRIMARY KEY (`comment_like_idx`),
  INDEX `fk_comment_likes_users1_idx` (`user_idx` ASC) VISIBLE,
  INDEX `fk_comment_likes_comments1_idx` (`comment_idx` ASC) VISIBLE,
  CONSTRAINT `fk_comment_likes_users1`
    FOREIGN KEY (`user_idx`)
    REFERENCES `gollajodb`.`users` (`user_idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_likes_comments1`
    FOREIGN KEY (`comment_idx`)
    REFERENCES `gollajodb`.`comments` (`comment_idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
