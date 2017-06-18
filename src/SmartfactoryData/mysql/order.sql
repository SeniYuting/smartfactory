/*
Navicat MySQL Data Transfer

Source Server         : dataSourceA
Source Server Version : 50537
Source Host           : 114.55.92.31:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-11-19 11:42:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `price` float NOT NULL,
  `area` varchar(255) NOT NULL,
  `is_schedule` tinyint(1) NOT NULL,
  `is_in_time` tinyint(1) NOT NULL,
  `state` enum('exception','change','normal','urgent') NOT NULL,
  `brand` varchar(255) NOT NULL,
  `material` varchar(255) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '2016-11-17', '499', '北京', '0', '1', 'normal', '真维斯', '棉');
INSERT INTO `order` VALUES ('2', '2016-11-17', '233', '美国', '0', '1', 'change', '纽伯伦', '棉');
INSERT INTO `order` VALUES ('3', '2016-11-18', '399', '上海', '1', '0', 'exception', '纽伯伦', '麻');
INSERT INTO `order` VALUES ('4', '2016-11-18', '449', '上海', '0', '1', 'exception', 'only', '牛仔');
INSERT INTO `order` VALUES ('5', '2016-11-19', '599', '杭州', '1', '1', 'normal', 'nike', '涤纶');
INSERT INTO `order` VALUES ('6', '2016-11-19', '299', '上海', '1', '1', 'normal', '真维斯', '棉');
INSERT INTO `order` VALUES ('7', '2016-11-19', '299', '杭州', '0', '0', 'exception', '真维斯', '棉');
