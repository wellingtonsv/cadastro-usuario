mysqladmin --user=root --password=root password 123

CREATE database registro;
USE registro;
CREATE TABLE `registro`.`USER_TABLE` ( `id` DOUBLE NOT NULL AUTO_INCREMENT, `firstName` VARCHAR(45) NOT NULL DEFAULT '', 
`middleName` VARCHAR(45) NOT NULL DEFAULT '', `lastName` VARCHAR(45) NOT NULL DEFAULT '',`profile` VARCHAR(7) NOT NULL DEFAULT 'padrao',
`email` VARCHAR(45) NOT NULL DEFAULT '', `userId` VARCHAR(45) NOT NULL DEFAULT '', `password` VARCHAR(45) NOT NULL DEFAULT '', 
PRIMARY KEY(`id`) ) ENGINE = InnoDB;
DESC USER_TABLE;

