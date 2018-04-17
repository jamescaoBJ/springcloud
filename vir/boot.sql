/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : boot

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-22 09:06:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `dictId` varchar(32) NOT NULL COMMENT '物理主键',
  `value` char(5) DEFAULT NULL COMMENT '编码',
  `label` varchar(100) DEFAULT NULL COMMENT '名称',
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  `description` varchar(200) DEFAULT NULL,
  `flag` char(1) DEFAULT '1',
  `createBy` varchar(32) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`dictId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `logId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `tread` varchar(100) DEFAULT NULL COMMENT '当前线程',
  `info_level` varchar(20) DEFAULT NULL COMMENT '日志级别',
  `info_class` varchar(300) DEFAULT NULL COMMENT '操作行数等类的相关信息',
  `message` text COMMENT '操作信息',
  `user_id` varchar(32) DEFAULT NULL COMMENT '操作人',
  `user_name` varchar(20) DEFAULT NULL COMMENT '操作人名字',
  `session_id` varchar(40) DEFAULT NULL COMMENT 'session id',
  `ip` varchar(20) DEFAULT NULL COMMENT 'ip地址',
  `login_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB AUTO_INCREMENT=1463 DEFAULT CHARSET=utf8 COMMENT='监控操作日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `organizationId` varchar(32) NOT NULL,
  `organizationName` varchar(200) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `createBy` varchar(32) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `order` int(20) DEFAULT NULL COMMENT '保留字段，有可能不用：排序字段',
  `parentId` varchar(32) DEFAULT NULL,
  `flag` char(1) DEFAULT '1',
  `type` char(5) DEFAULT NULL COMMENT '机构类别：字典项允许自定义',
  `remark` text,
  `code` varchar(10) DEFAULT NULL COMMENT '机构编码',
  PRIMARY KEY (`organizationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织机构表';

-- ----------------------------
-- Records of sys_organization
-- ----------------------------

-- ----------------------------
-- Table structure for sys_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_resources`;
CREATE TABLE `sys_resources` (
  `resourceId` varchar(32) NOT NULL,
  `id` varchar(200) DEFAULT NULL COMMENT '菜单document资源id',
  `name` varchar(100) DEFAULT NULL,
  `target` varchar(100) DEFAULT NULL COMMENT 'bjui target',
  `url` varchar(300) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '菜单链接',
  `authority` text COMMENT '权限标识  add,',
  `parentId` varchar(32) DEFAULT NULL,
  `type` char(1) DEFAULT NULL COMMENT '菜单；按钮；其它',
  `createBy` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `flag` char(1) DEFAULT '1',
  `order` int(11) DEFAULT NULL COMMENT '排序',
  `level` int(11) DEFAULT NULL COMMENT '树层级',
  `icon` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`resourceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_resources
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `roleId` varchar(32) NOT NULL,
  `roleName` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `createBy` varchar(32) DEFAULT NULL,
  `flag` char(1) DEFAULT '1',
  `order` int(11) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('95DF7813693D4B4F827CEFF1CF466B21', 'admin', null, null, '1', null, null);

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `roleId` varchar(32) NOT NULL COMMENT '角色id',
  `resourceId` varchar(32) NOT NULL COMMENT '菜单id',
  `roleResourceId` varchar(32) NOT NULL,
  PRIMARY KEY (`roleResourceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源关联表';

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `userId` varchar(32) NOT NULL COMMENT '用户id',
  `userName` varchar(200) DEFAULT NULL COMMENT '用户名',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `realName` varchar(100) DEFAULT NULL COMMENT '登录名',
  `passwd` varchar(64) DEFAULT NULL COMMENT '密码',
  `tel` varchar(15) DEFAULT NULL COMMENT '固话',
  `cellphone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `createBy` varchar(32) DEFAULT NULL COMMENT '创建者',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `flag` char(1) DEFAULT '1' COMMENT '是否可用  1 可用 0 不可用',
  `remark` varchar(200) DEFAULT NULL,
  `organizationId` varchar(32) DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `loginName` (`realName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('5B45975FE93842F7ACA6CB9AB40D109E', 'lyj', null, 'liyajie', '1989', null, null, null, null, '1', null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `userId` varchar(32) NOT NULL,
  `roleId` varchar(32) NOT NULL,
  `userRoleId` varchar(32) NOT NULL,
  PRIMARY KEY (`userRoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
