/*
 Navicat Premium Data Transfer

 Source Server         : gyx
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : star_store

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 26/06/2021 21:02:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `price` decimal(10, 2) DEFAULT NULL,
  `sales` int(255) DEFAULT NULL,
  `stock` int(255) DEFAULT NULL,
  `img_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES (23, '天空之翼', 100.00, 25, 23, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (25, '无影剑', 100.00, 15, 5, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (27, '枯叶刀', 100.00, 54, 96, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (30, '流光星陨刀', 200.00, 11, 9, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (31, '护摩之杖', 200.00, 10, 10, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (32, '梵风衣', 200.00, 10, 10, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (34, '残杀者巨剑', 200.00, 10, 10, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (35, '泰拉石太刀', 300.00, 10, 10, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (36, '裂创心灵之刃', 300.00, 10, 10, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (37, '灵犀之戒', 200.00, 10, 10, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (38, '玛尼神兽项坠', 300.00, 10, 10, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (39, '希泊之力作-意念', 200.00, 10, 10, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (41, '希德之泪', 200.00, 10, 10, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (42, '极光剑', 200.00, 12, 8, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (43, '狩猎之王', 100.00, 22, 8, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (44, '远古之艾尔文指环', 200.00, 12, 8, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (45, '天琴座的高洁', 300.00, 11, 9, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (46, '海豚座的羞涩', 300.00, 11, 9, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (47, '织女星的凝望', 300.00, 12, 8, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (48, '天鹅座的朦胧', 300.00, 12, 8, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (49, '北极星的魅力', 300.00, 10, 10, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (50, '亿万年的星光', 1000.00, 1, 1, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (52, '绝刀-红莲天舞', 300.00, 10, 10, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (53, '千寻一醉', 100.00, 20, 20, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (54, '少女飘摇的思念', 50.00, 10, 10, '/static/img/default.jpg');
INSERT INTO `t_goods` VALUES (55, '似水流年', 200.00, 10, 10, '/static/img/default.jpg');

-- ----------------------------
-- Table structure for t_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager`  (
  `user_id` int(10) NOT NULL COMMENT '以t_user中的id为外键',
  `authority` int(10) DEFAULT NULL COMMENT '管理员权限，0表示无权限，1表示有权限',
  PRIMARY KEY (`user_id`) USING BTREE,
  CONSTRAINT `t_manager_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_manager
-- ----------------------------
INSERT INTO `t_manager` VALUES (22, 1);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `price` decimal(10, 2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('2021052804195619', '2021-05-28 00:00:00', 500.00, 2, 19);
INSERT INTO `t_order` VALUES ('2021052804362019', '2021-05-28 00:00:00', 600.00, 1, 19);
INSERT INTO `t_order` VALUES ('2021052804435229', '2021-05-28 00:00:00', 700.00, 1, 29);
INSERT INTO `t_order` VALUES ('2021052804441029', '2021-05-28 00:00:00', 100.00, 0, 29);
INSERT INTO `t_order` VALUES ('2021052804442129', '2021-05-28 00:00:00', 600.00, 0, 29);
INSERT INTO `t_order` VALUES ('2021052804452829', '2021-05-28 00:00:00', 100.00, 0, 29);
INSERT INTO `t_order` VALUES ('2021052804513129', '2021-05-28 00:00:00', 100.00, 0, 29);
INSERT INTO `t_order` VALUES ('2021052805021328', '2021-05-28 00:00:00', 1100.00, 0, 28);
INSERT INTO `t_order` VALUES ('2021052902403828', '2021-05-29 00:00:00', 1500.00, 0, 28);
INSERT INTO `t_order` VALUES ('2021052912460028', '2021-05-29 00:00:00', 600.00, 0, 28);
INSERT INTO `t_order` VALUES ('2021053003123832', '2021-05-30 00:00:00', 500.00, 2, 32);
INSERT INTO `t_order` VALUES ('2021053011252622', '2021-05-30 00:00:00', 100.00, 2, 22);

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` decimal(10, 2) DEFAULT NULL,
  `total_price` decimal(10, 2) DEFAULT NULL,
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES (4, '天空之翼', 1, 100.00, 100.00, '2021052804195619');
INSERT INTO `t_order_item` VALUES (5, '无影剑', 1, 100.00, 100.00, '2021052804195619');
INSERT INTO `t_order_item` VALUES (6, '枯叶刀', 1, 100.00, 100.00, '2021052804195619');
INSERT INTO `t_order_item` VALUES (7, '流光星陨刀', 1, 200.00, 200.00, '2021052804195619');
INSERT INTO `t_order_item` VALUES (8, '天空之翼', 1, 100.00, 100.00, '2021052804362019');
INSERT INTO `t_order_item` VALUES (9, '无影剑', 2, 100.00, 200.00, '2021052804362019');
INSERT INTO `t_order_item` VALUES (10, '枯叶刀', 1, 100.00, 100.00, '2021052804362019');
INSERT INTO `t_order_item` VALUES (11, '流光星陨刀', 1, 200.00, 200.00, '2021052804362019');
INSERT INTO `t_order_item` VALUES (12, '天空之翼', 1, 100.00, 100.00, '2021052804435229');
INSERT INTO `t_order_item` VALUES (13, '无影剑', 1, 100.00, 100.00, '2021052804435229');
INSERT INTO `t_order_item` VALUES (14, '极光剑', 1, 200.00, 200.00, '2021052804435229');
INSERT INTO `t_order_item` VALUES (15, '狩猎之王', 1, 100.00, 100.00, '2021052804435229');
INSERT INTO `t_order_item` VALUES (16, '远古之艾尔文指环', 1, 200.00, 200.00, '2021052804435229');
INSERT INTO `t_order_item` VALUES (17, '天空之翼', 1, 100.00, 100.00, '2021052804441029');
INSERT INTO `t_order_item` VALUES (18, '天空之翼', 6, 100.00, 600.00, '2021052804442129');
INSERT INTO `t_order_item` VALUES (19, '无影剑', 1, 100.00, 100.00, '2021052804452829');
INSERT INTO `t_order_item` VALUES (20, '天空之翼', 1, 100.00, 100.00, '2021052804513129');
INSERT INTO `t_order_item` VALUES (21, '天鹅座的朦胧', 1, 300.00, 300.00, '2021052805021328');
INSERT INTO `t_order_item` VALUES (22, '极光剑', 1, 200.00, 200.00, '2021052805021328');
INSERT INTO `t_order_item` VALUES (23, '狩猎之王', 1, 100.00, 100.00, '2021052805021328');
INSERT INTO `t_order_item` VALUES (24, '远古之艾尔文指环', 1, 200.00, 200.00, '2021052805021328');
INSERT INTO `t_order_item` VALUES (25, '织女星的凝望', 1, 300.00, 300.00, '2021052805021328');
INSERT INTO `t_order_item` VALUES (29, '天空之翼', 4, 100.00, 400.00, '2021052912460028');
INSERT INTO `t_order_item` VALUES (30, '无影剑', 1, 100.00, 100.00, '2021052912460028');
INSERT INTO `t_order_item` VALUES (31, '枯叶刀', 1, 100.00, 100.00, '2021052912460028');
INSERT INTO `t_order_item` VALUES (32, '天鹅座的朦胧', 1, 300.00, 300.00, '2021052902403828');
INSERT INTO `t_order_item` VALUES (33, '天空之翼', 1, 100.00, 100.00, '2021052902403828');
INSERT INTO `t_order_item` VALUES (34, '无影剑', 1, 100.00, 100.00, '2021052902403828');
INSERT INTO `t_order_item` VALUES (35, '枯叶刀', 1, 100.00, 100.00, '2021052902403828');
INSERT INTO `t_order_item` VALUES (36, '天琴座的高洁', 1, 300.00, 300.00, '2021052902403828');
INSERT INTO `t_order_item` VALUES (37, '海豚座的羞涩', 1, 300.00, 300.00, '2021052902403828');
INSERT INTO `t_order_item` VALUES (38, '织女星的凝望', 1, 300.00, 300.00, '2021052902403828');
INSERT INTO `t_order_item` VALUES (39, '枯叶刀', 1, 100.00, 100.00, '2021053011252622');
INSERT INTO `t_order_item` VALUES (40, '天空之翼', 1, 100.00, 100.00, '2021053003123832');
INSERT INTO `t_order_item` VALUES (41, '无影剑', 1, 100.00, 100.00, '2021053003123832');
INSERT INTO `t_order_item` VALUES (42, '枯叶刀', 1, 100.00, 100.00, '2021053003123832');
INSERT INTO `t_order_item` VALUES (43, '流光星陨刀', 1, 200.00, 200.00, '2021053003123832');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (19, 'yotsuba', '123456', 'yotsuba@star.com');
INSERT INTO `t_user` VALUES (20, 'ganyu', '123456', 'ganyu@star.com');
INSERT INTO `t_user` VALUES (21, 'linxin', '123456', 'linxin@star.com');
INSERT INTO `t_user` VALUES (22, 'admin', 'admin', 'admin@star.com');
INSERT INTO `t_user` VALUES (23, 'hutao', '123456', 'hutao@star.com');
INSERT INTO `t_user` VALUES (24, 'xiangxiang', '123456', 'xiangxiang@star.com');
INSERT INTO `t_user` VALUES (25, 'guiqi', '123456', 'guiqi@star.com');
INSERT INTO `t_user` VALUES (26, 'takagi', '123456', 'takagi@star.com');
INSERT INTO `t_user` VALUES (27, 'vivy_03', '123456', 'vivy@star.com');
INSERT INTO `t_user` VALUES (28, 'emilia', '123456', 'emilia@star.com');
INSERT INTO `t_user` VALUES (29, 'miku_03', '123456', 'miku@star.com');
INSERT INTO `t_user` VALUES (30, 'qianshen', '123456', 'qianshen@star.com');
INSERT INTO `t_user` VALUES (31, 'jianyu', '123456', 'jianyu@star.com');
INSERT INTO `t_user` VALUES (32, 'asuna', '123456', 'asuna@star.com');

SET FOREIGN_KEY_CHECKS = 1;
