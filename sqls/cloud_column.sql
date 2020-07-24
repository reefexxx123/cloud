/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : cloud_column

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-07-23 10:32:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table` (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
  `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `tenant_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '租户id',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='代码生成业务表';

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES ('1', 'sys_role', '角色信息表', 'SysRole', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'role', '角色信息', 'xxxJppp', null, '', '2020-07-01 11:26:56', '', null, null, '');
INSERT INTO `gen_table` VALUES ('2', 'sys_menu', '菜单权限表', 'SysMenu', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'menu', '菜单权限', 'xxxJppp', null, '', '2020-07-01 19:59:42', '', null, null, '');
INSERT INTO `gen_table` VALUES ('3', 'sys_config', '参数配置表', 'SysConfig', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'config', '参数配置', 'xxxJppp', null, '', '2020-07-02 10:42:18', '', null, null, '');
INSERT INTO `gen_table` VALUES ('4', 'sys_dept', '部门表', 'SysDept', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'dept', '部门', 'xxxJppp', null, '', '2020-07-02 10:45:29', '', null, null, '');
INSERT INTO `gen_table` VALUES ('6', 'sys_dict_data', '字典数据表', 'SysDictData', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'dictdata', '字典数据', 'xxxJppp', null, '', '2020-07-02 10:48:33', '', null, null, '');
INSERT INTO `gen_table` VALUES ('7', 'sys_dict_type', '字典类型表', 'SysDictType', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'dicttype', '字典类型', 'xxxJppp', null, '', '2020-07-02 10:48:33', '', null, null, '');
INSERT INTO `gen_table` VALUES ('8', 'sys_job', '定时任务调度表', 'SysJob', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'job', '定时任务调度', 'xxxJppp', null, '', '2020-07-02 10:48:33', '', null, null, '');
INSERT INTO `gen_table` VALUES ('9', 'sys_job_log', '定时任务调度日志表', 'SysJobLog', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'joblog', '定时任务调度日志', 'xxxJppp', null, '', '2020-07-02 10:48:33', '', null, null, '');
INSERT INTO `gen_table` VALUES ('10', 'sys_logininfor', '系统访问记录', 'SysLogininfor', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'logininfor', '系统访问记录', 'xxxJppp', null, '', '2020-07-02 10:48:33', '', null, null, '');
INSERT INTO `gen_table` VALUES ('11', 'sys_notice', '通知公告表', 'SysNotice', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'notice', '通知公告', 'xxxJppp', null, '', '2020-07-02 10:48:33', '', null, null, '');
INSERT INTO `gen_table` VALUES ('12', 'sys_oper_log', '操作日志记录', 'SysOperLog', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'operlog', '操作日志记录', 'xxxJppp', null, '', '2020-07-02 10:48:33', '', null, null, '');
INSERT INTO `gen_table` VALUES ('13', 'sys_post', '岗位信息表', 'SysPost', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'post', '岗位信息', 'xxxJppp', null, '', '2020-07-02 10:48:33', '', null, null, '');
INSERT INTO `gen_table` VALUES ('14', 'sys_role_dept', '角色和部门关联表', 'SysRoleDept', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'roledept', '角色和部门关联', 'xxxJppp', null, '', '2020-07-02 10:48:33', '', null, null, '');
INSERT INTO `gen_table` VALUES ('15', 'sys_role_menu', '角色和菜单关联表', 'SysRoleMenu', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'rolemenu', '角色和菜单关联', 'xxxJppp', null, '', '2020-07-02 10:48:33', '', null, null, '');
INSERT INTO `gen_table` VALUES ('16', 'sys_user_post', '用户与岗位关联表', 'SysUserPost', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'userpost', '用户与岗位关联', 'xxxJppp', null, '', '2020-07-02 10:48:33', '', null, null, '');
INSERT INTO `gen_table` VALUES ('17', 'sys_user_role', '用户和角色关联表', 'SysUserRole', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'userrole', '用户和角色关联', 'xxxJppp', null, '', '2020-07-02 10:48:33', '', null, null, '');
INSERT INTO `gen_table` VALUES ('18', 'mem_baseinfo', '会员基本信息', 'MemBaseinfo', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'baseinfo', '会员基本信息', 'xxxJppp', null, '', '2020-07-02 10:49:48', '', null, null, '');
INSERT INTO `gen_table` VALUES ('19', 'mem_login', '会员登录账号', 'MemLogin', 'crud', 'com.xxxJppp.cloud.business.admin', 'admin', 'login', '会员登录账号', 'xxxJppp', null, '', '2020-07-02 10:49:48', '', null, null, '');

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column` (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `tenant_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '租户id',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=199 DEFAULT CHARSET=utf8 COMMENT='代码生成业务表字段';

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES ('1', '1', 'role_id', '角色ID', 'bigint(20)', 'Long', 'roleId', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-01 11:26:56', '', null, '');
INSERT INTO `gen_table_column` VALUES ('2', '1', 'role_name', '角色名称', 'varchar(30)', 'String', 'roleName', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', '2', '', '2020-07-01 11:26:56', '', null, '');
INSERT INTO `gen_table_column` VALUES ('3', '1', 'role_key', '角色权限字符串', 'varchar(100)', 'String', 'roleKey', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', '3', '', '2020-07-01 11:26:56', '', null, '');
INSERT INTO `gen_table_column` VALUES ('4', '1', 'role_sort', '显示顺序', 'int(4)', 'Integer', 'roleSort', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', '4', '', '2020-07-01 11:26:56', '', null, '');
INSERT INTO `gen_table_column` VALUES ('5', '1', 'data_scope', '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）', 'char(1)', 'String', 'dataScope', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '5', '', '2020-07-01 11:26:56', '', null, '');
INSERT INTO `gen_table_column` VALUES ('6', '1', 'status', '角色状态（0正常 1停用）', 'char(1)', 'String', 'status', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'radio', '', '6', '', '2020-07-01 11:26:56', '', null, '');
INSERT INTO `gen_table_column` VALUES ('7', '1', 'del_flag', '删除标志（0代表存在 2代表删除）', 'char(1)', 'String', 'delFlag', '0', '0', null, '1', null, null, null, 'EQ', 'input', '', '7', '', '2020-07-01 11:26:56', '', null, '');
INSERT INTO `gen_table_column` VALUES ('8', '1', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', null, '1', null, null, null, 'EQ', 'input', '', '8', '', '2020-07-01 11:26:56', '', null, '');
INSERT INTO `gen_table_column` VALUES ('9', '1', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', null, '1', null, null, null, 'EQ', 'datetime', '', '9', '', '2020-07-01 11:26:56', '', null, '');
INSERT INTO `gen_table_column` VALUES ('10', '1', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', null, '1', '1', null, null, 'EQ', 'input', '', '10', '', '2020-07-01 11:26:56', '', null, '');
INSERT INTO `gen_table_column` VALUES ('11', '1', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', null, '1', '1', null, null, 'EQ', 'datetime', '', '11', '', '2020-07-01 11:26:56', '', null, '');
INSERT INTO `gen_table_column` VALUES ('12', '1', 'remark', '备注', 'varchar(500)', 'String', 'remark', '0', '0', null, '1', '1', '1', null, 'EQ', 'textarea', '', '12', '', '2020-07-01 11:26:56', '', null, '');
INSERT INTO `gen_table_column` VALUES ('13', '2', 'menu_id', '菜单ID', 'bigint(20)', 'Long', 'menuId', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('14', '2', 'menu_name', '菜单名称', 'varchar(50)', 'String', 'menuName', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', '2', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('15', '2', 'parent_id', '父菜单ID', 'bigint(20)', 'Long', 'parentId', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '3', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('16', '2', 'order_num', '显示顺序', 'int(4)', 'Integer', 'orderNum', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '4', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('17', '2', 'path', '路由地址', 'varchar(200)', 'String', 'path', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '5', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('18', '2', 'component', '组件路径', 'varchar(255)', 'String', 'component', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '6', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('19', '2', 'is_frame', '是否为外链（0是 1否）', 'int(1)', 'Integer', 'isFrame', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '7', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('20', '2', 'menu_type', '菜单类型（M目录 C菜单 F按钮）', 'char(1)', 'String', 'menuType', '0', '0', null, '1', '1', '1', '1', 'EQ', 'select', '', '8', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('21', '2', 'visible', '菜单状态（0显示 1隐藏）', 'char(1)', 'String', 'visible', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '9', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('22', '2', 'status', '菜单状态（0正常 1停用）', 'char(1)', 'String', 'status', '0', '0', null, '1', '1', '1', '1', 'EQ', 'radio', '', '10', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('23', '2', 'perms', '权限标识', 'varchar(100)', 'String', 'perms', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '11', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('24', '2', 'icon', '菜单图标', 'varchar(100)', 'String', 'icon', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '12', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('25', '2', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', null, '1', null, null, null, 'EQ', 'input', '', '13', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('26', '2', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', null, '1', null, null, null, 'EQ', 'datetime', '', '14', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('27', '2', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', null, '1', '1', null, null, 'EQ', 'input', '', '15', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('28', '2', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', null, '1', '1', null, null, 'EQ', 'datetime', '', '16', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('29', '2', 'remark', '备注', 'varchar(500)', 'String', 'remark', '0', '0', null, '1', '1', '1', null, 'EQ', 'textarea', '', '17', '', '2020-07-01 19:59:42', '', null, '');
INSERT INTO `gen_table_column` VALUES ('30', '3', 'config_id', '参数主键', 'int(5)', 'Integer', 'configId', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:42:18', '', null, '');
INSERT INTO `gen_table_column` VALUES ('31', '3', 'config_name', '参数名称', 'varchar(100)', 'String', 'configName', '0', '0', null, '1', '1', '1', '1', 'LIKE', 'input', '', '2', '', '2020-07-02 10:42:18', '', null, '');
INSERT INTO `gen_table_column` VALUES ('32', '3', 'config_key', '参数键名', 'varchar(100)', 'String', 'configKey', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '3', '', '2020-07-02 10:42:18', '', null, '');
INSERT INTO `gen_table_column` VALUES ('33', '3', 'config_value', '参数键值', 'varchar(500)', 'String', 'configValue', '0', '0', null, '1', '1', '1', '1', 'EQ', 'textarea', '', '4', '', '2020-07-02 10:42:18', '', null, '');
INSERT INTO `gen_table_column` VALUES ('34', '3', 'config_type', '系统内置（Y是 N否）', 'char(1)', 'String', 'configType', '0', '0', null, '1', '1', '1', '1', 'EQ', 'select', '', '5', '', '2020-07-02 10:42:18', '', null, '');
INSERT INTO `gen_table_column` VALUES ('35', '3', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', null, '1', null, null, null, 'EQ', 'input', '', '6', '', '2020-07-02 10:42:18', '', null, '');
INSERT INTO `gen_table_column` VALUES ('36', '3', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', null, '1', null, null, null, 'EQ', 'datetime', '', '7', '', '2020-07-02 10:42:18', '', null, '');
INSERT INTO `gen_table_column` VALUES ('37', '3', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', null, '1', '1', null, null, 'EQ', 'input', '', '8', '', '2020-07-02 10:42:18', '', null, '');
INSERT INTO `gen_table_column` VALUES ('38', '3', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', null, '1', '1', null, null, 'EQ', 'datetime', '', '9', '', '2020-07-02 10:42:18', '', null, '');
INSERT INTO `gen_table_column` VALUES ('39', '3', 'remark', '备注', 'varchar(500)', 'String', 'remark', '0', '0', null, '1', '1', '1', null, 'EQ', 'textarea', '', '10', '', '2020-07-02 10:42:18', '', null, '');
INSERT INTO `gen_table_column` VALUES ('50', '4', 'dept_id', '部门id', 'bigint(20)', 'Long', 'deptId', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('51', '4', 'parent_id', '父部门id', 'bigint(20)', 'Long', 'parentId', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '2', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('52', '4', 'ancestors', '祖级列表', 'varchar(50)', 'String', 'ancestors', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '3', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('53', '4', 'dept_name', '部门名称', 'varchar(30)', 'String', 'deptName', '0', '0', null, '1', '1', '1', '1', 'LIKE', 'input', '', '4', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('54', '4', 'order_num', '显示顺序', 'int(4)', 'Integer', 'orderNum', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '5', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('55', '4', 'leader', '负责人', 'varchar(20)', 'String', 'leader', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '6', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('56', '4', 'phone', '联系电话', 'varchar(11)', 'String', 'phone', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '7', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('57', '4', 'email', '邮箱', 'varchar(50)', 'String', 'email', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '8', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('58', '4', 'status', '部门状态（0正常 1停用）', 'char(1)', 'String', 'status', '0', '0', null, '1', '1', '1', '1', 'EQ', 'radio', '', '9', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('59', '4', 'del_flag', '删除标志（0代表存在 2代表删除）', 'char(1)', 'String', 'delFlag', '0', '0', null, '1', null, null, null, 'EQ', 'input', '', '10', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('60', '4', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', null, '1', null, null, null, 'EQ', 'input', '', '11', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('61', '4', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', null, '1', null, null, null, 'EQ', 'datetime', '', '12', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('62', '4', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', null, '1', '1', null, null, 'EQ', 'input', '', '13', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('63', '4', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', null, '1', '1', null, null, 'EQ', 'datetime', '', '14', '', '2020-07-02 10:45:29', '', null, '');
INSERT INTO `gen_table_column` VALUES ('64', '6', 'dict_code', '字典编码', 'bigint(20)', 'Long', 'dictCode', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('65', '6', 'dict_sort', '字典排序', 'int(4)', 'Integer', 'dictSort', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '2', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('66', '6', 'dict_label', '字典标签', 'varchar(100)', 'String', 'dictLabel', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '3', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('67', '6', 'dict_value', '字典键值', 'varchar(100)', 'String', 'dictValue', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '4', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('68', '6', 'dict_type', '字典类型', 'varchar(100)', 'String', 'dictType', '0', '0', null, '1', '1', '1', '1', 'EQ', 'select', '', '5', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('69', '6', 'css_class', '样式属性（其他样式扩展）', 'varchar(100)', 'String', 'cssClass', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '6', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('70', '6', 'list_class', '表格回显样式', 'varchar(100)', 'String', 'listClass', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '7', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('71', '6', 'is_default', '是否默认（Y是 N否）', 'char(1)', 'String', 'isDefault', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '8', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('72', '6', 'status', '状态（0正常 1停用）', 'char(1)', 'String', 'status', '0', '0', null, '1', '1', '1', '1', 'EQ', 'radio', '', '9', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('73', '6', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', null, '1', null, null, null, 'EQ', 'input', '', '10', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('74', '6', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', null, '1', null, null, null, 'EQ', 'datetime', '', '11', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('75', '6', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', null, '1', '1', null, null, 'EQ', 'input', '', '12', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('76', '6', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', null, '1', '1', null, null, 'EQ', 'datetime', '', '13', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('77', '6', 'remark', '备注', 'varchar(500)', 'String', 'remark', '0', '0', null, '1', '1', '1', null, 'EQ', 'textarea', '', '14', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('78', '7', 'dict_id', '字典主键', 'bigint(20)', 'Long', 'dictId', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('79', '7', 'dict_name', '字典名称', 'varchar(100)', 'String', 'dictName', '0', '0', null, '1', '1', '1', '1', 'LIKE', 'input', '', '2', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('80', '7', 'dict_type', '字典类型', 'varchar(100)', 'String', 'dictType', '0', '0', null, '1', '1', '1', '1', 'EQ', 'select', '', '3', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('81', '7', 'status', '状态（0正常 1停用）', 'char(1)', 'String', 'status', '0', '0', null, '1', '1', '1', '1', 'EQ', 'radio', '', '4', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('82', '7', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', null, '1', null, null, null, 'EQ', 'input', '', '5', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('83', '7', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', null, '1', null, null, null, 'EQ', 'datetime', '', '6', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('84', '7', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', null, '1', '1', null, null, 'EQ', 'input', '', '7', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('85', '7', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', null, '1', '1', null, null, 'EQ', 'datetime', '', '8', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('86', '7', 'remark', '备注', 'varchar(500)', 'String', 'remark', '0', '0', null, '1', '1', '1', null, 'EQ', 'textarea', '', '9', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('87', '8', 'job_id', '任务ID', 'bigint(20)', 'Long', 'jobId', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('88', '8', 'job_name', '任务名称', 'varchar(64)', 'String', 'jobName', '1', '0', null, '1', null, null, null, 'LIKE', 'input', '', '2', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('89', '8', 'job_group', '任务组名', 'varchar(64)', 'String', 'jobGroup', '1', '0', null, '1', null, null, null, 'EQ', 'input', '', '3', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('90', '8', 'invoke_target', '调用目标字符串', 'varchar(500)', 'String', 'invokeTarget', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'textarea', '', '4', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('91', '8', 'cron_expression', 'cron执行表达式', 'varchar(255)', 'String', 'cronExpression', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '5', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('92', '8', 'misfire_policy', '计划执行错误策略（1立即执行 2执行一次 3放弃执行）', 'varchar(20)', 'String', 'misfirePolicy', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '6', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('93', '8', 'concurrent', '是否并发执行（0允许 1禁止）', 'char(1)', 'String', 'concurrent', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '7', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('94', '8', 'status', '状态（0正常 1暂停）', 'char(1)', 'String', 'status', '0', '0', null, '1', '1', '1', '1', 'EQ', 'radio', '', '8', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('95', '8', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', null, '1', null, null, null, 'EQ', 'input', '', '9', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('96', '8', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', null, '1', null, null, null, 'EQ', 'datetime', '', '10', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('97', '8', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', null, '1', '1', null, null, 'EQ', 'input', '', '11', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('98', '8', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', null, '1', '1', null, null, 'EQ', 'datetime', '', '12', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('99', '8', 'remark', '备注信息', 'varchar(500)', 'String', 'remark', '0', '0', null, '1', '1', '1', null, 'EQ', 'textarea', '', '13', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('100', '9', 'job_log_id', '任务日志ID', 'bigint(20)', 'Long', 'jobLogId', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('101', '9', 'job_name', '任务名称', 'varchar(64)', 'String', 'jobName', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', '2', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('102', '9', 'job_group', '任务组名', 'varchar(64)', 'String', 'jobGroup', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', '3', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('103', '9', 'invoke_target', '调用目标字符串', 'varchar(500)', 'String', 'invokeTarget', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'textarea', '', '4', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('104', '9', 'job_message', '日志信息', 'varchar(500)', 'String', 'jobMessage', '0', '0', null, '1', '1', '1', '1', 'EQ', 'textarea', '', '5', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('105', '9', 'status', '执行状态（0正常 1失败）', 'char(1)', 'String', 'status', '0', '0', null, '1', '1', '1', '1', 'EQ', 'radio', '', '6', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('106', '9', 'exception_info', '异常信息', 'varchar(2000)', 'String', 'exceptionInfo', '0', '0', null, '1', '1', '1', '1', 'EQ', 'textarea', '', '7', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('107', '9', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', null, '1', null, null, null, 'EQ', 'datetime', '', '8', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('108', '10', 'info_id', '访问ID', 'bigint(20)', 'Long', 'infoId', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('109', '10', 'user_name', '用户账号', 'varchar(50)', 'String', 'userName', '0', '0', null, '1', '1', '1', '1', 'LIKE', 'input', '', '2', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('110', '10', 'ipaddr', '登录IP地址', 'varchar(50)', 'String', 'ipaddr', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '3', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('111', '10', 'status', '登录状态（0成功 1失败）', 'char(1)', 'String', 'status', '0', '0', null, '1', '1', '1', '1', 'EQ', 'radio', '', '4', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('112', '10', 'msg', '提示信息', 'varchar(255)', 'String', 'msg', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '5', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('113', '10', 'access_time', '访问时间', 'datetime', 'Date', 'accessTime', '0', '0', null, '1', '1', '1', '1', 'EQ', 'datetime', '', '6', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('114', '11', 'notice_id', '公告ID', 'int(4)', 'Integer', 'noticeId', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('115', '11', 'notice_title', '公告标题', 'varchar(50)', 'String', 'noticeTitle', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', '2', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('116', '11', 'notice_type', '公告类型（1通知 2公告）', 'char(1)', 'String', 'noticeType', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'select', '', '3', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('117', '11', 'notice_content', '公告内容', 'varchar(2000)', 'String', 'noticeContent', '0', '0', null, '1', '1', '1', '1', 'EQ', 'textarea', '', '4', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('118', '11', 'status', '公告状态（0正常 1关闭）', 'char(1)', 'String', 'status', '0', '0', null, '1', '1', '1', '1', 'EQ', 'radio', '', '5', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('119', '11', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', null, '1', null, null, null, 'EQ', 'input', '', '6', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('120', '11', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', null, '1', null, null, null, 'EQ', 'datetime', '', '7', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('121', '11', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', null, '1', '1', null, null, 'EQ', 'input', '', '8', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('122', '11', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', null, '1', '1', null, null, 'EQ', 'datetime', '', '9', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('123', '11', 'remark', '备注', 'varchar(255)', 'String', 'remark', '0', '0', null, '1', '1', '1', null, 'EQ', 'input', '', '10', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('124', '12', 'oper_id', '日志主键', 'bigint(20)', 'Long', 'operId', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('125', '12', 'title', '模块标题', 'varchar(50)', 'String', 'title', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '2', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('126', '12', 'business_type', '业务类型（0其它 1新增 2修改 3删除）', 'int(2)', 'Integer', 'businessType', '0', '0', null, '1', '1', '1', '1', 'EQ', 'select', '', '3', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('127', '12', 'method', '方法名称', 'varchar(100)', 'String', 'method', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '4', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('128', '12', 'request_method', '请求方式', 'varchar(10)', 'String', 'requestMethod', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '5', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('129', '12', 'operator_type', '操作类别（0其它 1后台用户 2手机端用户）', 'int(1)', 'Integer', 'operatorType', '0', '0', null, '1', '1', '1', '1', 'EQ', 'select', '', '6', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('130', '12', 'oper_name', '操作人员', 'varchar(50)', 'String', 'operName', '0', '0', null, '1', '1', '1', '1', 'LIKE', 'input', '', '7', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('131', '12', 'dept_name', '部门名称', 'varchar(50)', 'String', 'deptName', '0', '0', null, '1', '1', '1', '1', 'LIKE', 'input', '', '8', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('132', '12', 'oper_url', '请求URL', 'varchar(255)', 'String', 'operUrl', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '9', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('133', '12', 'oper_ip', '主机地址', 'varchar(50)', 'String', 'operIp', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '10', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('134', '12', 'oper_location', '操作地点', 'varchar(255)', 'String', 'operLocation', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '11', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('135', '12', 'oper_param', '请求参数', 'varchar(2000)', 'String', 'operParam', '0', '0', null, '1', '1', '1', '1', 'EQ', 'textarea', '', '12', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('136', '12', 'json_result', '返回参数', 'varchar(2000)', 'String', 'jsonResult', '0', '0', null, '1', '1', '1', '1', 'EQ', 'textarea', '', '13', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('137', '12', 'status', '操作状态（0正常 1异常）', 'int(1)', 'Integer', 'status', '0', '0', null, '1', '1', '1', '1', 'EQ', 'radio', '', '14', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('138', '12', 'error_msg', '错误消息', 'varchar(2000)', 'String', 'errorMsg', '0', '0', null, '1', '1', '1', '1', 'EQ', 'textarea', '', '15', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('139', '12', 'oper_time', '操作时间', 'datetime', 'Date', 'operTime', '0', '0', null, '1', '1', '1', '1', 'EQ', 'datetime', '', '16', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('140', '13', 'post_id', '岗位ID', 'bigint(20)', 'Long', 'postId', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('141', '13', 'post_code', '岗位编码', 'varchar(64)', 'String', 'postCode', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', '2', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('142', '13', 'post_name', '岗位名称', 'varchar(50)', 'String', 'postName', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', '3', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('143', '13', 'post_sort', '显示顺序', 'int(4)', 'Integer', 'postSort', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', '4', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('144', '13', 'status', '状态（0正常 1停用）', 'char(1)', 'String', 'status', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'radio', '', '5', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('145', '13', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', null, '1', null, null, null, 'EQ', 'input', '', '6', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('146', '13', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', null, '1', null, null, null, 'EQ', 'datetime', '', '7', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('147', '13', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', null, '1', '1', null, null, 'EQ', 'input', '', '8', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('148', '13', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', null, '1', '1', null, null, 'EQ', 'datetime', '', '9', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('149', '13', 'remark', '备注', 'varchar(500)', 'String', 'remark', '0', '0', null, '1', '1', '1', null, 'EQ', 'textarea', '', '10', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('150', '14', 'role_id', '角色ID', 'bigint(20)', 'Long', 'roleId', '1', '0', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('151', '14', 'dept_id', '部门ID', 'bigint(20)', 'Long', 'deptId', '1', '0', null, '1', null, null, null, 'EQ', 'input', '', '2', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('152', '15', 'role_id', '角色ID', 'bigint(20)', 'Long', 'roleId', '1', '0', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('153', '15', 'menu_id', '菜单ID', 'bigint(20)', 'Long', 'menuId', '1', '0', null, '1', null, null, null, 'EQ', 'input', '', '2', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('154', '16', 'user_id', '用户ID', 'bigint(20)', 'Long', 'userId', '1', '0', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('155', '16', 'post_id', '岗位ID', 'bigint(20)', 'Long', 'postId', '1', '0', null, '1', null, null, null, 'EQ', 'input', '', '2', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('156', '17', 'user_id', '用户ID', 'bigint(20)', 'Long', 'userId', '1', '0', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('157', '17', 'role_id', '角色ID', 'bigint(20)', 'Long', 'roleId', '1', '0', null, '1', null, null, null, 'EQ', 'input', '', '2', '', '2020-07-02 10:48:33', '', null, '');
INSERT INTO `gen_table_column` VALUES ('158', '18', 'memid', '用户id', 'bigint(20)', 'Long', 'memid', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('159', '18', 'accno', '会员标识号', 'varchar(32)', 'String', 'accno', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '2', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('160', '18', 'nick_name', '呢称', 'varchar(100)', 'String', 'nickName', '0', '0', null, '1', '1', '1', '1', 'LIKE', 'input', '', '3', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('161', '18', 'mem_name', '真实姓名', 'varchar(20)', 'String', 'memName', '0', '0', null, '1', '1', '1', '1', 'LIKE', 'input', '', '4', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('162', '18', 'mobile', '手机号码', 'varchar(15)', 'String', 'mobile', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '5', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('163', '18', 'sex', '性别 1男 2女 4保密', 'decimal(1,0)', 'Long', 'sex', '0', '0', null, '1', '1', '1', '1', 'EQ', 'select', '', '6', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('164', '18', 'idcard_type', '证件类型DDINFO', 'varchar(20)', 'String', 'idcardType', '0', '0', null, '1', '1', '1', '1', 'EQ', 'select', '', '7', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('165', '18', 'idcard_no', '证件号码', 'varchar(40)', 'String', 'idcardNo', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '8', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('166', '18', 'idcard_front', '证件照片正面', 'varchar(400)', 'String', 'idcardFront', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '9', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('167', '18', 'idcard_back', '证件照片反面', 'varchar(400)', 'String', 'idcardBack', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '10', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('168', '18', 'birthday', '出生日期', 'date', 'Date', 'birthday', '0', '0', null, '1', '1', '1', '1', 'EQ', 'datetime', '', '11', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('169', '18', 'nationality', '国籍DDINFO', 'varchar(20)', 'String', 'nationality', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '12', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('170', '18', 'headimg', '头像', 'varchar(64)', 'String', 'headimg', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '13', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('171', '18', 'registerdate', '注册日期', 'datetime', 'Date', 'registerdate', '0', '0', null, '1', '1', '1', '1', 'EQ', 'datetime', '', '14', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('172', '18', 'recomcode', '推荐码', 'varchar(6)', 'String', 'recomcode', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '15', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('173', '18', 'describes', '描述', 'varchar(100)', 'String', 'describes', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '16', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('174', '18', 'tag', '登录地址城市', 'varchar(100)', 'String', 'tag', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '17', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('175', '18', 'logincountry', '登录国家', 'varchar(100)', 'String', 'logincountry', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '18', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('176', '18', 'memfeatures', '会员特征(兴趣)', 'varchar(32)', 'String', 'memfeatures', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '19', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('177', '18', 'memorgin', '来源 recommend推荐  regist注册  operator运营人员', 'varchar(20)', 'String', 'memorgin', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '20', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('178', '18', 'fansnum', '粉丝数量', 'bigint(20)', 'Long', 'fansnum', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '21', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('179', '18', 'goldnum', '用户乐币数量', 'decimal(16,3)', 'Double', 'goldnum', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '22', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('180', '18', 'sitearea', '所在地(省市区)12位區域編碼code', 'varchar(20)', 'String', 'sitearea', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '23', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('181', '18', 'wechat', '微信号', 'varchar(50)', 'String', 'wechat', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '24', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('182', '18', 'chatnick_name', '微信昵称', 'varchar(100)', 'String', 'chatnickName', '0', '0', null, '1', '1', '1', '1', 'LIKE', 'input', '', '25', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('183', '18', 'delete', '删除标志 0或空未删除 1已删除', 'tinyint(1)', 'Integer', 'delete', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '26', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('184', '18', 'create_user', '创建人', 'varchar(32)', 'String', 'createUser', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '27', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('185', '18', 'create_date', '创建时间', 'datetime', 'Date', 'createDate', '0', '0', null, '1', '1', '1', '1', 'EQ', 'datetime', '', '28', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('186', '18', 'modify_user', '最后修改人', 'varchar(32)', 'String', 'modifyUser', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '29', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('187', '18', 'modify_date', '最后修改时间', 'datetime', 'Date', 'modifyDate', '0', '0', null, '1', '1', '1', '1', 'EQ', 'datetime', '', '30', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('188', '19', 'id', '用户id', 'bigint(20)', 'Long', 'id', '1', '1', null, '1', null, null, null, 'EQ', 'input', '', '1', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('189', '19', 'accno', '会员标识号', 'varchar(32)', 'String', 'accno', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', '2', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('190', '19', 'loginname', '登录账号(登录用)', 'varchar(100)', 'String', 'loginname', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', '3', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('191', '19', 'password', '登陆密码', 'varchar(64)', 'String', 'password', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '4', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('192', '19', 'login_type', '账户类型  普通会员1      主播2   家族長3  代充人4  运营后台管理员8    第三方登录7   服務註冊中心管理員9  聚合站点后台管理员10', 'int(2)', 'Integer', 'loginType', '0', '0', null, '1', '1', '1', '1', 'EQ', 'select', '', '5', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('193', '19', 'pay_password', '支付密码md5', 'varchar(64)', 'String', 'payPassword', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '6', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('194', '19', 'status', '账号状态 1正常 0禁止登陆 ', 'tinyint(1)', 'Integer', 'status', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'radio', '', '7', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('195', '19', 'last_login_time', '最后登录时间', 'datetime', 'Date', 'lastLoginTime', '0', '0', null, '1', '1', '1', '1', 'EQ', 'datetime', '', '8', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('196', '19', 'login_num', '登录总次数', 'int(11)', 'Long', 'loginNum', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '9', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('197', '19', 'client_ip', '登录ip地址', 'varchar(20)', 'String', 'clientIp', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '10', '', '2020-07-02 10:49:48', '', null, '');
INSERT INTO `gen_table_column` VALUES ('198', '19', 'google_secret_key', '谷歌令牌密钥', 'varchar(128)', 'String', 'googleSecretKey', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '11', '', '2020-07-02 10:49:48', '', null, '');

-- ----------------------------
-- Table structure for mem_baseinfo
-- ----------------------------
DROP TABLE IF EXISTS `mem_baseinfo`;
CREATE TABLE `mem_baseinfo` (
  `memid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `accno` varchar(32) DEFAULT NULL COMMENT '会员标识号',
  `nick_name` varchar(100) DEFAULT NULL COMMENT '呢称',
  `mem_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `sex` decimal(1,0) DEFAULT NULL COMMENT '性别 1男 2女 4保密',
  `idcard_type` varchar(20) DEFAULT NULL COMMENT '证件类型DDINFO',
  `idcard_no` varchar(40) DEFAULT NULL COMMENT '证件号码',
  `idcard_front` varchar(400) DEFAULT NULL COMMENT '证件照片正面',
  `idcard_back` varchar(400) DEFAULT NULL COMMENT '证件照片反面',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `nationality` varchar(20) DEFAULT NULL COMMENT '国籍DDINFO',
  `headimg` varchar(64) DEFAULT NULL COMMENT '头像',
  `registerdate` datetime DEFAULT NULL COMMENT '注册日期',
  `recomcode` varchar(6) DEFAULT NULL COMMENT '推荐码',
  `describes` varchar(100) DEFAULT NULL COMMENT '描述',
  `tag` varchar(100) DEFAULT NULL COMMENT '登录地址城市',
  `logincountry` varchar(100) DEFAULT NULL COMMENT '登录国家',
  `memfeatures` varchar(32) DEFAULT NULL COMMENT '会员特征(兴趣)',
  `memorgin` varchar(20) DEFAULT NULL COMMENT '来源 recommend推荐  regist注册  operator运营人员',
  `fansnum` bigint(20) DEFAULT NULL COMMENT '粉丝数量',
  `goldnum` decimal(16,3) DEFAULT NULL COMMENT '用户乐币数量',
  `sitearea` varchar(20) DEFAULT NULL COMMENT '所在地(省市区)12位區域編碼code',
  `wechat` varchar(50) DEFAULT NULL COMMENT '微信号',
  `chatnick_name` varchar(100) DEFAULT NULL COMMENT '微信昵称',
  `delete` tinyint(1) DEFAULT NULL COMMENT '删除标志 0或空未删除 1已删除',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_user` varchar(32) DEFAULT NULL COMMENT '最后修改人',
  `modify_date` datetime DEFAULT NULL COMMENT '最后修改时间',
  `tenant_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '租户id',
  PRIMARY KEY (`memid`) USING BTREE,
  UNIQUE KEY `i_accno` (`accno`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='会员基本信息';

-- ----------------------------
-- Records of mem_baseinfo
-- ----------------------------

-- ----------------------------
-- Table structure for mem_login
-- ----------------------------
DROP TABLE IF EXISTS `mem_login`;
CREATE TABLE `mem_login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `accno` varchar(32) NOT NULL COMMENT '会员标识号',
  `loginname` varchar(100) NOT NULL COMMENT '登录账号(登录用)',
  `password` varchar(64) DEFAULT NULL COMMENT '登陆密码',
  `login_type` int(2) DEFAULT NULL COMMENT '账户类型  普通会员1      主播2   家族長3  代充人4  运营后台管理员8    第三方登录7   服務註冊中心管理員9  聚合站点后台管理员10',
  `pay_password` varchar(64) DEFAULT NULL COMMENT '支付密码md5',
  `status` tinyint(1) NOT NULL COMMENT '账号状态 1正常 0禁止登陆 ',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `login_num` int(11) DEFAULT NULL COMMENT '登录总次数',
  `client_ip` varchar(20) DEFAULT NULL COMMENT '登录ip地址',
  `google_secret_key` varchar(128) DEFAULT NULL COMMENT '谷歌令牌密钥',
  `tenant_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '租户id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `i_loginacc` (`loginname`,`login_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='会员登录账号';

-- ----------------------------
-- Records of mem_login
-- ----------------------------
INSERT INTO `mem_login` VALUES ('1', '454332dffdfaad65543443', 'admin', '$2a$10$7jUnHQnnnmA94L5KxJNbzOYhBuu6yirfb0wcFu38ldD6HaCJYPzIu', '8', null, '1', null, null, null, null, '');

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `resource_ids` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `client_secret` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `scope` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `authorized_grant_types` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `web_server_redirect_uri` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `authorities` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) COLLATE utf8_unicode_ci DEFAULT NULL,
  `autoapprove` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('client-a', '', '{noop}client-a-secret', 'all', 'authorization_code,password,refresh_token', 'http://localhost:9001/callback', '', '7200', '86400', '', 'true');
INSERT INTO `oauth_client_details` VALUES ('gatewayClient', null, '$2a$10$7jUnHQnnnmA94L5KxJNbzOYhBuu6yirfb0wcFu38ldD6HaCJYPzIu', 'all', 'authorization_code,password,refresh_token', '', null, '7200', '86400', null, 'true');
INSERT INTO `oauth_client_details` VALUES ('web', null, '$2a$10$7jUnHQnnnmA94L5KxJNbzOYhBuu6yirfb0wcFu38ldD6HaCJYPzIu', 'all', 'authorization_code,password,refresh_token', null, null, '7200', '86400', null, null);
INSERT INTO `oauth_client_details` VALUES ('webclientId', '', '$2a$10$7jUnHQnnnmA94L5KxJNbzOYhBuu6yirfb0wcFu38ldD6HaCJYPzIu', 'all', 'authorization_code,password,refresh_token', 'https://www.baidu.com', '', '7200', '86400', null, 'true');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES ('2', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '初始化密码 123456');
INSERT INTO `sys_config` VALUES ('3', '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '深色主题theme-dark，浅色主题theme-light');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `tenant_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '租户id',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('100', '0', '0', '若依科技', '0', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dept` VALUES ('101', '100', '0,100', '深圳总公司', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dept` VALUES ('102', '100', '0,100', '长沙分公司', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dept` VALUES ('103', '101', '0,100,101', '研发部门', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dept` VALUES ('104', '101', '0,100,101', '市场部门', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dept` VALUES ('105', '101', '0,100,101', '测试部门', '3', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dept` VALUES ('106', '101', '0,100,101', '财务部门', '4', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dept` VALUES ('107', '101', '0,100,101', '运维部门', '5', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dept` VALUES ('108', '102', '0,100,102', '市场部门', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dept` VALUES ('109', '102', '0,100,102', '财务部门', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `tenant_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '租户id',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES ('1', '1', '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别男', '');
INSERT INTO `sys_dict_data` VALUES ('2', '2', '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别女', '');
INSERT INTO `sys_dict_data` VALUES ('3', '3', '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别未知', '');
INSERT INTO `sys_dict_data` VALUES ('4', '1', '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '显示菜单', '');
INSERT INTO `sys_dict_data` VALUES ('5', '2', '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '隐藏菜单', '');
INSERT INTO `sys_dict_data` VALUES ('6', '1', '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态', '');
INSERT INTO `sys_dict_data` VALUES ('7', '2', '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态', '');
INSERT INTO `sys_dict_data` VALUES ('8', '1', '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态', '');
INSERT INTO `sys_dict_data` VALUES ('9', '2', '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态', '');
INSERT INTO `sys_dict_data` VALUES ('10', '1', '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '默认分组', '');
INSERT INTO `sys_dict_data` VALUES ('11', '2', '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统分组', '');
INSERT INTO `sys_dict_data` VALUES ('12', '1', '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认是', '');
INSERT INTO `sys_dict_data` VALUES ('13', '2', '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认否', '');
INSERT INTO `sys_dict_data` VALUES ('14', '1', '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知', '');
INSERT INTO `sys_dict_data` VALUES ('15', '2', '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '公告', '');
INSERT INTO `sys_dict_data` VALUES ('16', '1', '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态', '');
INSERT INTO `sys_dict_data` VALUES ('17', '2', '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '关闭状态', '');
INSERT INTO `sys_dict_data` VALUES ('18', '1', '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作', '');
INSERT INTO `sys_dict_data` VALUES ('19', '2', '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '修改操作', '');
INSERT INTO `sys_dict_data` VALUES ('20', '3', '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '删除操作', '');
INSERT INTO `sys_dict_data` VALUES ('21', '4', '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '授权操作', '');
INSERT INTO `sys_dict_data` VALUES ('22', '5', '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导出操作', '');
INSERT INTO `sys_dict_data` VALUES ('23', '6', '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导入操作', '');
INSERT INTO `sys_dict_data` VALUES ('24', '7', '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '强退操作', '');
INSERT INTO `sys_dict_data` VALUES ('25', '8', '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '生成操作', '');
INSERT INTO `sys_dict_data` VALUES ('26', '9', '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '清空操作', '');
INSERT INTO `sys_dict_data` VALUES ('27', '1', '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态', '');
INSERT INTO `sys_dict_data` VALUES ('28', '2', '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态', '');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `tenant_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '租户id',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1', '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户性别列表', '');
INSERT INTO `sys_dict_type` VALUES ('2', '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单状态列表', '');
INSERT INTO `sys_dict_type` VALUES ('3', '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统开关列表', '');
INSERT INTO `sys_dict_type` VALUES ('4', '任务状态', 'sys_job_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务状态列表', '');
INSERT INTO `sys_dict_type` VALUES ('5', '任务分组', 'sys_job_group', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务分组列表', '');
INSERT INTO `sys_dict_type` VALUES ('6', '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统是否列表', '');
INSERT INTO `sys_dict_type` VALUES ('7', '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知类型列表', '');
INSERT INTO `sys_dict_type` VALUES ('8', '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知状态列表', '');
INSERT INTO `sys_dict_type` VALUES ('9', '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作类型列表', '');
INSERT INTO `sys_dict_type` VALUES ('10', '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录状态列表', '');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='定时任务调度表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('1', '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_job` VALUES ('2', '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_job` VALUES ('3', '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log` (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor` (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示信息',
  `access_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `is_frame` int(1) DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1063 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '1', 'system', null, '1', 'M', '0', '0', '', 'system', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统管理目录');
INSERT INTO `sys_menu` VALUES ('2', '系统监控', '0', '2', 'monitor', null, '1', 'M', '0', '0', '', 'monitor', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统监控目录');
INSERT INTO `sys_menu` VALUES ('3', '系统工具', '0', '3', 'tool', null, '1', 'M', '0', '0', '', 'tool', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统工具目录');
INSERT INTO `sys_menu` VALUES ('4', '若依官网', '0', '4', 'http://ruoyi.vip', null, '0', 'M', '0', '0', '', 'guide', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '若依官网地址');
INSERT INTO `sys_menu` VALUES ('100', '用户管理', '1', '1', 'user', 'system/user/index', '1', 'C', '0', '0', 'system:user:list', 'user', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES ('101', '角色管理', '1', '2', 'role', 'system/role/index', '1', 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `sys_menu` VALUES ('102', '菜单管理', '1', '3', 'menu', 'system/menu/index', '1', 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `sys_menu` VALUES ('103', '部门管理', '1', '4', 'dept', 'system/dept/index', '1', 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '部门管理菜单');
INSERT INTO `sys_menu` VALUES ('104', '岗位管理', '1', '5', 'post', 'system/post/index', '1', 'C', '0', '0', 'system:post:list', 'post', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '岗位管理菜单');
INSERT INTO `sys_menu` VALUES ('105', '字典管理', '1', '6', 'dict', 'system/dict/index', '1', 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `sys_menu` VALUES ('106', '参数设置', '1', '7', 'config', 'system/config/index', '1', 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '参数设置菜单');
INSERT INTO `sys_menu` VALUES ('107', '终端设置', '1', '8', 'client', 'system/client/index', '1', 'C', '0', '0', 'system:client:list', 'client', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '终端设置菜单');
INSERT INTO `sys_menu` VALUES ('108', '通知公告', '1', '9', 'notice', 'system/notice/index', '1', 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知公告菜单');
INSERT INTO `sys_menu` VALUES ('109', '日志管理', '1', '10', 'log', 'system/log/index', '1', 'M', '0', '0', '', 'log', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '日志管理菜单');
INSERT INTO `sys_menu` VALUES ('110', '定时任务', '2', '1', 'job', 'monitor/job/index', '1', 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `sys_menu` VALUES ('111', 'Sentinel控制台', '2', '2', 'http://localhost:8718', '', '1', 'C', '0', '0', 'monitor:sentinel:list', 'sentinel', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '流量控制菜单');
INSERT INTO `sys_menu` VALUES ('112', 'Nacos控制台', '2', '3', 'http://localhost:8848/nacos', '', '1', 'C', '0', '0', 'monitor:nacos:list', 'nacos', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '服务治理菜单');
INSERT INTO `sys_menu` VALUES ('113', 'Admin控制台', '2', '4', 'http://localhost:9100/login', '', '1', 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '服务监控菜单');
INSERT INTO `sys_menu` VALUES ('114', '表单构建', '3', '1', 'build', 'tool/build/index', '1', 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '表单构建菜单');
INSERT INTO `sys_menu` VALUES ('115', '代码生成', '3', '2', 'gen', 'tool/gen/index', '1', 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '代码生成菜单');
INSERT INTO `sys_menu` VALUES ('116', '系统接口', '3', '3', 'http://localhost:8080/swagger-ui.html', '', '1', 'C', '0', '0', 'tool:swagger:list', 'swagger', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统接口菜单');
INSERT INTO `sys_menu` VALUES ('500', '操作日志', '109', '1', 'operlog', 'system/operlog/index', '1', 'C', '0', '0', 'system:operlog:list', 'form', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作日志菜单');
INSERT INTO `sys_menu` VALUES ('501', '登录日志', '109', '2', 'logininfor', 'system/logininfor/index', '1', 'C', '0', '0', 'system:logininfor:list', 'logininfor', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录日志菜单');
INSERT INTO `sys_menu` VALUES ('1001', '用户查询', '100', '1', '', '', '1', 'F', '0', '0', 'system:user:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1002', '用户新增', '100', '2', '', '', '1', 'F', '0', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1003', '用户修改', '100', '3', '', '', '1', 'F', '0', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1004', '用户删除', '100', '4', '', '', '1', 'F', '0', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1005', '用户导出', '100', '5', '', '', '1', 'F', '0', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1006', '用户导入', '100', '6', '', '', '1', 'F', '0', '0', 'system:user:import', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1007', '重置密码', '100', '7', '', '', '1', 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1008', '角色查询', '101', '1', '', '', '1', 'F', '0', '0', 'system:role:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1009', '角色新增', '101', '2', '', '', '1', 'F', '0', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1010', '角色修改', '101', '3', '', '', '1', 'F', '0', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1011', '角色删除', '101', '4', '', '', '1', 'F', '0', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1012', '角色导出', '101', '5', '', '', '1', 'F', '0', '0', 'system:role:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1013', '菜单查询', '102', '1', '', '', '1', 'F', '0', '0', 'system:menu:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1014', '菜单新增', '102', '2', '', '', '1', 'F', '0', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1015', '菜单修改', '102', '3', '', '', '1', 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1016', '菜单删除', '102', '4', '', '', '1', 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1017', '部门查询', '103', '1', '', '', '1', 'F', '0', '0', 'system:dept:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1018', '部门新增', '103', '2', '', '', '1', 'F', '0', '0', 'system:dept:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1019', '部门修改', '103', '3', '', '', '1', 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1020', '部门删除', '103', '4', '', '', '1', 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1021', '岗位查询', '104', '1', '', '', '1', 'F', '0', '0', 'system:post:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1022', '岗位新增', '104', '2', '', '', '1', 'F', '0', '0', 'system:post:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1023', '岗位修改', '104', '3', '', '', '1', 'F', '0', '0', 'system:post:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1024', '岗位删除', '104', '4', '', '', '1', 'F', '0', '0', 'system:post:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1025', '岗位导出', '104', '5', '', '', '1', 'F', '0', '0', 'system:post:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1026', '字典查询', '105', '1', '#', '', '1', 'F', '0', '0', 'system:dict:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1027', '字典新增', '105', '2', '#', '', '1', 'F', '0', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1028', '字典修改', '105', '3', '#', '', '1', 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1029', '字典删除', '105', '4', '#', '', '1', 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1030', '字典导出', '105', '5', '#', '', '1', 'F', '0', '0', 'system:dict:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1031', '参数查询', '106', '1', '#', '', '1', 'F', '0', '0', 'system:config:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1032', '参数新增', '106', '2', '#', '', '1', 'F', '0', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1033', '参数修改', '106', '3', '#', '', '1', 'F', '0', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1034', '参数删除', '106', '4', '#', '', '1', 'F', '0', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1035', '参数导出', '106', '5', '#', '', '1', 'F', '0', '0', 'system:config:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1036', '终端查询', '107', '1', '#', '', '1', 'F', '0', '0', 'system:client:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1037', '终端新增', '107', '2', '#', '', '1', 'F', '0', '0', 'system:client:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1038', '终端修改', '107', '3', '#', '', '1', 'F', '0', '0', 'system:client:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1039', '终端删除', '107', '4', '#', '', '1', 'F', '0', '0', 'system:client:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1040', '终端导出', '107', '5', '#', '', '1', 'F', '0', '0', 'system:client:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1041', '公告查询', '108', '1', '#', '', '1', 'F', '0', '0', 'system:notice:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1042', '公告新增', '108', '2', '#', '', '1', 'F', '0', '0', 'system:notice:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1043', '公告修改', '108', '3', '#', '', '1', 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1044', '公告删除', '108', '4', '#', '', '1', 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1045', '操作查询', '500', '1', '#', '', '1', 'F', '0', '0', 'system:operlog:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1046', '操作删除', '500', '2', '#', '', '1', 'F', '0', '0', 'system:operlog:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1047', '日志导出', '500', '4', '#', '', '1', 'F', '0', '0', 'system:operlog:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1048', '登录查询', '501', '1', '#', '', '1', 'F', '0', '0', 'system:logininfor:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1049', '登录删除', '501', '2', '#', '', '1', 'F', '0', '0', 'system:logininfor:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1050', '日志导出', '501', '3', '#', '', '1', 'F', '0', '0', 'system:logininfor:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1051', '任务查询', '110', '1', '#', '', '1', 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1052', '任务新增', '110', '2', '#', '', '1', 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1053', '任务修改', '110', '3', '#', '', '1', 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1054', '任务删除', '110', '4', '#', '', '1', 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1055', '状态修改', '110', '5', '#', '', '1', 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1056', '任务导出', '110', '7', '#', '', '1', 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1057', '生成查询', '115', '1', '#', '', '1', 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1058', '生成修改', '115', '2', '#', '', '1', 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1059', '生成删除', '115', '3', '#', '', '1', 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1060', '导入代码', '115', '2', '#', '', '1', 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1061', '预览代码', '115', '4', '#', '', '1', 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1062', '生成代码', '115', '5', '#', '', '1', 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) DEFAULT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('1', '温馨提醒：2018-07-01 若依新版本发布啦', '2', '新版本内容', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_notice` VALUES ('2', '维护通知：2018-07-01 若依系统凌晨维护', '1', '维护内容', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES ('1', 'ceo', '董事长', '1', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('2', 'se', '项目经理', '2', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('3', 'hr', '人力资源', '3', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('4', 'user', '普通员工', '4', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', '1', '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_role` VALUES ('2', '普通角色', 'common', '2', '2', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '普通角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES ('2', '100');
INSERT INTO `sys_role_dept` VALUES ('2', '101');
INSERT INTO `sys_role_dept` VALUES ('2', '105');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '2');
INSERT INTO `sys_role_menu` VALUES ('2', '3');
INSERT INTO `sys_role_menu` VALUES ('2', '4');
INSERT INTO `sys_role_menu` VALUES ('2', '100');
INSERT INTO `sys_role_menu` VALUES ('2', '101');
INSERT INTO `sys_role_menu` VALUES ('2', '102');
INSERT INTO `sys_role_menu` VALUES ('2', '103');
INSERT INTO `sys_role_menu` VALUES ('2', '104');
INSERT INTO `sys_role_menu` VALUES ('2', '105');
INSERT INTO `sys_role_menu` VALUES ('2', '106');
INSERT INTO `sys_role_menu` VALUES ('2', '107');
INSERT INTO `sys_role_menu` VALUES ('2', '108');
INSERT INTO `sys_role_menu` VALUES ('2', '109');
INSERT INTO `sys_role_menu` VALUES ('2', '110');
INSERT INTO `sys_role_menu` VALUES ('2', '111');
INSERT INTO `sys_role_menu` VALUES ('2', '112');
INSERT INTO `sys_role_menu` VALUES ('2', '113');
INSERT INTO `sys_role_menu` VALUES ('2', '114');
INSERT INTO `sys_role_menu` VALUES ('2', '115');
INSERT INTO `sys_role_menu` VALUES ('2', '500');
INSERT INTO `sys_role_menu` VALUES ('2', '501');
INSERT INTO `sys_role_menu` VALUES ('2', '1000');
INSERT INTO `sys_role_menu` VALUES ('2', '1001');
INSERT INTO `sys_role_menu` VALUES ('2', '1002');
INSERT INTO `sys_role_menu` VALUES ('2', '1003');
INSERT INTO `sys_role_menu` VALUES ('2', '1004');
INSERT INTO `sys_role_menu` VALUES ('2', '1005');
INSERT INTO `sys_role_menu` VALUES ('2', '1006');
INSERT INTO `sys_role_menu` VALUES ('2', '1007');
INSERT INTO `sys_role_menu` VALUES ('2', '1008');
INSERT INTO `sys_role_menu` VALUES ('2', '1009');
INSERT INTO `sys_role_menu` VALUES ('2', '1010');
INSERT INTO `sys_role_menu` VALUES ('2', '1011');
INSERT INTO `sys_role_menu` VALUES ('2', '1012');
INSERT INTO `sys_role_menu` VALUES ('2', '1013');
INSERT INTO `sys_role_menu` VALUES ('2', '1014');
INSERT INTO `sys_role_menu` VALUES ('2', '1015');
INSERT INTO `sys_role_menu` VALUES ('2', '1016');
INSERT INTO `sys_role_menu` VALUES ('2', '1017');
INSERT INTO `sys_role_menu` VALUES ('2', '1018');
INSERT INTO `sys_role_menu` VALUES ('2', '1019');
INSERT INTO `sys_role_menu` VALUES ('2', '1020');
INSERT INTO `sys_role_menu` VALUES ('2', '1021');
INSERT INTO `sys_role_menu` VALUES ('2', '1022');
INSERT INTO `sys_role_menu` VALUES ('2', '1023');
INSERT INTO `sys_role_menu` VALUES ('2', '1024');
INSERT INTO `sys_role_menu` VALUES ('2', '1025');
INSERT INTO `sys_role_menu` VALUES ('2', '1026');
INSERT INTO `sys_role_menu` VALUES ('2', '1027');
INSERT INTO `sys_role_menu` VALUES ('2', '1028');
INSERT INTO `sys_role_menu` VALUES ('2', '1029');
INSERT INTO `sys_role_menu` VALUES ('2', '1030');
INSERT INTO `sys_role_menu` VALUES ('2', '1031');
INSERT INTO `sys_role_menu` VALUES ('2', '1032');
INSERT INTO `sys_role_menu` VALUES ('2', '1033');
INSERT INTO `sys_role_menu` VALUES ('2', '1034');
INSERT INTO `sys_role_menu` VALUES ('2', '1035');
INSERT INTO `sys_role_menu` VALUES ('2', '1036');
INSERT INTO `sys_role_menu` VALUES ('2', '1037');
INSERT INTO `sys_role_menu` VALUES ('2', '1038');
INSERT INTO `sys_role_menu` VALUES ('2', '1039');
INSERT INTO `sys_role_menu` VALUES ('2', '1040');
INSERT INTO `sys_role_menu` VALUES ('2', '1041');
INSERT INTO `sys_role_menu` VALUES ('2', '1042');
INSERT INTO `sys_role_menu` VALUES ('2', '1043');
INSERT INTO `sys_role_menu` VALUES ('2', '1044');
INSERT INTO `sys_role_menu` VALUES ('2', '1045');
INSERT INTO `sys_role_menu` VALUES ('2', '1046');
INSERT INTO `sys_role_menu` VALUES ('2', '1047');
INSERT INTO `sys_role_menu` VALUES ('2', '1048');
INSERT INTO `sys_role_menu` VALUES ('2', '1049');
INSERT INTO `sys_role_menu` VALUES ('2', '1050');
INSERT INTO `sys_role_menu` VALUES ('2', '1051');
INSERT INTO `sys_role_menu` VALUES ('2', '1052');
INSERT INTO `sys_role_menu` VALUES ('2', '1053');
INSERT INTO `sys_role_menu` VALUES ('2', '1054');
INSERT INTO `sys_role_menu` VALUES ('2', '1055');
INSERT INTO `sys_role_menu` VALUES ('2', '1056');
INSERT INTO `sys_role_menu` VALUES ('2', '1057');
INSERT INTO `sys_role_menu` VALUES ('2', '1058');
INSERT INTO `sys_role_menu` VALUES ('2', '1059');
INSERT INTO `sys_role_menu` VALUES ('2', '1060');
INSERT INTO `sys_role_menu` VALUES ('2', '1061');
INSERT INTO `sys_role_menu` VALUES ('2', '1062');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '103', 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_user` VALUES ('2', '105', 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '测试员');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES ('1', '1');
INSERT INTO `sys_user_post` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
