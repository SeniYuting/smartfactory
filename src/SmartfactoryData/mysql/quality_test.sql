/*
Navicat MySQL Data Transfer

Source Server         : dataSourceA
Source Server Version : 50537
Source Host           : 114.55.92.31:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-01-02 20:24:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for quality_test
-- ----------------------------
DROP TABLE IF EXISTS `quality_test`;
CREATE TABLE `quality_test` (
  `qt_id` int(11) NOT NULL AUTO_INCREMENT,
  `is_one_time_qualified` enum('合格','不合格') NOT NULL,
  `is_repair_qualified` enum('合格','不合格') DEFAULT NULL,
  `not_qualify_reason` enum('充绒量不合格','纤维含量不合格','甲醛含量超标','色牢度不合格','芳香胺染料超标') DEFAULT NULL,
  PRIMARY KEY (`qt_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quality_test
-- ----------------------------
INSERT INTO `quality_test` VALUES ('1', '合格', null, null);
INSERT INTO `quality_test` VALUES ('2', '合格', null, null);
INSERT INTO `quality_test` VALUES ('3', '不合格', '合格', '充绒量不合格');
INSERT INTO `quality_test` VALUES ('4', '不合格', '合格', '纤维含量不合格');
INSERT INTO `quality_test` VALUES ('5', '不合格', '不合格', '甲醛含量超标');
INSERT INTO `quality_test` VALUES ('6', '不合格', '合格', '色牢度不合格');
INSERT INTO `quality_test` VALUES ('7', '不合格', '不合格', '芳香胺染料超标');
INSERT INTO `quality_test` VALUES ('8', '合格', null, null);
INSERT INTO `quality_test` VALUES ('9', '合格', null, null);
INSERT INTO `quality_test` VALUES ('10', '合格', null, null);
INSERT INTO `quality_test` VALUES ('11', '合格', null, null);
INSERT INTO `quality_test` VALUES ('12', '合格', null, null);
INSERT INTO `quality_test` VALUES ('13', '合格', null, null);
INSERT INTO `quality_test` VALUES ('14', '不合格', '合格', '充绒量不合格');
