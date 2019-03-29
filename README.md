# SpringProject
Baza danych i tabele

SET FOREIGN_KEY_CHECKS=0;
# Exporting metadata from `mojabaza`
DROP DATABASE IF EXISTS `mojabaza`;
CREATE DATABASE `mojabaza`;
USE `mojabaza`;
# TABLE: `mojabaza`.`role`
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
# TABLE: `mojabaza`.`user`
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
# TABLE: `mojabaza`.`user_role`
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
#...done.
SET FOREIGN_KEY_CHECKS=1;



INSERT INTO `role` VALUES (1,'ROLE_ADMIN');
INSERT INTO `role` VALUES (2,'ROLE_USER');



DROP TABLE IF EXISTS pCategory ;
CREATE TABLE pCategory (
  category_id int(11) NOT NULL AUTO_INCREMENT,
  category_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (category_id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS product;
CREATE TABLE `product` (
  `product_id` bigINT NOT NULL AUTO_INCREMENT,
  `product_name` varchar(500) NOT NULL,
  `product_opis` varchar(8000) NOT NULL,
  `product_price` float(53) NOT NULL,
  `product_amount` INT NOT NULL,
  `user_id` int(11) NOT NULL,
  `sprzedane` int(11) DEFAULT 0,
  PRIMARY KEY (`product_id`)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS product_category;
CREATE TABLE product_category (
  product_id bigINT NOT NULL,
  category_id int(11) NOT NULL,
  PRIMARY KEY (product_id,category_id),
  KEY FKcategoryId (category_id),
  CONSTRAINT FKproductId FOREIGN KEY (product_id) REFERENCES product(product_id),
  CONSTRAINT FKcategoryId FOREIGN KEY (category_id) REFERENCES pCategory(category_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



#kategorie

INSERT INTO `pCategory` VALUES (1,'Elektronika');
INSERT INTO `pCategory` VALUES (2,'Dom i ogród');
INSERT INTO `pCategory` VALUES (3,'Hobby');
INSERT INTO `pCategory` VALUES (4,'Sport i turystyka');
INSERT INTO `pCategory` VALUES (5,'Nauka');
INSERT INTO `pCategory` VALUES (6,'Kultura i rozrywka');
INSERT INTO `pCategory` VALUES (7,'MOTORYZACJA');
INSERT INTO `pCategory` VALUES (8,'Zdrowie i uroda');
INSERT INTO `pCategory` VALUES (10,'Moda');


Baza danych MySQL.


