/*
Navicat MySQL Data Transfer

Source Server         : dataSourceB
Source Server Version : 50537
Source Host           : 114.215.197.124:3306
Source Database       : tjdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-11-19 11:42:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for custom_service_staff
-- ----------------------------
DROP TABLE IF EXISTS `custom_service_staff`;
CREATE TABLE `custom_service_staff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `state` enum('offline','online') NOT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom_service_staff
-- ----------------------------
INSERT INTO `custom_service_staff` VALUES ('1', '张三', 'online');
INSERT INTO `custom_service_staff` VALUES ('2', '周汉辰', 'offline');
INSERT INTO `custom_service_staff` VALUES ('3', '李四', 'offline');
INSERT INTO `custom_service_staff` VALUES ('4', '王五', 'offline');
INSERT INTO `custom_service_staff` VALUES ('5', '唐宛如', 'online');
INSERT INTO `custom_service_staff` VALUES ('6', '张三丰', 'online');
INSERT INTO `custom_service_staff` VALUES ('7', '杨过', 'online');
