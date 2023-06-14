/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.31.100-mysql
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : 192.168.31.100:3306
 Source Schema         : spring_cloud_alibaba_nacos

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 15/06/2023 02:54:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL,
  `encrypted_data_key` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '秘钥',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id` ASC, `group_id` ASC, `tenant_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = 'config_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (1, 'Product-dev.yaml', 'PROVIDER_GROUP', 'spring:\r\n  datasource:\r\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\r\n    username: root\r\n    password: mysql\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n\r\nmybatis-plus:\r\n  mapper-location: classpath:mapper/*.xml\r\n\r\n  management:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n', 'ee5c649012a42a868f3970bc6a9a1699', '2023-06-15 02:14:46', '2023-06-15 02:14:46', NULL, '0:0:0:0:0:0:0:1', '', 'ed2069f3-cc54-4a62-b044-95061643ae84', NULL, NULL, NULL, 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (6, 'User-dev.yaml', 'PROVIDER_GROUP', 'spring:\r\n  datasource:\r\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\r\n    username: root\r\n    password: mysql\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n\r\nmybatis-plus:\r\n  mapper-location: classpath:mapper/*.xml\r\n\r\n  management:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n', 'ee5c649012a42a868f3970bc6a9a1699', '2023-06-15 02:29:06', '2023-06-15 02:29:06', NULL, '0:0:0:0:0:0:0:1', '', 'ed2069f3-cc54-4a62-b044-95061643ae84', NULL, NULL, NULL, 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (7, 'Order-dev.yaml', 'CONSUMER_GROUP', 'spring:\n  datasource:\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\n    username: root\n    password: mysql\n    driver-class-name: com.mysql.cj.jdbc.Driver\n  mvc:\n    pathmatch:\n      matching-strategy: ANT_PATH_MATCHER\n\nmybatis-plus:\n  mapper-location: classpath:mapper/*.xml\n\n  management:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n# 设置 feign 客户端超时时间(OpenFeign 默认支持 Ribbon)\nribbon:\n  # 指的是建立连接所用的时间，适用于网络状况正常的情况下，两端连接所用的时间\n  read-timeout: 2000\n  # 指的是建立连接后从服务器读取到可用资源所用的时间\n  connect-timeout: 2000\n\nfeign:\n  client:\n    config:\n      Product:\n        loggerLevel: full\n      Order:\n        loggerLevel: full\n# Feign日志只会对日志级别为debug的做出响应\nlogging:\n  level:\n    com.example.order.ms.ProductFeignService: debug\n    com.example.order.ms.OrderFeignService: debug', 'e3c14b0e865aa96326f4125bb9f0a4e5', '2023-06-15 02:29:59', '2023-06-15 02:44:13', NULL, '0:0:0:0:0:0:0:1', '', 'ed2069f3-cc54-4a62-b044-95061643ae84', '', '', '', 'yaml', '', '');

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id` ASC, `group_id` ASC, `tenant_id` ASC, `datum_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '增加租户字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_aggr
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '秘钥',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id` ASC, `group_id` ASC, `tenant_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = 'config_info_beta' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_beta
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id` ASC, `group_id` ASC, `tenant_id` ASC, `tag_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = 'config_info_tag' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_tag
-- ----------------------------

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation`  (
  `id` bigint NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`) USING BTREE,
  UNIQUE INDEX `uk_configtagrelation_configidtag`(`id` ASC, `tag_name` ASC, `tag_type` ASC) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = 'config_tag_relation' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_tags_relation
-- ----------------------------

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info`  (
  `id` bigint UNSIGNED NOT NULL,
  `nid` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `md5` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `src_user` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL,
  `src_ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '秘钥',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create` ASC) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified` ASC) USING BTREE,
  INDEX `idx_did`(`data_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '多租户改造' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
INSERT INTO `his_config_info` VALUES (0, 1, 'Product-dev.yaml', 'PROVIDER_GROUP', '', 'spring:\r\n  datasource:\r\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\r\n    username: root\r\n    password: mysql\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n\r\nmybatis-plus:\r\n  mapper-location: classpath:mapper/*.xml\r\n\r\n  management:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n', 'ee5c649012a42a868f3970bc6a9a1699', '2023-06-15 02:14:46', '2023-06-15 02:14:46', NULL, '0:0:0:0:0:0:0:1', 'I', 'ed2069f3-cc54-4a62-b044-95061643ae84', '');
INSERT INTO `his_config_info` VALUES (0, 2, 'User-dev.yaml', 'DEFAULT_GROUP', '', 'spring:\r\n  cloud:\r\n    nacos:\r\n      discovery:\r\n        server-addr: localhost:8848\r\n\r\n  datasource:\r\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\r\n    username: root\r\n    password: mysql\r\n    driver-class-name: com.mysql.cj.jdbc.Driver', 'ecdfa534f10f57f74ab3d86e5eb46ae0', '2023-06-15 02:17:29', '2023-06-15 02:17:30', NULL, '0:0:0:0:0:0:0:1', 'I', 'ed2069f3-cc54-4a62-b044-95061643ae84', '');
INSERT INTO `his_config_info` VALUES (2, 3, 'User-dev.yaml', 'DEFAULT_GROUP', '', 'spring:\r\n  cloud:\r\n    nacos:\r\n      discovery:\r\n        server-addr: localhost:8848\r\n\r\n  datasource:\r\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\r\n    username: root\r\n    password: mysql\r\n    driver-class-name: com.mysql.cj.jdbc.Driver', 'ecdfa534f10f57f74ab3d86e5eb46ae0', '2023-06-15 02:18:00', '2023-06-15 02:18:01', NULL, '0:0:0:0:0:0:0:1', 'U', 'ed2069f3-cc54-4a62-b044-95061643ae84', '');
INSERT INTO `his_config_info` VALUES (0, 4, 'Order-dev.yaml', 'COMSUMER_GROUP', '', 'spring:\r\n  datasource:\r\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\r\n    username: root\r\n    password: mysql\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n\r\nmybatis-plus:\r\n  mapper-location: classpath:mapper/*.xml\r\n\r\n  management:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n# 设置 feign 客户端超时时间(OpenFeign 默认支持 Ribbon)\r\nribbon:\r\n  # 指的是建立连接所用的时间，适用于网络状况正常的情况下，两端连接所用的时间\r\n  read-timeout: 2000\r\n  # 指的是建立连接后从服务器读取到可用资源所用的时间\r\n  connect-timeout: 2000\r\n\r\nfeign:\r\n  client:\r\n    config:\r\n      Product:\r\n        loggerLevel: full\r\n      Order:\r\n        loggerLevel: full\r\n# Feign日志只会对日志级别为debug的做出响应\r\nlogging:\r\n  level:\r\n    com.example.order.ms.ProductFeignService: debug\r\n    com.example.order.ms.OrderFeignService: debug', 'cdeb3b0e9bbd3b9276eaa25e81c99a2b', '2023-06-15 02:21:05', '2023-06-15 02:21:06', NULL, '0:0:0:0:0:0:0:1', 'I', 'ed2069f3-cc54-4a62-b044-95061643ae84', '');
INSERT INTO `his_config_info` VALUES (2, 5, 'User-dev.yaml', 'DEFAULT_GROUP', '', 'spring:\n  datasource:\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\n    username: root\n    password: mysql\n    driver-class-name: com.mysql.cj.jdbc.Driver\n\nmybatis-plus:\n  mapper-location: classpath:mapper/*.xml\n\n  management:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n', 'e7218d074881ff52dbb314ce2cb3721b', '2023-06-15 02:27:38', '2023-06-15 02:27:39', NULL, '0:0:0:0:0:0:0:1', 'U', 'ed2069f3-cc54-4a62-b044-95061643ae84', '');
INSERT INTO `his_config_info` VALUES (2, 6, 'User-dev.yaml', 'DEFAULT_GROUP', '', 'spring:\n  datasource:\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\n    username: root\n    password: mysql\n    driver-class-name: com.mysql.cj.jdbc.Driver\n\nmybatis-plus:\n  mapper-location: classpath:mapper/*.xml\n\n  management:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n', 'e7218d074881ff52dbb314ce2cb3721b', '2023-06-15 02:28:42', '2023-06-15 02:28:42', NULL, '0:0:0:0:0:0:0:1', 'D', 'ed2069f3-cc54-4a62-b044-95061643ae84', '');
INSERT INTO `his_config_info` VALUES (0, 7, 'User-dev.yaml', 'PROVIDER_GROUP', '', 'spring:\r\n  datasource:\r\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\r\n    username: root\r\n    password: mysql\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n\r\nmybatis-plus:\r\n  mapper-location: classpath:mapper/*.xml\r\n\r\n  management:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n', 'ee5c649012a42a868f3970bc6a9a1699', '2023-06-15 02:29:06', '2023-06-15 02:29:06', NULL, '0:0:0:0:0:0:0:1', 'I', 'ed2069f3-cc54-4a62-b044-95061643ae84', '');
INSERT INTO `his_config_info` VALUES (4, 8, 'Order-dev.yaml', 'COMSUMER_GROUP', '', 'spring:\r\n  datasource:\r\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\r\n    username: root\r\n    password: mysql\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n\r\nmybatis-plus:\r\n  mapper-location: classpath:mapper/*.xml\r\n\r\n  management:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n# 设置 feign 客户端超时时间(OpenFeign 默认支持 Ribbon)\r\nribbon:\r\n  # 指的是建立连接所用的时间，适用于网络状况正常的情况下，两端连接所用的时间\r\n  read-timeout: 2000\r\n  # 指的是建立连接后从服务器读取到可用资源所用的时间\r\n  connect-timeout: 2000\r\n\r\nfeign:\r\n  client:\r\n    config:\r\n      Product:\r\n        loggerLevel: full\r\n      Order:\r\n        loggerLevel: full\r\n# Feign日志只会对日志级别为debug的做出响应\r\nlogging:\r\n  level:\r\n    com.example.order.ms.ProductFeignService: debug\r\n    com.example.order.ms.OrderFeignService: debug', 'cdeb3b0e9bbd3b9276eaa25e81c99a2b', '2023-06-15 02:29:41', '2023-06-15 02:29:42', NULL, '0:0:0:0:0:0:0:1', 'D', 'ed2069f3-cc54-4a62-b044-95061643ae84', '');
INSERT INTO `his_config_info` VALUES (0, 9, 'Order-dev.yaml', 'CONSUMER_GROUP', '', 'spring:\r\n  datasource:\r\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\r\n    username: root\r\n    password: mysql\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n\r\nmybatis-plus:\r\n  mapper-location: classpath:mapper/*.xml\r\n\r\n  management:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n# 设置 feign 客户端超时时间(OpenFeign 默认支持 Ribbon)\r\nribbon:\r\n  # 指的是建立连接所用的时间，适用于网络状况正常的情况下，两端连接所用的时间\r\n  read-timeout: 2000\r\n  # 指的是建立连接后从服务器读取到可用资源所用的时间\r\n  connect-timeout: 2000\r\n\r\nfeign:\r\n  client:\r\n    config:\r\n      Product:\r\n        loggerLevel: full\r\n      Order:\r\n        loggerLevel: full\r\n# Feign日志只会对日志级别为debug的做出响应\r\nlogging:\r\n  level:\r\n    com.example.order.ms.ProductFeignService: debug\r\n    com.example.order.ms.OrderFeignService: debug', 'cdeb3b0e9bbd3b9276eaa25e81c99a2b', '2023-06-15 02:29:58', '2023-06-15 02:29:59', NULL, '0:0:0:0:0:0:0:1', 'I', 'ed2069f3-cc54-4a62-b044-95061643ae84', '');
INSERT INTO `his_config_info` VALUES (7, 10, 'Order-dev.yaml', 'CONSUMER_GROUP', '', 'spring:\r\n  datasource:\r\n    url: jdbc:mysql://192.168.31.100:3306/spring_cloud_alibaba?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true\r\n    username: root\r\n    password: mysql\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n\r\nmybatis-plus:\r\n  mapper-location: classpath:mapper/*.xml\r\n\r\n  management:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n# 设置 feign 客户端超时时间(OpenFeign 默认支持 Ribbon)\r\nribbon:\r\n  # 指的是建立连接所用的时间，适用于网络状况正常的情况下，两端连接所用的时间\r\n  read-timeout: 2000\r\n  # 指的是建立连接后从服务器读取到可用资源所用的时间\r\n  connect-timeout: 2000\r\n\r\nfeign:\r\n  client:\r\n    config:\r\n      Product:\r\n        loggerLevel: full\r\n      Order:\r\n        loggerLevel: full\r\n# Feign日志只会对日志级别为debug的做出响应\r\nlogging:\r\n  level:\r\n    com.example.order.ms.ProductFeignService: debug\r\n    com.example.order.ms.OrderFeignService: debug', 'cdeb3b0e9bbd3b9276eaa25e81c99a2b', '2023-06-15 02:44:13', '2023-06-15 02:44:13', NULL, '0:0:0:0:0:0:0:1', 'U', 'ed2069f3-cc54-4a62-b044-95061643ae84', '');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `resource` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `action` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role` ASC, `resource` ASC, `action` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permissions
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  UNIQUE INDEX `idx_user_role`(`username` ASC, `role` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '租户容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp` ASC, `tenant_id` ASC) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = 'tenant_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
INSERT INTO `tenant_info` VALUES (1, '1', 'ed2069f3-cc54-4a62-b044-95061643ae84', 'dev', 'dev namespace', 'nacos', 1686766120838, 1686766120838);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
