-- MySQL Script generated by MySQL Workbench
-- Mon May 13 14:51:39 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `Codigo` INT NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `Sexo` VARCHAR(1) NULL,
  `DataNasc` DATE NULL,
  `Profissao` VARCHAR(45) NULL,
  PRIMARY KEY (`Codigo`))
ENGINE = InnoDB;
select * from Cliente;

-- -----------------------------------------------------
-- Table `mydb`.`Itens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Itens` (
  `NumeroItem` INT NOT NULL,
  `Quantidade` INT NULL,
  `ValorItem` DECIMAL(10,2) NULL,
  `Produto_NumeroProduto` INT NOT NULL,
  `Pedido_NumeroPedido` INT NOT NULL,
  PRIMARY KEY (`NumeroItem`),
  INDEX `fk_Itens_Produto1_idx` (`Produto_NumeroProduto` ASC),
  INDEX `fk_Itens_Pedido1_idx` (`Pedido_NumeroPedido` ASC),
  CONSTRAINT `fk_Itens_Produto1`
    FOREIGN KEY (`Produto_NumeroProduto`)
    REFERENCES `mydb`.`Produto` (`NumeroProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Pedido1`
    FOREIGN KEY (`Pedido_NumeroPedido`)
    REFERENCES `mydb`.`Pedido` (`NumeroPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
select * from Itens;

-- -----------------------------------------------------
-- Table `mydb`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pedido` (
  `NumeroPedido` INT NOT NULL,
  `CodigoCliente` INT NULL,
  `DataPedido` DATE NULL,
  `TotalPedido` DECIMAL(10,2) NULL,
  `Cliente_Codigo` INT NOT NULL,
  PRIMARY KEY (`NumeroPedido`),
  INDEX `fk_Pedido_Cliente_idx` (`Cliente_Codigo` ASC),
  CONSTRAINT `fk_Pedido_Cliente`
    FOREIGN KEY (`Cliente_Codigo`)
    REFERENCES `mydb`.`Cliente` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
select * from Pedido;

-- -----------------------------------------------------
-- Table `mydb`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produto` (
  `NumeroProduto` INT NOT NULL,
  `Descricao` VARCHAR(45) NULL,
  `Valor` DECIMAL(10,2) NULL,
  `Validade` VARCHAR(45) NULL,
  `Quantidade` INT NULL,
  PRIMARY KEY (`NumeroProduto`))
ENGINE = InnoDB;
select * from Produto;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
