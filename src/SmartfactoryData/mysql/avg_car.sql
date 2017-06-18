/*
Navicat MySQL Data Transfer

Source Server         : dataSourceA
Source Server Version : 50537
Source Host           : 114.55.92.31:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-11-19 19:00:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for avg_car
-- ----------------------------
DROP TABLE IF EXISTS `avg_car`;
CREATE TABLE `avg_car` (
  `avgcar_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `station` varchar(255) NOT NULL,
  `stay` int(11) NOT NULL,
  `shipping_material` varchar(255) NOT NULL,
  PRIMARY KEY (`avgcar_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of avg_car
-- ----------------------------
INSERT INTO `avg_car` VALUES ('1', '小车A', '092', '56', '66779');
INSERT INTO `avg_car` VALUES ('2', '小车B', '022', '34', '87889');
INSERT INTO `avg_car` VALUES ('3', '小车C', '023', '76', '19282');
INSERT INTO `avg_car` VALUES ('4', '小车D', '011', '112', '12812');
INSERT INTO `avg_car` VALUES ('5', '小车E', '128', '89', '87780');
INSERT INTO `avg_car` VALUES ('6', '小车F', '087', '54', '00980');
