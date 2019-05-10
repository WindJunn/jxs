/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : jxs

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-10 18:19:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article` (
  `id` varchar(50) NOT NULL,
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
  `id` varchar(50) NOT NULL COMMENT '用户id',
  `user_id` varchar(50) DEFAULT NULL,
  `state` int(1) DEFAULT NULL COMMENT '0 出勤 1 请假 2 公差 3 迟到 4 早退 5 旷课',
  `attendance_time` date DEFAULT NULL COMMENT '考勤时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_attendance
-- ----------------------------
INSERT INTO `tb_attendance` VALUES ('1', '1', '0', '2019-04-23');
INSERT INTO `tb_attendance` VALUES ('2', '2', '0', '2019-04-23');
INSERT INTO `tb_attendance` VALUES ('3', '3', '1', '2019-04-23');
INSERT INTO `tb_attendance` VALUES ('4', '4', '0', '2019-04-23');
INSERT INTO `tb_attendance` VALUES ('5', '1', '0', '2019-05-05');
INSERT INTO `tb_attendance` VALUES ('6', '2', '0', '2019-05-05');
INSERT INTO `tb_attendance` VALUES ('7', '3', '0', '2019-05-05');
INSERT INTO `tb_attendance` VALUES ('8', '4', '0', '2019-05-05');

-- ----------------------------
-- Table structure for tb_attendance_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_attendance_user`;
CREATE TABLE `tb_attendance_user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(100) NOT NULL COMMENT '密码，加密存储',
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
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of tb_attendance_user
-- ----------------------------
INSERT INTO `tb_attendance_user` VALUES ('1', 'ningzhi', '宁知', '123', '640402199512129991', '18829345027', '2019-04-19 16:05:23', '2019-04-19 16:05:34', '1', null, null, null, '0', '男', null, '2019-04-24 12:01:25', '宁夏回族自治区 固原市 原州区');
INSERT INTO `tb_attendance_user` VALUES ('2', 'wangyu', '王玉', '123', '640402199412129992', null, '2019-04-23 10:43:14', '2019-04-23 10:43:17', '1', null, null, null, '0', '女', null, '2019-04-24 12:01:28', '宁夏回族自治区 固原市 原州区');
INSERT INTO `tb_attendance_user` VALUES ('3', 'xiayu', '夏宇', '123', '640402199312129993', null, '2019-04-23 10:45:53', '2019-04-23 10:45:56', '1', null, null, null, '0', '男', null, null, '宁夏回族自治区 固原市 原州区');
INSERT INTO `tb_attendance_user` VALUES ('4', 'lidong', '李冬', '123', '640402199212129994', null, '2019-04-23 10:47:56', '2019-04-23 10:47:59', '1', null, null, null, '0', '女', null, null, '宁夏回族自治区 固原市 原州区');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` varchar(50) NOT NULL,
  `article_id` varchar(50) DEFAULT NULL,
  `content` longtext COMMENT '评论内容',
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `keystr` varchar(255) DEFAULT NULL COMMENT '权限键值',
  `resid` varchar(255) DEFAULT NULL COMMENT '关联的资源，如果没有则为系统权限',
  `valid` tinyint(1) DEFAULT NULL COMMENT '当前元组是否有效，1（true）表示有效；0（false）表示无效【无效时不能操作该元组】',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------

-- ----------------------------
-- Table structure for tb_resource
-- ----------------------------
DROP TABLE IF EXISTS `tb_resource`;
CREATE TABLE `tb_resource` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `valid` tinyint(1) DEFAULT NULL,
  `cdate` datetime DEFAULT NULL,
  `mdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_resource
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `is_default` varchar(20) DEFAULT NULL COMMENT '是否默认',
  `status` varchar(20) NOT NULL COMMENT '状态 0-启用，1-禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '普通用户', '普通用户', '1', '0');
INSERT INTO `tb_role` VALUES ('2', '村管理员', '村管理员', '0', '0');
INSERT INTO `tb_role` VALUES ('3', '镇管理员', '镇管理员', '0', '0');
INSERT INTO `tb_role` VALUES ('4', '县管理员', '县管理员', '0', '0');
INSERT INTO `tb_role` VALUES ('5', '市管理员', '市管理员', '0', '0');
INSERT INTO `tb_role` VALUES ('6', '超级管理员', '超级管理员', '0', '0');
INSERT INTO `tb_role` VALUES ('7', '教师', '教师', '0', '0');

-- ----------------------------
-- Table structure for tb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission` (
  `id` varchar(50) NOT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  `permission_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for tb_schedule
-- ----------------------------
DROP TABLE IF EXISTS `tb_schedule`;
CREATE TABLE `tb_schedule` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `name` varchar(255) DEFAULT NULL COMMENT '教员姓名',
  `teaching_time` datetime DEFAULT NULL COMMENT '授课时间',
  `teaching_site` varchar(255) DEFAULT NULL COMMENT '授课地点',
  `teaching_theme` varchar(255) DEFAULT NULL COMMENT '授课主题',
  `teaching_state` varchar(255) DEFAULT NULL COMMENT '授课状态 1.已授课 2.未授课',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_schedule
-- ----------------------------
INSERT INTO `tb_schedule` VALUES ('1', '1', null, '2019-04-29 16:00:00', '大池村', '水稻防虫', '1');

-- ----------------------------
-- Table structure for tb_towns
-- ----------------------------
DROP TABLE IF EXISTS `tb_towns`;
CREATE TABLE `tb_towns` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_towns
-- ----------------------------
INSERT INTO `tb_towns` VALUES ('1', '官厅镇', '原州区');
INSERT INTO `tb_towns` VALUES ('10', '香水镇', '泾源县');
INSERT INTO `tb_towns` VALUES ('11', '白阳镇', '彭阳县');
INSERT INTO `tb_towns` VALUES ('12', '火石寨乡', '西吉县');
INSERT INTO `tb_towns` VALUES ('13', '奠安乡', '隆德县');
INSERT INTO `tb_towns` VALUES ('14', '新民乡', '泾源县');
INSERT INTO `tb_towns` VALUES ('15', '草庙乡', '彭阳县');
INSERT INTO `tb_towns` VALUES ('2', '黄铎堡镇', '原州区');
INSERT INTO `tb_towns` VALUES ('3', '张易镇', '原州区');
INSERT INTO `tb_towns` VALUES ('4', '河川乡', '原州区');
INSERT INTO `tb_towns` VALUES ('5', '北塬街道', '原州区');
INSERT INTO `tb_towns` VALUES ('6', '古雁街道', '原州区');
INSERT INTO `tb_towns` VALUES ('7', '南关街道', '原州区');
INSERT INTO `tb_towns` VALUES ('8', '吉强镇', '西吉县');
INSERT INTO `tb_towns` VALUES ('9', '城关镇', '隆德县');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` varchar(50) NOT NULL,
  `pid` varchar(30) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '640402199212129994', '吴语', 'wuyu', '123', null, '1', null, '2019-04-30 16:14:01', '2019-04-30 16:14:04');
INSERT INTO `tb_user` VALUES ('1125650939160653824', null, null, 'wu1', '$2a$10$O4r2brc/yRUlL4hDhwdyDOT1SSUUoPV7PitbrFUKXYCtYQha6gqv2', null, '1', null, '2019-05-07 06:37:52', '2019-05-07 06:37:52');
INSERT INTO `tb_user` VALUES ('1125651432683352064', null, null, 'wu2', '$2a$10$15Uk0BwQDLizMTL4XLdT1.T8D8u8rl1hMcQ/NEHqrxPpYgxV7RvNG', null, '1', null, '2019-05-07 06:39:50', '2019-05-07 06:39:50');
INSERT INTO `tb_user` VALUES ('1125651452291723264', null, null, 'wu', '$2a$10$VUNmKoWBZolOekORNFV88epGqgZKDn29XvblvS8A8417qM.gbuYKm', null, '1', null, '2019-05-07 06:39:54', '2019-05-07 06:39:54');
INSERT INTO `tb_user` VALUES ('2', '640402199212129999', '超级管理员', 'admin', 'admin', null, '1', null, '2019-05-07 11:18:40', '2019-05-07 11:18:45');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` varchar(100) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `role_id` varchar(100) DEFAULT NULL,
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
  `id` varchar(50) NOT NULL COMMENT '标题',
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
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `town_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `town_id` (`town_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_villages
-- ----------------------------
INSERT INTO `tb_villages` VALUES ('1', '官厅村民委员会', '1');
INSERT INTO `tb_villages` VALUES ('2', '牛滚塘村民委员会', '1');
INSERT INTO `tb_villages` VALUES ('3', '骆驼河村', '4');
INSERT INTO `tb_villages` VALUES ('4', '黄家河村', '4');
