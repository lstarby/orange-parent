/*
 Navicat Premium Data Transfer

 Source Server         : zzsong
 Source Server Type    : MySQL
 Source Server Version : 50715
 Source Host           : localhost:3306
 Source Schema         : orange

 Target Server Type    : MySQL
 Target Server Version : 50715
 File Encoding         : 65001

 Date: 05/11/2017 23:41:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `code` int(8) NOT NULL COMMENT '区编码',
  `name` varchar(40) NOT NULL COMMENT '区名称',
  `parent_code` int(8) NOT NULL COMMENT '所属市编码',
  PRIMARY KEY (`code`),
  KEY `area_parentcode` (`parent_code`),
  CONSTRAINT `area_parentcode` FOREIGN KEY (`parent_code`) REFERENCES `city` (`parent_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区';

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `code` int(8) NOT NULL COMMENT '市编码',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `parent_code` int(8) NOT NULL COMMENT '所属省份编码',
  PRIMARY KEY (`code`),
  KEY `city_parentcode` (`parent_code`),
  CONSTRAINT `city_parentcode` FOREIGN KEY (`parent_code`) REFERENCES `province` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='市';

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `code` int(8) NOT NULL COMMENT '省份编码',
  `name` varchar(40) NOT NULL COMMENT '省份名称',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省';

-- ----------------------------
-- Table structure for receiving_address
-- ----------------------------
DROP TABLE IF EXISTS `receiving_address`;
CREATE TABLE `receiving_address` (
  `receive_address_id` varchar(40) NOT NULL COMMENT '收货地址id',
  `user_id` varchar(40) DEFAULT NULL COMMENT '用户表主键',
  `receive_name` varchar(20) NOT NULL COMMENT '收货人姓名',
  `phone` varchar(20) NOT NULL COMMENT '手机号码',
  `province` varchar(20) DEFAULT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `region` varchar(20) DEFAULT NULL COMMENT '区',
  `detailed_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `postcode` varchar(20) DEFAULT NULL COMMENT '邮编',
  `is_default` int(1) NOT NULL DEFAULT '0' COMMENT '是否默认收货地址, 0:否 1:是',
  PRIMARY KEY (`receive_address_id`),
  KEY `receiving_address_userid` (`user_id`),
  CONSTRAINT `receiving_address_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收货地址';

-- ----------------------------
-- Table structure for safety_question
-- ----------------------------
DROP TABLE IF EXISTS `safety_question`;
CREATE TABLE `safety_question` (
  `question_id` int(2) NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `question` varchar(100) NOT NULL COMMENT '问题',
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='安全问题表';

-- ----------------------------
-- Table structure for safety_question_answer
-- ----------------------------
DROP TABLE IF EXISTS `safety_question_answer`;
CREATE TABLE `safety_question_answer` (
  `question_answer_id` varchar(40) NOT NULL COMMENT '主键',
  `user_id` varchar(40) NOT NULL COMMENT '用户表主键',
  `question_id` int(2) NOT NULL COMMENT '问题id',
  `answer` varchar(100) NOT NULL COMMENT '问题答案',
  PRIMARY KEY (`question_answer_id`),
  KEY `safety_question_answer_userid` (`user_id`),
  KEY `safety_question_answer_question_id` (`question_id`),
  CONSTRAINT `safety_question_answer_question_id` FOREIGN KEY (`question_id`) REFERENCES `safety_question` (`question_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `safety_question_answer_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='安全问题答案表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(40) NOT NULL COMMENT '主键',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `gender` int(1) DEFAULT '3' COMMENT '性别 0:女 1:男 2:其他 3:保密',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(60) NOT NULL COMMENT '密码',
  `account_state` int(1) NOT NULL DEFAULT '0' COMMENT '账号状态, 0:正常 1:停用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `state_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '状态时间',
  `membership_grade` int(1) unsigned NOT NULL DEFAULT '1' COMMENT '会员等级',
  `id_card_number` varchar(40) DEFAULT NULL COMMENT '身份证号码',
  `payment_password` varchar(40) DEFAULT NULL COMMENT '支付密码',
  `is_real_authentication` int(1) NOT NULL DEFAULT '0' COMMENT '是否实名 0:否 1:是',
  `head_portrait` varchar(255) DEFAULT NULL COMMENT '用户头像地址',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

SET FOREIGN_KEY_CHECKS = 1;
