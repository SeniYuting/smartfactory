/*
Navicat MySQL Data Transfer

Source Server         : dataSourceB
Source Server Version : 50537
Source Host           : 114.215.197.124:3306
Source Database       : tjdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-11-19 19:01:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for congestion
-- ----------------------------
DROP TABLE IF EXISTS `congestion`;
CREATE TABLE `congestion` (
  `congestion_id` int(11) NOT NULL AUTO_INCREMENT,
  `node` enum('AVG小车','智能吊挂','自动裁床') NOT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `measure` varchar(255) DEFAULT NULL,
  `responsible_person` varchar(255) NOT NULL,
  `recovery_time` datetime NOT NULL,
  `flow` int(11) NOT NULL,
  PRIMARY KEY (`congestion_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of congestion
-- ----------------------------
INSERT INTO `congestion` VALUES ('1', '智能吊挂', '待检查', '待定', '周汉辰', '2016-12-19 16:08:56', '100');
INSERT INTO `congestion` VALUES ('2', '自动裁床', '待检查', '待定', '周汉辰', '2016-12-23 16:09:56', '40');
