-- MySQL Script generated by MySQL Workbench
-- Fri Dec  8 22:59:00 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema currencyExchange
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema currencyExchange
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `currencyExchange` DEFAULT CHARACTER SET utf8 ;
USE `currencyExchange` ;

-- -----------------------------------------------------
-- Table `currencyExchange`.`currency`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `currencyExchange`.`currency` ;

CREATE TABLE IF NOT EXISTS `currencyExchange`.`currency` (
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `currencyExchange`.`conversionRate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `currencyExchange`.`conversionRate` ;

CREATE TABLE IF NOT EXISTS `currencyExchange`.`conversionRate` (
  `from` VARCHAR(20) NOT NULL,
  `to` VARCHAR(20) NOT NULL,
  `rate` FLOAT NULL,
  PRIMARY KEY (`from`, `to`),
  CONSTRAINT `fk_currency_has_currency_currency`
    FOREIGN KEY (`from`)
    REFERENCES `currencyExchange`.`currency` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_currency_has_currency_currency1`
    FOREIGN KEY (`to`)
    REFERENCES `currencyExchange`.`currency` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_currency_has_currency_currency1_idx` ON `currencyExchange`.`conversionRate` (`to` ASC);

CREATE INDEX `fk_currency_has_currency_currency_idx` ON `currencyExchange`.`conversionRate` (`from` ASC);

SET SQL_MODE = '';
GRANT USAGE ON *.* TO id1212@localhost;
 DROP USER id1212@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'id1212'@'localhost' IDENTIFIED BY 'id1212';

GRANT ALL ON `currencyExchange`.* TO 'id1212'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `currencyExchange`.`currency`
-- -----------------------------------------------------
START TRANSACTION;
USE `currencyExchange`;
INSERT INTO `currencyExchange`.`currency` (`name`) VALUES ('euro');
INSERT INTO `currencyExchange`.`currency` (`name`) VALUES ('sek');
INSERT INTO `currencyExchange`.`currency` (`name`) VALUES ('dollar');
INSERT INTO `currencyExchange`.`currency` (`name`) VALUES ('pound');

COMMIT;


-- -----------------------------------------------------
-- Data for table `currencyExchange`.`conversionRate`
-- -----------------------------------------------------
START TRANSACTION;
USE `currencyExchange`;
INSERT INTO `currencyExchange`.`conversionRate` (`from`, `to`, `rate`) VALUES ('euro', 'sek', 9.4);
INSERT INTO `currencyExchange`.`conversionRate` (`from`, `to`, `rate`) VALUES ('sek', 'euro', 9.6);
INSERT INTO `currencyExchange`.`conversionRate` (`from`, `to`, `rate`) VALUES ('euro', 'pound', 0.88);
INSERT INTO `currencyExchange`.`conversionRate` (`from`, `to`, `rate`) VALUES ('pound', 'euro', 1.14);
INSERT INTO `currencyExchange`.`conversionRate` (`from`, `to`, `rate`) VALUES ('euro', 'dollar', 1.18);
INSERT INTO `currencyExchange`.`conversionRate` (`from`, `to`, `rate`) VALUES ('dollar', 'euro', 0.85);
INSERT INTO `currencyExchange`.`conversionRate` (`from`, `to`, `rate`) VALUES ('sek', 'pound', 0.09);
INSERT INTO `currencyExchange`.`conversionRate` (`from`, `to`, `rate`) VALUES ('pound', 'sek', 11.32);
INSERT INTO `currencyExchange`.`conversionRate` (`from`, `to`, `rate`) VALUES ('sek', 'dollar', 0.12);
INSERT INTO `currencyExchange`.`conversionRate` (`from`, `to`, `rate`) VALUES ('dollar', 'sek', 8.45);
INSERT INTO `currencyExchange`.`conversionRate` (`from`, `to`, `rate`) VALUES ('pound', 'dollar', 1.34);
INSERT INTO `currencyExchange`.`conversionRate` (`from`, `to`, `rate`) VALUES ('dollar', 'pound', 0.75);

COMMIT;

