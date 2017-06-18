/*
Navicat MySQL Data Transfer

Source Server         : dataSourceB
Source Server Version : 50537
Source Host           : 114.215.197.124:3306
Source Database       : tjdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-01-02 21:15:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for schedule_info
-- ----------------------------
DROP TABLE IF EXISTS `schedule_info`;
CREATE TABLE `schedule_info` (
  `si_id` int(11) NOT NULL AUTO_INCREMENT,
  `is_success` tinyint(4) DEFAULT NULL,
  `is_conflict` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`si_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule_info
-- ----------------------------
INSERT INTO `schedule_info` VALUES ('1', '1', null);
INSERT INTO `schedule_info` VALUES ('2', '1', null);
INSERT INTO `schedule_info` VALUES ('3', '0', '0');
INSERT INTO `schedule_info` VALUES ('4', '0', '1');
INSERT INTO `schedule_info` VALUES ('5', '0', '0');
INSERT INTO `schedule_info` VALUES ('6', '1', null);
INSERT INTO `schedule_info` VALUES ('7', '1', null);
