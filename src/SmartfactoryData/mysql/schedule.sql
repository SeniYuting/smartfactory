/*
Navicat MySQL Data Transfer

Source Server         : dataSourceB
Source Server Version : 50537
Source Host           : 114.215.197.124:3306
Source Database       : tjdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-12-01 11:27:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `s_id` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('1', '打板', '238');
INSERT INTO `schedule` VALUES ('2', '裁剪', '382');
INSERT INTO `schedule` VALUES ('3', '缝制', '474');
INSERT INTO `schedule` VALUES ('4', '整烫', '214');
INSERT INTO `schedule` VALUES ('5', '包装', '588');
