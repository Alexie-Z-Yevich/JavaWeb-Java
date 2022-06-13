/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : sys_admin

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 13/06/2022 19:02:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for change_code
-- ----------------------------
DROP TABLE IF EXISTS `change_code`;
CREATE TABLE `change_code`  (
  `change_id` int NOT NULL,
  `statu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of change_code
-- ----------------------------
INSERT INTO `change_code` VALUES (0, '转系');
INSERT INTO `change_code` VALUES (1, '休学');
INSERT INTO `change_code` VALUES (2, '复学');
INSERT INTO `change_code` VALUES (3, '退学');
INSERT INTO `change_code` VALUES (4, '毕业');
INSERT INTO `change_code` VALUES (5, '在读');

-- ----------------------------
-- Table structure for change_message
-- ----------------------------
DROP TABLE IF EXISTS `change_message`;
CREATE TABLE `change_message`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `s_id` int NOT NULL COMMENT '学号',
  `change_id` int NOT NULL COMMENT '状态号',
  `rec_time` datetime NOT NULL COMMENT '记录时间',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of change_message
-- ----------------------------
INSERT INTO `change_message` VALUES (1, 2005060101, 0, '2022-06-12 14:22:59', '开始测试哒');
INSERT INTO `change_message` VALUES (3, 2005060101, 1, '2022-06-12 14:29:20', '能不能重复');
INSERT INTO `change_message` VALUES (5, 2005060101, 5, '2022-06-12 15:18:21', NULL);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `dept_id` int NOT NULL COMMENT '院系id',
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院系名称',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '人文学院');
INSERT INTO `department` VALUES (2, '马克思主义学院');
INSERT INTO `department` VALUES (3, '商学院');
INSERT INTO `department` VALUES (4, '数学与计算科学学院');
INSERT INTO `department` VALUES (6, '计算机科学与工程学院');

-- ----------------------------
-- Table structure for punish_levels
-- ----------------------------
DROP TABLE IF EXISTS `punish_levels`;
CREATE TABLE `punish_levels`  (
  `punish_id` int NOT NULL COMMENT '处罚号',
  `punish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '处罚',
  PRIMARY KEY (`punish_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of punish_levels
-- ----------------------------
INSERT INTO `punish_levels` VALUES (0, '警告');
INSERT INTO `punish_levels` VALUES (1, '严重警告');
INSERT INTO `punish_levels` VALUES (2, '记过');
INSERT INTO `punish_levels` VALUES (3, '记大过');
INSERT INTO `punish_levels` VALUES (4, '开除');

-- ----------------------------
-- Table structure for punish_message
-- ----------------------------
DROP TABLE IF EXISTS `punish_message`;
CREATE TABLE `punish_message`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `s_id` int NOT NULL,
  `punish_id` int NOT NULL,
  `rec_time` datetime NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of punish_message
-- ----------------------------
INSERT INTO `punish_message` VALUES (1, 2005060101, 0, '2022-06-12 17:50:02', '测试机');
INSERT INTO `punish_message` VALUES (3, 2005060101, 4, '2022-06-12 18:37:14', NULL);

-- ----------------------------
-- Table structure for reward_levels
-- ----------------------------
DROP TABLE IF EXISTS `reward_levels`;
CREATE TABLE `reward_levels`  (
  `reward_id` int NOT NULL COMMENT '奖励号',
  `reward` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '奖励',
  PRIMARY KEY (`reward_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reward_levels
-- ----------------------------
INSERT INTO `reward_levels` VALUES (0, '校特等奖学金');
INSERT INTO `reward_levels` VALUES (1, '校一等奖学金');
INSERT INTO `reward_levels` VALUES (2, '校二等奖学金');
INSERT INTO `reward_levels` VALUES (3, '校三等奖学金');
INSERT INTO `reward_levels` VALUES (4, '系一等奖学金');
INSERT INTO `reward_levels` VALUES (5, '系二等奖学金');
INSERT INTO `reward_levels` VALUES (6, '系三等奖学金');

-- ----------------------------
-- Table structure for reward_message
-- ----------------------------
DROP TABLE IF EXISTS `reward_message`;
CREATE TABLE `reward_message`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `s_id` int NOT NULL COMMENT '学号',
  `reward_id` int NOT NULL COMMENT '奖励号',
  `rec_time` datetime NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reward_message
-- ----------------------------
INSERT INTO `reward_message` VALUES (1, 2005060106, 0, '2022-06-12 18:41:54', '测试开始');
INSERT INTO `reward_message` VALUES (2, 2005060101, 1, '2022-06-12 17:03:51', '测试开始');

-- ----------------------------
-- Table structure for sys_class
-- ----------------------------
DROP TABLE IF EXISTS `sys_class`;
CREATE TABLE `sys_class`  (
  `class_id` int NOT NULL COMMENT '班级号',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级名',
  `class_monitor` int NOT NULL COMMENT '班长学号',
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_class
-- ----------------------------
INSERT INTO `sys_class` VALUES (1, '大数据一班', 2005060101);
INSERT INTO `sys_class` VALUES (2, '大数据二班', 2005060201);
INSERT INTO `sys_class` VALUES (3, '大数据三班', 2005060301);

-- ----------------------------
-- Table structure for sys_class_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_class_dept`;
CREATE TABLE `sys_class_dept`  (
  `class_id` int NOT NULL COMMENT '班级编号',
  `dept_id` int NOT NULL COMMENT '院系编号',
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_class_dept
-- ----------------------------
INSERT INTO `sys_class_dept` VALUES (1, 6);
INSERT INTO `sys_class_dept` VALUES (2, 6);
INSERT INTO `sys_class_dept` VALUES (3, 6);

-- ----------------------------
-- Table structure for sys_course
-- ----------------------------
DROP TABLE IF EXISTS `sys_course`;
CREATE TABLE `sys_course`  (
  `c_id` int NOT NULL COMMENT '课程号',
  `c_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_course
-- ----------------------------
INSERT INTO `sys_course` VALUES (1, '数学');
INSERT INTO `sys_course` VALUES (2, 'Java');
INSERT INTO `sys_course` VALUES (3, '英语');
INSERT INTO `sys_course` VALUES (4, '体育');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int NOT NULL COMMENT '类型     0：目录   1：菜单   2：按钮',
  `icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `orderNum` int NULL DEFAULT NULL COMMENT '排序',
  `created` datetime NOT NULL,
  `updated` datetime NULL DEFAULT NULL,
  `statu` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', '', 'sys:manage', '', 0, 'Expand', 1, '2021-01-15 18:58:18', '2021-01-15 18:58:20', 1);
INSERT INTO `sys_menu` VALUES (2, 1, '用户管理', '/sys/users', 'sys:user:list', 'sys/User', 1, 'Avatar', 1, '2021-01-15 19:03:45', '2021-01-15 19:03:48', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', '/sys/roles', 'sys:role:list', 'sys/Role', 1, 'Rank', 2, '2021-01-15 19:03:45', '2021-01-15 19:03:48', 1);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', '/sys/menus', 'sys:menu:list', 'sys/Menu', 1, 'Menu', 3, '2021-01-15 19:03:45', '2021-01-15 19:03:48', 1);
INSERT INTO `sys_menu` VALUES (5, 0, '系统工具', '', 'sys:tools', NULL, 0, 'Tools', 3, '2021-01-15 19:06:11', NULL, 1);
INSERT INTO `sys_menu` VALUES (6, 5, '数字字典', '/sys/dicts', 'sys:dict:list', 'sys/Dict', 1, 'List', 1, '2021-01-15 19:07:18', '2021-01-18 16:32:13', 1);
INSERT INTO `sys_menu` VALUES (7, 3, '添加角色', '', 'sys:role:save', '', 2, '', 1, '2021-01-15 23:02:25', '2021-01-17 21:53:14', 0);
INSERT INTO `sys_menu` VALUES (9, 2, '添加用户', NULL, 'sys:user:save', NULL, 2, NULL, 1, '2021-01-17 21:48:32', NULL, 1);
INSERT INTO `sys_menu` VALUES (10, 2, '修改用户', NULL, 'sys:user:update', NULL, 2, NULL, 2, '2021-01-17 21:49:03', '2021-01-17 21:53:04', 1);
INSERT INTO `sys_menu` VALUES (11, 2, '删除用户', NULL, 'sys:user:delete', NULL, 2, NULL, 3, '2021-01-17 21:49:21', NULL, 1);
INSERT INTO `sys_menu` VALUES (12, 2, '分配角色', NULL, 'sys:user:role', NULL, 2, NULL, 4, '2021-01-17 21:49:58', NULL, 1);
INSERT INTO `sys_menu` VALUES (13, 2, '重置密码', NULL, 'sys:user:repass', NULL, 2, NULL, 5, '2021-01-17 21:50:36', NULL, 1);
INSERT INTO `sys_menu` VALUES (14, 3, '修改角色', NULL, 'sys:role:update', NULL, 2, NULL, 2, '2021-01-17 21:51:14', NULL, 1);
INSERT INTO `sys_menu` VALUES (15, 3, '删除角色', NULL, 'sys:role:delete', NULL, 2, NULL, 3, '2021-01-17 21:51:39', NULL, 1);
INSERT INTO `sys_menu` VALUES (16, 3, '分配权限', NULL, 'sys:role:perm', NULL, 2, NULL, 5, '2021-01-17 21:52:02', NULL, 1);
INSERT INTO `sys_menu` VALUES (17, 4, '添加菜单', NULL, 'sys:menu:save', NULL, 2, NULL, 1, '2021-01-17 21:53:53', '2021-01-17 21:55:28', 1);
INSERT INTO `sys_menu` VALUES (18, 4, '修改菜单', NULL, 'sys:menu:update', NULL, 2, NULL, 2, '2021-01-17 21:56:12', NULL, 1);
INSERT INTO `sys_menu` VALUES (19, 4, '删除菜单', NULL, 'sys:menu:delete', NULL, 2, NULL, 3, '2021-01-17 21:56:36', NULL, 1);
INSERT INTO `sys_menu` VALUES (20, 0, '学生管理', NULL, 'stu:manage', NULL, 0, 'Grid', 2, '2022-05-29 15:55:59', NULL, 1);
INSERT INTO `sys_menu` VALUES (21, 20, '学生信息', '/stu/students', 'stu:message:list', 'stu/Student', 1, 'School', 1, '2022-05-29 15:58:56', NULL, 1);
INSERT INTO `sys_menu` VALUES (22, 20, '成绩查询', '/stu/grades', 'stu:grade:list', 'stu/Grade', 1, 'Checked', 2, '2022-05-29 16:02:04', NULL, 1);
INSERT INTO `sys_menu` VALUES (23, 20, '成绩录入', '/stu/pushs', 'stu:push:list', 'stu/Push', 1, 'Histogram', 3, '2022-05-29 16:03:23', NULL, 1);
INSERT INTO `sys_menu` VALUES (24, 21, '添加学生', NULL, 'stu:student:save', NULL, 2, NULL, 1, '2022-05-29 21:38:17', NULL, 1);
INSERT INTO `sys_menu` VALUES (25, 21, '删除学生', NULL, 'stu:student:delete', NULL, 2, NULL, 2, '2022-05-29 21:39:41', NULL, 1);
INSERT INTO `sys_menu` VALUES (26, 21, '修改学生', NULL, 'stu:student:update', NULL, 2, NULL, 3, '2022-05-29 21:40:36', NULL, 1);
INSERT INTO `sys_menu` VALUES (27, 0, '学籍管理', NULL, 'sta:manage', NULL, 0, 'Management', 4, '2022-06-09 18:42:36', NULL, 1);
INSERT INTO `sys_menu` VALUES (28, 27, '学籍变更', '/sta/changes', 'sta:change:list', 'sta/Change', 1, 'Switch', 1, '2022-06-09 18:44:20', NULL, 1);
INSERT INTO `sys_menu` VALUES (29, 27, '学生奖励', '/sta/rewards', 'sta:reward:list', 'sta/Reward', 1, 'Medal', 2, '2022-06-09 18:45:39', NULL, 1);
INSERT INTO `sys_menu` VALUES (30, 27, '学生处罚', '/sta/punishs', 'sta:punish:list', 'sta/Punish', 1, 'WarningFilled', 3, '2022-06-09 18:46:38', NULL, 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `created` datetime NULL DEFAULT NULL,
  `updated` datetime NULL DEFAULT NULL,
  `statu` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE,
  UNIQUE INDEX `code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (3, '普通用户', 'normal', '只有基本查看功能', '2021-01-04 10:09:14', '2021-01-30 08:19:52', 1);
INSERT INTO `sys_role` VALUES (6, '超级管理员', 'admin', '系统默认最高权限，不可以编辑和任意修改', '2021-01-16 13:29:03', '2021-01-17 15:50:45', 1);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL,
  `menu_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (60, 6, 1);
INSERT INTO `sys_role_menu` VALUES (61, 6, 2);
INSERT INTO `sys_role_menu` VALUES (62, 6, 9);
INSERT INTO `sys_role_menu` VALUES (63, 6, 10);
INSERT INTO `sys_role_menu` VALUES (64, 6, 11);
INSERT INTO `sys_role_menu` VALUES (65, 6, 12);
INSERT INTO `sys_role_menu` VALUES (66, 6, 13);
INSERT INTO `sys_role_menu` VALUES (67, 6, 3);
INSERT INTO `sys_role_menu` VALUES (68, 6, 7);
INSERT INTO `sys_role_menu` VALUES (69, 6, 14);
INSERT INTO `sys_role_menu` VALUES (70, 6, 15);
INSERT INTO `sys_role_menu` VALUES (71, 6, 16);
INSERT INTO `sys_role_menu` VALUES (72, 6, 4);
INSERT INTO `sys_role_menu` VALUES (73, 6, 17);
INSERT INTO `sys_role_menu` VALUES (74, 6, 18);
INSERT INTO `sys_role_menu` VALUES (75, 6, 19);
INSERT INTO `sys_role_menu` VALUES (96, 3, 1);
INSERT INTO `sys_role_menu` VALUES (97, 3, 2);
INSERT INTO `sys_role_menu` VALUES (98, 3, 3);
INSERT INTO `sys_role_menu` VALUES (99, 3, 4);
INSERT INTO `sys_role_menu` VALUES (100, 3, 5);
INSERT INTO `sys_role_menu` VALUES (101, 3, 6);
INSERT INTO `sys_role_menu` VALUES (102, 6, 20);
INSERT INTO `sys_role_menu` VALUES (103, 6, 21);
INSERT INTO `sys_role_menu` VALUES (104, 6, 22);
INSERT INTO `sys_role_menu` VALUES (105, 6, 23);
INSERT INTO `sys_role_menu` VALUES (106, 6, 24);
INSERT INTO `sys_role_menu` VALUES (107, 6, 25);
INSERT INTO `sys_role_menu` VALUES (108, 6, 26);
INSERT INTO `sys_role_menu` VALUES (109, 6, 27);
INSERT INTO `sys_role_menu` VALUES (110, 6, 28);
INSERT INTO `sys_role_menu` VALUES (111, 6, 29);
INSERT INTO `sys_role_menu` VALUES (112, 6, 30);

-- ----------------------------
-- Table structure for sys_student
-- ----------------------------
DROP TABLE IF EXISTS `sys_student`;
CREATE TABLE `sys_student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `s_id` int NOT NULL COMMENT '学号',
  `s_name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `birth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生年月日',
  `native_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `class_id` int NOT NULL COMMENT '班级号',
  `dept_id` int NOT NULL COMMENT '院系号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `s_id`(`s_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2005060319 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_student
-- ----------------------------
INSERT INTO `sys_student` VALUES (1, 2005060101, '钱怀政', '男', '2022-05-28', 'XX地', 1, 6);
INSERT INTO `sys_student` VALUES (2, 2005060102, '王振华', '男', '2022-05-28', 'XX地', 1, 6);
INSERT INTO `sys_student` VALUES (3, 2005060103, '王雨桥', '男', '2022-05-28', 'XX地', 1, 6);
INSERT INTO `sys_student` VALUES (4, 2005060104, '邹嘉恒', '男', '2022-05-28', 'XX地', 1, 6);
INSERT INTO `sys_student` VALUES (5, 2005060105, '渠伟', '男', '2022-05-28', 'XX地', 1, 6);
INSERT INTO `sys_student` VALUES (6, 2005060201, '小一', '女', '2022-05-28', '长沙', 2, 6);
INSERT INTO `sys_student` VALUES (7, 2005060202, '小二', '女', '2022-05-28', '长沙', 2, 6);
INSERT INTO `sys_student` VALUES (8, 2005060203, '小三', '女', '2022-05-28', '长沙', 2, 6);
INSERT INTO `sys_student` VALUES (9, 2005060204, '小四', '女', '2022-05-28', '长沙', 2, 6);
INSERT INTO `sys_student` VALUES (2005060315, 2005060106, '艾志远', '男', '2002-06-17', '长沙', 1, 6);

-- ----------------------------
-- Table structure for sys_student_course
-- ----------------------------
DROP TABLE IF EXISTS `sys_student_course`;
CREATE TABLE `sys_student_course`  (
  `s_id` int NOT NULL COMMENT '学号',
  `c_id` int NOT NULL COMMENT '课程号',
  `grade` int NOT NULL COMMENT '成绩',
  INDEX `sys_student_course_ibfk_1`(`c_id`) USING BTREE,
  INDEX `s_id`(`s_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_student_course
-- ----------------------------
INSERT INTO `sys_student_course` VALUES (2005060101, 1, 70);
INSERT INTO `sys_student_course` VALUES (2005060101, 2, 80);
INSERT INTO `sys_student_course` VALUES (2005060101, 3, 100);
INSERT INTO `sys_student_course` VALUES (2005060101, 4, 100);
INSERT INTO `sys_student_course` VALUES (2005060102, 1, 80);
INSERT INTO `sys_student_course` VALUES (2005060102, 2, 90);
INSERT INTO `sys_student_course` VALUES (2005060102, 3, 100);
INSERT INTO `sys_student_course` VALUES (2005060102, 4, 70);
INSERT INTO `sys_student_course` VALUES (2005060103, 1, 90);
INSERT INTO `sys_student_course` VALUES (2005060103, 2, 70);
INSERT INTO `sys_student_course` VALUES (2005060103, 3, 80);
INSERT INTO `sys_student_course` VALUES (2005060103, 4, 100);
INSERT INTO `sys_student_course` VALUES (2005060104, 1, 100);
INSERT INTO `sys_student_course` VALUES (2005060104, 2, 90);
INSERT INTO `sys_student_course` VALUES (2005060104, 3, 70);
INSERT INTO `sys_student_course` VALUES (2005060104, 4, 80);
INSERT INTO `sys_student_course` VALUES (2005060105, 1, 90);
INSERT INTO `sys_student_course` VALUES (2005060105, 2, 95);
INSERT INTO `sys_student_course` VALUES (2005060105, 3, 100);
INSERT INTO `sys_student_course` VALUES (2005060105, 4, 90);
INSERT INTO `sys_student_course` VALUES (2005060106, 1, 100);
INSERT INTO `sys_student_course` VALUES (2005060106, 2, 99);
INSERT INTO `sys_student_course` VALUES (2005060106, 3, 98);
INSERT INTO `sys_student_course` VALUES (2005060106, 4, 97);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created` datetime NULL DEFAULT NULL,
  `updated` datetime NULL DEFAULT NULL,
  `last_login` datetime NULL DEFAULT NULL,
  `statu` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_USERNAME`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$R7zegeWzOXPw871CmNuJ6upC0v8D373GuLuTw8jn6NET4BkPRZfgK', 'https://raw.githubusercontent.com/Alexie-Z-Yevich/Project/master/vue2/src/assets/CatAdmin.jpg', '123@qq.com', '广州', '2021-01-12 22:13:53', '2021-01-16 16:57:32', '2020-12-30 08:38:37', 1);
INSERT INTO `sys_user` VALUES (2, 'test', '$2a$10$R7zegeWzOXPw871CmNuJ6upC0v8D373GuLuTw8jn6NET4BkPRZfgK', 'https://raw.githubusercontent.com/Alexie-Z-Yevich/Project/master/vue2/src/assets/CatAdmin.jpg', 'test@qq.com', NULL, '2021-01-30 08:20:22', '2021-01-30 08:55:57', NULL, 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (4, 1, 6);
INSERT INTO `sys_user_role` VALUES (7, 1, 3);
INSERT INTO `sys_user_role` VALUES (13, 2, 3);

-- ----------------------------
-- View structure for check1
-- ----------------------------
DROP VIEW IF EXISTS `check1`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `check1` AS select `temp1`.`s_id` AS `s_id`,`temp1`.`math` AS `math`,`temp1`.`java` AS `java`,`temp1`.`English` AS `English`,`temp1`.`ET` AS `ET`,`sys_student`.`id` AS `id`,`sys_student`.`s_name` AS `s_name`,`sys_student`.`sex` AS `sex`,`sys_student`.`birth` AS `birth`,`sys_student`.`native_place` AS `native_place`,`sys_student`.`statu` AS `statu`,`sys_student`.`class_id` AS `class_id` from ((select `temp`.`s_id` AS `s_id`,sum(if((`temp`.`c_name` = '数学'),`temp`.`grade`,0)) AS `math`,sum(if((`temp`.`c_name` = 'Java'),`temp`.`grade`,0)) AS `java`,sum(if((`temp`.`c_name` = '英语'),`temp`.`grade`,0)) AS `English`,sum(if((`temp`.`c_name` = '体育'),`temp`.`grade`,0)) AS `ET` from (select `ss`.`s_id` AS `s_id`,`ss`.`s_name` AS `s_name`,`sc`.`c_name` AS `c_name`,`ssc`.`grade` AS `grade`,`ss`.`class_id` AS `class_id` from (((`sys_student` `ss` left join `sys_student_course` `ssc` on((`ss`.`s_id` = `ssc`.`s_id`))) left join `sys_course` `sc` on((`ssc`.`c_id` = `sc`.`c_id`))) left join `sys_class` on((`ss`.`class_id` = `sys_class`.`class_id`)))) `temp` where (`temp`.`class_id` = (select `sys_student`.`class_id` from `sys_student` where (`sys_student`.`s_id` = 2005060101))) group by `temp`.`s_name`) `temp1` left join `sys_student` on((`temp1`.`s_id` = `sys_student`.`s_id`)));

SET FOREIGN_KEY_CHECKS = 1;
