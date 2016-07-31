CREATE SCHEMA `test` DEFAULT CHARACTER SET utf8;

CREATE TABLE `test`.`users` (
`ID` INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`NAME` VARCHAR(25) NOT NULL,
`AGE` INT NOT NULL,
`IS_ADMIN` BIT(1) NOT NULL DEFAULT false,
`CREATED_DATE` TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Vasia Pupkin', '21');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Kolia', '23');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Petia', '56');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Alla Pugacheva', '56');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Serega', '56');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Svetlana Ivanovna', '56');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Vania', '56');
