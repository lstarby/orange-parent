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

 Date: 25/10/2017 09:19:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  PRIMARY KEY (`receive_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收货地址';

-- ----------------------------
-- Table structure for safety_question
-- ----------------------------
DROP TABLE IF EXISTS `safety_question`;
CREATE TABLE `safety_question` (
  `question_id` int(2) NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `question` varchar(100) NOT NULL COMMENT '问题答案',
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='安全问题表';

-- ----------------------------
-- Table structure for safety_question_answer
-- ----------------------------
DROP TABLE IF EXISTS `safety_question_answer`;
CREATE TABLE `safety_question_answer` (
  `question_answer_id` varchar(40) NOT NULL COMMENT '主键',
  `user_id` varchar(40) NOT NULL COMMENT '用户表主键',
  `question` varchar(40) NOT NULL COMMENT '问题',
  `answer` varchar(100) NOT NULL COMMENT '问题答案',
  PRIMARY KEY (`question_answer_id`)
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
  `birthday` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '生日',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(60) NOT NULL COMMENT '密码',
  `account_state` int(1) NOT NULL DEFAULT '0' COMMENT '账号状态, 0:正常 1:停用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `state_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '状态时间',
  `membership_grade` int(1) unsigned NOT NULL DEFAULT '1' COMMENT '会员等级',
  `id_card_number` varchar(40) DEFAULT NULL COMMENT '身份证号码',
  `payment_password` varchar(40) DEFAULT NULL COMMENT '支付密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('a19c3eb2-b7cb-11e7-932a-3e81cd7e10d5', NULL, NULL, NULL, NULL, '111', '111@qq.com', '698d51a19d8a121ce581499d7b701668', 0, '2017-10-23 16:24:47', '2017-10-23 16:24:47', 1, NULL, NULL);
INSERT INTO `user` VALUES ('aa3a1980-b8d5-11e7-932a-3e81cd7e10d5', NULL, NULL, NULL, NULL, '123', NULL, '698D51A19D8A121CE581499D7B701668', 0, '2017-10-25 00:09:08', '2017-10-25 00:09:08', 1, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
