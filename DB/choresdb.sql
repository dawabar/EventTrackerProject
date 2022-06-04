-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema choresdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `choresdb` ;

-- -----------------------------------------------------
-- Schema choresdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `choresdb` DEFAULT CHARACTER SET utf8 ;
USE `choresdb` ;

-- -----------------------------------------------------
-- Table `chore`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chore` ;

CREATE TABLE IF NOT EXISTS `chore` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `price` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entry`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `entry` ;

CREATE TABLE IF NOT EXISTS `entry` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `payment` DECIMAL(5,2) NOT NULL,
  `chore_id` INT NOT NULL,
  `person` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ledger_chore_idx` (`chore_id` ASC),
  CONSTRAINT `fk_ledger_chore`
    FOREIGN KEY (`chore_id`)
    REFERENCES `chore` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS choresuser;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'choresuser' IDENTIFIED BY 'choresuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'choresuser';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `chore`
-- -----------------------------------------------------
START TRANSACTION;
USE `choresdb`;
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (1, 'Take out the trash', 1.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (2, 'Clean your room', 3.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (3, '2-Hrs of homework', 5.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (4, 'Take hamper to laundry', 1.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (5, 'Wash a load of laundry', 1.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (6, 'Dry a load of laundry', 1.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (7, 'Load the dishwasher', 2.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (8, 'Empty dishwaster and put dishes away', 2.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (9, '1-Hr organizing books for Grandma', 5.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (10, 'Feed animals', 1.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (11, 'Sweep and mop floors (per hour)', 5.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (12, 'Carpet cleaner on couch (per hour)', 5.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (13, 'Scrub baseboards (per hour)', 7.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (14, 'Clean a toilet (thoroughly)', 3.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (15, 'Clean a toilet (quickly with scrubber)', 1.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (16, 'Pick up and organize a room (LR or DR, e.g.)', 3.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (17, 'Do 30 mins of exercise per day', 5.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (18, 'Fold and hang a basket of laundry', 5.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (19, 'Cook a meal for the family', 10.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (20, 'Plan and lead a family event', 10.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (21, 'Help with major projects (per hour)', 5.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (22, 'Read a real-life book for 1-hr', 3.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (23, 'Clean kitchen counters to Grandma standard', 4.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (24, 'Clean a shower or bathtup to Grandma standard', 10.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (25, 'Give an animal a bath', 15.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (26, 'Find a recipe that everyone will enjoy', 1.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (27, 'Clean up an animal mess', 3.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (28, 'Take out cat litter', 3.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (29, 'Clean a car (per hour)', 5.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (30, 'Take the trash can to the curb on Sunday or bring it back Monday', 1.00);
INSERT INTO `chore` (`id`, `name`, `price`) VALUES (31, 'Get the mail', 0.60);

COMMIT;


-- -----------------------------------------------------
-- Data for table `entry`
-- -----------------------------------------------------
START TRANSACTION;
USE `choresdb`;
INSERT INTO `entry` (`id`, `payment`, `chore_id`, `person`) VALUES (1, 3.00, 28, 'Joe');

COMMIT;

