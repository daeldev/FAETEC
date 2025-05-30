-- MySQL Script generated by MySQL Workbench
-- Thu Sep 26 14:28:44 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ProvaTarde
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ProvaTarde
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ProvaTarde` ;
USE `ProvaTarde` ;

-- -----------------------------------------------------
-- Table `ProvaTarde`.`Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProvaTarde`.`Disciplina` (
  `idDisciplina` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `carga_horaria` INT NOT NULL,
  `ensino` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDisciplina`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
