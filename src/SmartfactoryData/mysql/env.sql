/*
Navicat MySQL Data Transfer

Source Server         : dataSourceA
Source Server Version : 50537
Source Host           : 114.55.92.31:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-12-01 11:25:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for env
-- ----------------------------
DROP TABLE IF EXISTS `env`;
CREATE TABLE `env` (
  `env_id` int(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of env
-- ----------------------------
INSERT INTO `env` VALUES ('1', '../img/img1.jpg');
INSERT INTO `env` VALUES ('2', '../img/img2.jpg');
INSERT INTO `env` VALUES ('3', '../img/img3.jpg');
INSERT INTO `env` VALUES ('4', '../img/img4.jpg');
