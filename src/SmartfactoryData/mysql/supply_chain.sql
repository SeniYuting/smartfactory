/*
Navicat MySQL Data Transfer

Source Server         : dataSourceB
Source Server Version : 50537
Source Host           : 114.215.197.124:3306
Source Database       : tjdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-01-02 21:21:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for supply_chain
-- ----------------------------
DROP TABLE IF EXISTS `supply_chain`;
CREATE TABLE `supply_chain` (
  `sc_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `type` enum('配件','辅料','面料') DEFAULT NULL,
  `is_complete` tinyint(4) DEFAULT NULL,
  `is_intime` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`sc_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supply_chain
-- ----------------------------
INSERT INTO `supply_chain` VALUES ('1', '2016-12-14', '面料', '1', '0');
INSERT INTO `supply_chain` VALUES ('2', '2016-12-14', '辅料', '1', '0');
INSERT INTO `supply_chain` VALUES ('3', '2016-12-14', '配件', '0', '1');
INSERT INTO `supply_chain` VALUES ('4', '2016-11-29', '配件', '1', '1');
INSERT INTO `supply_chain` VALUES ('5', '2016-12-14', '辅料', '0', '1');
INSERT INTO `supply_chain` VALUES ('6', '2016-12-14', '配件', '1', '1');
