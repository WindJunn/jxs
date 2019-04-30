/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : jxs

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-04-30 17:54:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_administrator
-- ----------------------------
DROP TABLE IF EXISTS `tb_administrator`;
CREATE TABLE `tb_administrator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_administrator
-- ----------------------------
INSERT INTO `tb_administrator` VALUES ('1', null, 'wuyu', '123', null, null, null, '2019-04-30 16:14:01', '2019-04-30 16:14:04');

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL,
  `article_contents` longtext COMMENT '文章内容',
  `article_type` varchar(255) DEFAULT NULL COMMENT '文章类型  政策，文化，教育，农技，其他',
  `state` varchar(255) DEFAULT NULL COMMENT '文章状态 审核通过，审核未通过，提交未审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_article
-- ----------------------------

-- ----------------------------
-- Table structure for tb_attendance
-- ----------------------------
DROP TABLE IF EXISTS `tb_attendance`;
CREATE TABLE `tb_attendance` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_id` bigint(30) DEFAULT NULL,
  `state` int(1) DEFAULT NULL COMMENT '0 出勤 1 请假 2 公差 3 迟到 4 早退 5 旷课',
  `attendance_time` datetime DEFAULT NULL COMMENT '考勤时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_attendance
-- ----------------------------
INSERT INTO `tb_attendance` VALUES ('1', '1', '0', '2019-04-23 17:42:45');
INSERT INTO `tb_attendance` VALUES ('2', '2', '0', '2019-04-23 17:43:03');
INSERT INTO `tb_attendance` VALUES ('3', '3', '1', '2019-04-23 17:43:13');
INSERT INTO `tb_attendance` VALUES ('4', '4', '0', '2019-04-23 17:43:19');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `content` longtext COMMENT '评论内容',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(255) DEFAULT NULL COMMENT '角色编号',
  `role_desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `is_default` varchar(20) DEFAULT NULL COMMENT '是否默认',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_date` varchar(64) DEFAULT NULL COMMENT '创建时间',
  `modifier` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modify_date` varchar(64) DEFAULT NULL COMMENT '修改时间',
  `del_flag` varchar(20) DEFAULT NULL COMMENT '删除标记',
  `application_code` varchar(64) DEFAULT NULL COMMENT '系统编号',
  `status` varchar(20) NOT NULL COMMENT '状态 0-启用，1-禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '普通用户', 'role_user', '普通用户', '1', 'admin', '2019-02-25 13:43:15', 'admin', '2019-02-25 13:43:15', '0', 'EXAM', '0');
INSERT INTO `tb_role` VALUES ('2', '村管理员', 'role_admin_village', '村管理员', '0', 'admin', '2019-02-25 13:41:27', 'admin', '2019-03-06 13:47:31', '0', 'EXAM', '0');
INSERT INTO `tb_role` VALUES ('3', '镇管理员', 'role_admin_town', '镇管理员', '0', 'admin', '2019-02-25 13:41:27', 'admin', '2019-03-06 13:47:31', '0', 'EXAM', '0');
INSERT INTO `tb_role` VALUES ('4', '县管理员', 'role_admin_county', '县管理员', '0', 'admin', '2019-02-25 13:41:27', 'admin', '2019-03-06 13:47:31', '0', 'EXAM', '0');
INSERT INTO `tb_role` VALUES ('5', '市管理员', 'role_admin_city', '市管理员', '0', 'admin', '2019-02-25 13:41:27', 'admin', '2019-03-06 13:47:31', '0', 'EXAM', '0');
INSERT INTO `tb_role` VALUES ('6', '超级管理员', 'role_admin', '超级管理员', '0', 'admin', '2019-02-25 13:41:27', 'admin', '2019-03-06 13:47:31', '0', 'EXAM', '0');
INSERT INTO `tb_role` VALUES ('7', '教师', 'role_teacher', '教师', '0', 'admin', '2019-02-25 13:42:29', 'admin', '2019-02-25 13:42:29', '0', 'EXAM', '0');

-- ----------------------------
-- Table structure for tb_schedule
-- ----------------------------
DROP TABLE IF EXISTS `tb_schedule`;
CREATE TABLE `tb_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `name` varchar(255) DEFAULT NULL COMMENT '教员姓名',
  `teaching_time` datetime DEFAULT NULL COMMENT '授课时间',
  `teaching_site` varchar(255) DEFAULT NULL COMMENT '授课地点',
  `teaching_theme` varchar(255) DEFAULT NULL COMMENT '授课主题',
  `teaching_state` varchar(255) DEFAULT NULL COMMENT '授课状态 1.已授课 2.未授课',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_schedule
-- ----------------------------
INSERT INTO `tb_schedule` VALUES ('1', '1', null, '2019-04-29 16:00:00', '大池村', '水稻防虫', '1');

-- ----------------------------
-- Table structure for tb_towns
-- ----------------------------
DROP TABLE IF EXISTS `tb_towns`;
CREATE TABLE `tb_towns` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_towns
-- ----------------------------
INSERT INTO `tb_towns` VALUES ('1', '官厅镇', '原州区');
INSERT INTO `tb_towns` VALUES ('2', '黄铎堡镇', '原州区');
INSERT INTO `tb_towns` VALUES ('3', '张易镇', '原州区');
INSERT INTO `tb_towns` VALUES ('4', '河川乡', '原州区');
INSERT INTO `tb_towns` VALUES ('5', '北塬街道', '原州区');
INSERT INTO `tb_towns` VALUES ('6', '古雁街道', '原州区');
INSERT INTO `tb_towns` VALUES ('7', '南关街道', '原州区');
INSERT INTO `tb_towns` VALUES ('8', '吉强镇', '西吉县');
INSERT INTO `tb_towns` VALUES ('9', '城关镇', '隆德县');
INSERT INTO `tb_towns` VALUES ('10', '香水镇', '泾源县');
INSERT INTO `tb_towns` VALUES ('11', '白阳镇', '彭阳县');
INSERT INTO `tb_towns` VALUES ('12', '火石寨乡', '西吉县');
INSERT INTO `tb_towns` VALUES ('13', '奠安乡', '隆德县');
INSERT INTO `tb_towns` VALUES ('14', '新民乡', '泾源县');
INSERT INTO `tb_towns` VALUES ('15', '草庙乡', '彭阳县');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(32) NOT NULL COMMENT '密码，加密存储',
  `pid` varchar(32) NOT NULL COMMENT '身份证号',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `created` datetime NOT NULL COMMENT '创建时间',
  `updated` datetime NOT NULL,
  `health` varchar(1) DEFAULT '1' COMMENT '健康状态（0死亡 1健康 2一般 3病重 4残疾）',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `status` varchar(1) DEFAULT NULL COMMENT '使用状态（Y正常 N非正常）',
  `head_pic` varchar(150) DEFAULT NULL COMMENT '头像地址',
  `is_mobile_check` varchar(1) DEFAULT '0' COMMENT '手机是否验证 （0否  1是）',
  `sex` varchar(1) DEFAULT '0' COMMENT '性别，1男，2女',
  `user_level` int(11) DEFAULT NULL COMMENT '会员等级',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'ningzhi', '宁知', '123', '640402199512129999', '18829345027', '2019-04-19 16:05:23', '2019-04-19 16:05:34', '1', null, null, null, '0', '男', null, null, '2019-04-24 12:01:25', '宁夏回族自治区 固原市 原州区');
INSERT INTO `tb_user` VALUES ('2', 'wangyu', '王玉', '123', '640402199412129999', null, '2019-04-23 10:43:14', '2019-04-23 10:43:17', '1', null, null, null, '0', '女', null, null, '2019-04-24 12:01:28', '宁夏回族自治区 固原市 原州区');
INSERT INTO `tb_user` VALUES ('3', 'xiayu', '夏宇', '123', '640402199312129999', null, '2019-04-23 10:45:53', '2019-04-23 10:45:56', '1', null, null, null, '0', '男', null, null, null, '宁夏回族自治区 固原市 原州区');
INSERT INTO `tb_user` VALUES ('4', 'lidong', '李冬', '123', '640402199212129999', null, '2019-04-23 10:47:56', '2019-04-23 10:47:59', '1', null, null, null, '0', '女', null, null, null, '宁夏回族自治区 固原市 原州区');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `role_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for tb_vedio
-- ----------------------------
DROP TABLE IF EXISTS `tb_vedio`;
CREATE TABLE `tb_vedio` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标题',
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL COMMENT '视频地址',
  `type` varchar(255) DEFAULT NULL COMMENT '视频类型  政策，文化，教育，农技，其他',
  `state` varchar(255) DEFAULT NULL COMMENT '视频状态 审核通过，审核未通过，提交未审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_vedio
-- ----------------------------

-- ----------------------------
-- Table structure for tb_villages
-- ----------------------------
DROP TABLE IF EXISTS `tb_villages`;
CREATE TABLE `tb_villages` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `town_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `town_id` (`town_id`),
  CONSTRAINT `town_id` FOREIGN KEY (`town_id`) REFERENCES `tb_towns` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_villages
-- ----------------------------
INSERT INTO `tb_villages` VALUES ('1', '官厅村民委员会', '1');
INSERT INTO `tb_villages` VALUES ('2', '牛滚塘村民委员会', '1');
INSERT INTO `tb_villages` VALUES ('3', '骆驼河村', '4');
INSERT INTO `tb_villages` VALUES ('4', '黄家河村', '4');
