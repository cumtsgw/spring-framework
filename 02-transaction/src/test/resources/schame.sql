CREATE TABLE `books` (
	`id`  int NOT NULL AUTO_INCREMENT ,
	`isbn`  varchar(255) NULL ,
	`name`  varchar(255) NULL ,
	`price`  decimal(10,2) NULL ,
	`pubdate`  datetime NULL ,
	PRIMARY KEY (`id`)
);

select  * from books;