/*
 Navicat Premium Data Transfer

 Source Server         : MYSELF
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : myself:3306
 Source Schema         : jooq

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 20/11/2018 14:06:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id`                INT(11)                         NOT NULL                AUTO_INCREMENT,
  `first_name`        VARCHAR(50) COLLATE utf8mb4_bin                         DEFAULT NULL,
  `last_name`         VARCHAR(50) COLLATE utf8mb4_bin NOT NULL,
  `date_of_birth_day` DATE                            NOT NULL,
  `address`           VARCHAR(50) COLLATE utf8mb4_bin                         DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id`             INT(11)                          NOT NULL AUTO_INCREMENT,
  `author_id`      INT(11)                          NOT NULL,
  `title`          VARCHAR(255) COLLATE utf8mb4_bin NOT NULL,
  `content_text`   TEXT COLLATE utf8mb4_bin,
  `is_sale`        TINYINT(1)                                DEFAULT NULL,
  `publication_at` TIMESTAMP                        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_t_book_author_id` (`author_id`),
  CONSTRAINT `fk_t_book_author_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- view
-- ----------------------------
CREATE VIEW `book_detail` AS
  SELECT
    a.id,
    a.first_name,
    a.last_name,
    a.date_of_birth_day,
    a.address,
    b.author_id,
    b.title,
    b.content_text,
    b.is_sale,
    b.publication_at
  FROM `author` a LEFT JOIN `book` b ON b.author_id = a.id;