/*
Navicat MySQL Data Transfer

Source Server         : dataSourceA
Source Server Version : 50537
Source Host           : 114.55.92.31:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-11-19 19:00:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `device_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `is_on` tinyint(1) NOT NULL,
  `is_normal` tinyint(1) NOT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '缝纫机', '1', '1');
INSERT INTO `device` VALUES ('2', '缝纫机', '1', '1');
INSERT INTO `device` VALUES ('3', '缝纫机', '0', '1');
INSERT INTO `device` VALUES ('4', '缝纫机', '0', '1');
INSERT INTO `device` VALUES ('5', '缝纫机', '1', '0');
INSERT INTO `device` VALUES ('6', '熨烫', '1', '0');
INSERT INTO `device` VALUES ('7', '熨烫', '1', '1');
INSERT INTO `device` VALUES ('8', '熨烫', '1', '1');
INSERT INTO `device` VALUES ('9', '熨烫', '1', '0');
INSERT INTO `device` VALUES ('10', '熨烫', '0', '0');
INSERT INTO `device` VALUES ('11', '熨烫', '1', '1');
INSERT INTO `device` VALUES ('12', '熨烫', '0', '1');
INSERT INTO `device` VALUES ('13', '熨烫', '0', '0');
