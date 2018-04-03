CREATE DATABASE `agenda`;
USE agenda;
CREATE TABLE `agenda`.`personas` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `calle` VARCHAR(45) NULL,
  `altura` VARCHAR(45) NULL,
  `piso` VARCHAR(45) NULL,
  `depto` VARCHAR(45) NULL,
  `localidad` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `fnac` DATE NULL,
  `tcont` VARCHAR(45) NULL,
  PRIMARY KEY (`idPersona`));
CREATE TABLE `agenda`.`localidades` (
  `idLocalidad` INT NOT NULL AUTO_INCREMENT,
  `localidad` VARCHAR(45) NULL,
  PRIMARY KEY (`idLocalidad`));
  CREATE TABLE `agenda`.`tipocontacto` (
  `idTipoContacto` INT NOT NULL AUTO_INCREMENT,
  `TipoContacto` VARCHAR(45) NULL,
  PRIMARY KEY (`idTipoContacto`));