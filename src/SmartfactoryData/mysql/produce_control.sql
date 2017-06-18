/*
Navicat MySQL Data Transfer

Source Server         : dataSourceA
Source Server Version : 50537
Source Host           : 114.55.92.31:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-01-02 20:21:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for produce_control
-- ----------------------------
DROP TABLE IF EXISTS `produce_control`;
CREATE TABLE `produce_control` (
  `pc_id` int(11) NOT NULL AUTO_INCREMENT,
  `workshop` enum('车间D','车间C','车间B','车间A') DEFAULT NULL,
  `date` date DEFAULT NULL,
  `total_num` int(11) DEFAULT NULL,
  `onduty` int(11) DEFAULT NULL,
  `daily_output` int(11) DEFAULT NULL,
  `rework_rate` double DEFAULT NULL,
  `average_hours` double DEFAULT NULL,
  PRIMARY KEY (`pc_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of produce_control
-- ----------------------------
INSERT INTO `produce_control` VALUES ('1', '车间A', '2016-12-14', '52', '45', '3485', '0.23', '3.23');
INSERT INTO `produce_control` VALUES ('2', '车间A', '2016-11-29', '52', '48', '3788', '0.265', '3.453');
INSERT INTO `produce_control` VALUES ('3', '车间B', '2016-12-14', '55', '47', '3988', '0.25', '4.56');
INSERT INTO `produce_control` VALUES ('4', '车间B', '2016-11-29', '55', '48', '4511', '0.45', '5.677');
INSERT INTO `produce_control` VALUES ('5', '车间C', '2016-12-14', '54', '47', '4612', '0.32', '5.12');
INSERT INTO `produce_control` VALUES ('6', '车间D', '2016-12-14', '55', '48', '4522', '0.22', '4.11');
