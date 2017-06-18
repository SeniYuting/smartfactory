/*
Navicat MySQL Data Transfer

Source Server         : dataSourceB
Source Server Version : 50537
Source Host           : 114.215.197.124:3306
Source Database       : tjdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-01-02 21:06:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` enum('中间件','数据库','主机') DEFAULT NULL,
  `production_line` enum('产线G','产线F','产线E','产线D','产线C','产线B','产线A') DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '主机', '产线A', '80');
INSERT INTO `resource` VALUES ('2', '主机', '产线B', '120');
INSERT INTO `resource` VALUES ('3', '主机', '产线C', '230');
INSERT INTO `resource` VALUES ('4', '主机', '产线D', '235');
INSERT INTO `resource` VALUES ('5', '主机', '产线E', '345');
INSERT INTO `resource` VALUES ('6', '主机', '产线F', '150');
INSERT INTO `resource` VALUES ('7', '主机', '产线G', '240');
INSERT INTO `resource` VALUES ('8', '数据库', '产线A', '90');
INSERT INTO `resource` VALUES ('9', '数据库', '产线B', '100');
INSERT INTO `resource` VALUES ('10', '数据库', '产线C', '220');
INSERT INTO `resource` VALUES ('11', '数据库', '产线D', '240');
INSERT INTO `resource` VALUES ('12', '数据库', '产线E', '315');
INSERT INTO `resource` VALUES ('13', '数据库', '产线F', '140');
INSERT INTO `resource` VALUES ('14', '数据库', '产线G', '210');
INSERT INTO `resource` VALUES ('15', '中间件', '产线A', '85');
INSERT INTO `resource` VALUES ('16', '中间件', '产线B', '120');
INSERT INTO `resource` VALUES ('17', '中间件', '产线C', '160');
INSERT INTO `resource` VALUES ('18', '中间件', '产线D', '220');
INSERT INTO `resource` VALUES ('19', '中间件', '产线E', '310');
INSERT INTO `resource` VALUES ('20', '中间件', '产线F', '210');
INSERT INTO `resource` VALUES ('21', '中间件', '产线G', '80');
