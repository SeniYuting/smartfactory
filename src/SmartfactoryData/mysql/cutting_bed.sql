/*
Navicat MySQL Data Transfer

Source Server         : dataSourceB
Source Server Version : 50537
Source Host           : 114.215.197.124:3306
Source Database       : tjdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-11-19 19:00:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cutting_bed
-- ----------------------------
DROP TABLE IF EXISTS `cutting_bed`;
CREATE TABLE `cutting_bed` (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `using` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `working_time` int(11) NOT NULL,
  `moving_time` int(11) NOT NULL,
  `cutting_num` int(11) NOT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cutting_bed
-- ----------------------------
INSERT INTO `cutting_bed` VALUES ('1', '品牌A', '2', '2', '345645', '23346', '1345');
INSERT INTO `cutting_bed` VALUES ('2', '品牌B', '6', '8', '431245', '23346', '2354');
INSERT INTO `cutting_bed` VALUES ('3', '品牌C', '6', '8', '431245', '23346', '2354');
