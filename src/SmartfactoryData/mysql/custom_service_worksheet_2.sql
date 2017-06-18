/*
Navicat MySQL Data Transfer

Source Server         : dataSourceB
Source Server Version : 50537
Source Host           : 114.215.197.124:3306
Source Database       : tjdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-11-19 11:42:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for custom_service_worksheet_2
-- ----------------------------
DROP TABLE IF EXISTS `custom_service_worksheet_2`;
CREATE TABLE `custom_service_worksheet_2` (
  `worksheet_id` int(11) NOT NULL AUTO_INCREMENT,
  `state` enum('处理中','未处理','紧急','完成') NOT NULL,
  `content` enum('商品介绍','物流查询','询价','投诉','退货') NOT NULL,
  PRIMARY KEY (`worksheet_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_service_worksheet_2
-- ----------------------------
INSERT INTO `custom_service_worksheet_2` VALUES ('1', '未处理', '物流查询');
INSERT INTO `custom_service_worksheet_2` VALUES ('2', '紧急', '投诉');
INSERT INTO `custom_service_worksheet_2` VALUES ('3', '处理中', '商品介绍');
INSERT INTO `custom_service_worksheet_2` VALUES ('4', '完成', '询价');
INSERT INTO `custom_service_worksheet_2` VALUES ('5', '紧急', '投诉');
INSERT INTO `custom_service_worksheet_2` VALUES ('6', '处理中', '商品介绍');
INSERT INTO `custom_service_worksheet_2` VALUES ('7', '处理中', '退货');
INSERT INTO `custom_service_worksheet_2` VALUES ('8', '未处理', '询价');
