/*
Navicat MySQL Data Transfer

Source Server         : dataSourceB
Source Server Version : 50537
Source Host           : 114.215.197.124:3306
Source Database       : tjdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-11-19 19:00:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product_line
-- ----------------------------
DROP TABLE IF EXISTS `product_line`;
CREATE TABLE `product_line` (
  `line_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `using` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `overstock` float NOT NULL,
  `peroid` float NOT NULL,
  `cut_parts` float NOT NULL,
  `pair_event` float NOT NULL,
  PRIMARY KEY (`line_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_line
-- ----------------------------
INSERT INTO `product_line` VALUES ('1', '产线A', '56', '60', '0.5', '1.1', '0.3', '2');
INSERT INTO `product_line` VALUES ('2', '产线B', '48', '60', '0.2', '0.1', '0.6', '1');
INSERT INTO `product_line` VALUES ('3', '产线C', '45', '50', '0.5', '1.2', '0.2', '1');
