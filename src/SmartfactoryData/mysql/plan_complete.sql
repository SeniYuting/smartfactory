/*
Navicat MySQL Data Transfer

Source Server         : dataSourceB
Source Server Version : 50537
Source Host           : 114.215.197.124:3306
Source Database       : tjdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-01-02 21:02:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for plan_complete
-- ----------------------------
DROP TABLE IF EXISTS `plan_complete`;
CREATE TABLE `plan_complete` (
  `pc_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` enum('批发出库','外协发货','采购计划') DEFAULT NULL,
  `is_complete` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`pc_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan_complete
-- ----------------------------
INSERT INTO `plan_complete` VALUES ('1', '采购计划', '0');
INSERT INTO `plan_complete` VALUES ('2', '外协发货', '1');
INSERT INTO `plan_complete` VALUES ('3', '采购计划', '1');
INSERT INTO `plan_complete` VALUES ('4', '批发出库', '1');
INSERT INTO `plan_complete` VALUES ('5', '外协发货', '0');
INSERT INTO `plan_complete` VALUES ('6', '外协发货', '1');
INSERT INTO `plan_complete` VALUES ('7', '采购计划', '1');
INSERT INTO `plan_complete` VALUES ('8', '采购计划', '1');
INSERT INTO `plan_complete` VALUES ('9', '批发出库', '1');
INSERT INTO `plan_complete` VALUES ('10', '外协发货', '1');
INSERT INTO `plan_complete` VALUES ('11', '外协发货', '0');
