/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50721
Source Host           : 39.108.134.71:3306
Source Database       : kzbAndAj

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-02-09 22:57:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `T_NEWS`
-- ----------------------------
DROP TABLE IF EXISTS `T_NEWS`;
CREATE TABLE `T_NEWS` (
  `id` bigint(20) NOT NULL COMMENT '新闻id',
  `title` varchar(200) DEFAULT NULL COMMENT '新闻题目',
  `type` enum('T_NEWS_SCHOOL','T_NEWS_HOUSE') DEFAULT NULL COMMENT '新闻类型',
  `content` mediumtext COMMENT '新闻内容',
  `source` enum('T_NEWS_SELF','T_NEWS_CRAWLER') DEFAULT NULL COMMENT '新闻来源',
  `isPassed` tinyint(1) DEFAULT NULL COMMENT '是否通过',
  `isDeleted` tinyint(1) DEFAULT NULL COMMENT '是否被删除',
  `updateAt` bigint(20) DEFAULT NULL COMMENT '更新日期',
  `addAt` bigint(20) DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_NEWS
-- ----------------------------
