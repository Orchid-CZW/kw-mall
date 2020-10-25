/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : kw

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2020-10-25 11:29:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('3', 'admin', '123', '113664000@qq.com', '18925139194');
INSERT INTO `admin` VALUES ('4', 'tom', '123', '113664000@qq.com', '18925139194');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `num` int(10) NOT NULL COMMENT '库存数量',
  `image` varchar(255) DEFAULT NULL,
  `idesc` varchar(255) DEFAULT NULL,
  `iflag` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '商品状态，1-上架，2-下架，3-删除',
  `created` datetime NOT NULL COMMENT '创建时间',
  `updated` datetime NOT NULL COMMENT '更新时间',
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKED8DCCEFB9B74E02` (`cid`),
  CONSTRAINT `FKED8DCCEFB9B74E02` FOREIGN KEY (`cid`) REFERENCES `item_cat` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('80', 'Myethos 游园惊梦甄姬手办', '190', '150', '100', 'item1.jpg', 'desc1.jpg', '1', '1', '2020-06-23 13:09:42', '2020-09-30 17:48:19', '1');
INSERT INTO `item` VALUES ('81', 'GSC野区小霸王迷你手办套装', '550', '510', '100', 'item2.jpg', 'desc2.jpg', '1', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '1');
INSERT INTO `item` VALUES ('82', '魅力之狐妲己Q版手办', '180', '150', '100', 'item3.jpg', 'desc3.jpg', '1', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '1');
INSERT INTO `item` VALUES ('83', 'GSC峡谷女神迷你手办套装', '360', '320', '100', 'item4.jpg', 'desc4.jpg', '1', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '1');
INSERT INTO `item` VALUES ('84', '信念之刃阿轲Q版手办', '390', '360', '100', 'item5.jpg', 'desc5.jpg', '1', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '1');
INSERT INTO `item` VALUES ('85', '千年之狐李白Q版手办', '900', '880', '100', 'item6.jpg', 'desc6.jpg', '1', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '1');
INSERT INTO `item` VALUES ('86', '铁血都督周瑜Q版手办', '108', '100', '100', 'item7.jpg', 'desc7.jpg', '1', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '1');
INSERT INTO `item` VALUES ('87', '夏日迷你魄罗毛绒4件套', '150', '120', '100', '8item.jpg', 'desc1.jpg', '2', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '1');
INSERT INTO `item` VALUES ('88', '提莫帽子', '150', '120', '100', '9item.jpg', 'desc1.jpg', '1', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '1');
INSERT INTO `item` VALUES ('89', '提伯斯颈枕', '120', '100', '100', '10item.jpg', 'desc1.jpg', '2', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '1');
INSERT INTO `item` VALUES ('90', '库奇帽子', '150', '120', '100', '11item.jpg', 'desc1.jpg', '1', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '1');
INSERT INTO `item` VALUES ('91', '李青纪念款夹克', '780', '750', '100', '12item.jpg', 'desc1.jpg', '2', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '1');
INSERT INTO `item` VALUES ('92', '提伯斯熊 连体衣', '390', '350', '100', '13item.jpg', 'desc1.jpg', '2', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '2');
INSERT INTO `item` VALUES ('93', '魂锁典狱长 锤石 连帽衫（男女同款）', '150', '120', '100', '14item.jpg', 'desc1.jpg', '1', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '3');
INSERT INTO `item` VALUES ('94', '小恶魔 提莫T恤', '150', '120', '100', '15item.jpg', 'desc1.jpg', '1', '2', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '4');
INSERT INTO `item` VALUES ('95', '星之守护者 金克丝 T恤', '150', '120', '100', '16item.jpg', 'desc1.jpg', '2', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '4');
INSERT INTO `item` VALUES ('96', '源计划 卢锡安 T恤（男女同款）', '150', '120', '100', '17item.jpg', 'desc1.jpg', '1', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '4');
INSERT INTO `item` VALUES ('97', '提莫小队', '40', '38', '100', '18item.jpg', 'desc1.jpg', '2', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '3');
INSERT INTO `item` VALUES ('98', '出击', '40', '38', '100', '19item.jpg', 'desc1.jpg', '1', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '4');
INSERT INTO `item` VALUES ('99', '大地怒火', '40', '38', '100', '20item.jpg', 'desc1.jpg', '2', '1', '2020-06-23 13:09:42', '2020-06-23 13:09:42', '1');

-- ----------------------------
-- Table structure for item_cat
-- ----------------------------
DROP TABLE IF EXISTS `item_cat`;
CREATE TABLE `item_cat` (
  `cid` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `status` int(1) DEFAULT '1' COMMENT '状态。可选值:1(正常),2(删除)',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_cat
-- ----------------------------
INSERT INTO `item_cat` VALUES ('1', '精品手办', '1');
INSERT INTO `item_cat` VALUES ('2', '数码3C', '1');
INSERT INTO `item_cat` VALUES ('3', '服装服饰', '1');
INSERT INTO `item_cat` VALUES ('4', '毛绒抱枕', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` varchar(32) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `uid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `fk_uid0001` (`uid`),
  CONSTRAINT `fk_uid0001` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1e7d17919a2844f586f8229b40f7dfd1', '2020-10-24 13:36:12', '350', '1', '123456', 'admin', '23121231231', '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('6f65d62a3ac848b0a7169761e6590f60', '2020-10-24 13:29:30', '150', '1', '斯大林的方法达成的', 'admin', '23121231231', '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('83937b9ff9a94a7bb52d89689197dfde', '2020-10-20 18:06:20', '150', '1', '123', 'admin', '23121231231', '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('85843cbfda3741649f4168a326f67200', '2020-10-20 18:14:00', '500', '2', '阿道夫', 'admin', '23121231231', '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('91205fc144e741a29b7201e3e8f46397', '2020-10-20 17:02:34', '630', '1', null, null, null, '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('a01d8487493c475da159db3ba68212ba', '2020-06-28 22:07:03', '500', '1', null, null, null, '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('aab36df4ef9c4839a1e31a85b9eefac1', '2020-10-19 16:18:42', '300', '1', null, null, null, '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('b412efb721db4282ab82f36bf472324b', '2020-06-28 22:01:27', '810', '1', null, null, null, '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('bc42f70b97d544f691ebb91577df296d', '2020-09-21 15:41:53', '150', '1', null, null, null, '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('c4fe3e54eec243cf885814304bb95b13', '2020-10-19 17:18:43', '150', '1', null, null, null, '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('c91c50191b3940579353e1bee8e20c51', '2020-10-20 17:01:00', '120', '1', null, null, null, '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('d015ae41145a4074ae583d1f740b0a7b', '2020-10-25 11:09:27', '818', '1', '阿道夫', 'admin', '12312asdfasd', '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('d5c50c671d5b4a9597a8300ffefa12f1', '2020-10-19 16:16:39', '150', '1', null, null, null, '373eb242933b4f5ca3bd43503c34668b');
INSERT INTO `orders` VALUES ('d735fc87e3d04c0d81d87bb4d3dec791', '2020-10-19 16:16:06', '150', '1', null, null, null, '373eb242933b4f5ca3bd43503c34668b');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `itemid` varchar(32) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `oid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `fkid_0001` (`id`),
  KEY `fkoid_0002` (`oid`),
  CONSTRAINT `fk_0001` FOREIGN KEY (`id`) REFERENCES `item` (`id`),
  CONSTRAINT `fk_0002` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('0b4237bc44f64e828526358c76db62a2', '1', '150', '82', 'aab36df4ef9c4839a1e31a85b9eefac1');
INSERT INTO `order_item` VALUES ('102ba3a8fecd49d9b47b8f54bd1f5380', '1', '150', '80', 'aab36df4ef9c4839a1e31a85b9eefac1');
INSERT INTO `order_item` VALUES ('2a4d33e1e3ea40b8b5ed78c992556a3f', '1', '350', '92', '85843cbfda3741649f4168a326f67200');
INSERT INTO `order_item` VALUES ('348c163a0cc940b0ae8376d572d50bf7', '1', '120', '93', 'c91c50191b3940579353e1bee8e20c51');
INSERT INTO `order_item` VALUES ('4cd522c0146b48e192279f16142725d8', '1', '38', '97', 'd015ae41145a4074ae583d1f740b0a7b');
INSERT INTO `order_item` VALUES ('60ee971319f74b6589c4785425fef658', '1', '150', '80', 'd735fc87e3d04c0d81d87bb4d3dec791');
INSERT INTO `order_item` VALUES ('684b8360854b4017a19d997ee6cd5a25', '1', '150', '80', 'd015ae41145a4074ae583d1f740b0a7b');
INSERT INTO `order_item` VALUES ('699c7c241c4a4787a1a11c11d13f65c3', '1', '350', '92', 'a01d8487493c475da159db3ba68212ba');
INSERT INTO `order_item` VALUES ('7ef2ef60060349ee84d09191099c05e4', '1', '510', '81', '91205fc144e741a29b7201e3e8f46397');
INSERT INTO `order_item` VALUES ('99aa34a2d7fd4cb6bf669cf9ff85da89', '1', '150', '80', 'd5c50c671d5b4a9597a8300ffefa12f1');
INSERT INTO `order_item` VALUES ('a60b09005f4f4afeae71c43db17831d7', '1', '150', '80', 'a01d8487493c475da159db3ba68212ba');
INSERT INTO `order_item` VALUES ('ab54db4c4bfb4ac59ab873b0ad5ffd64', '1', '350', '92', '1e7d17919a2844f586f8229b40f7dfd1');
INSERT INTO `order_item` VALUES ('ac65881f6dad4a3192126f154ca5391e', '1', '150', '80', '6f65d62a3ac848b0a7169761e6590f60');
INSERT INTO `order_item` VALUES ('b57641b70b254aa3899fa8ebd1db99d5', '1', '150', '80', '85843cbfda3741649f4168a326f67200');
INSERT INTO `order_item` VALUES ('c403cf22398341d7baf82b1411d0d1e6', '1', '150', '80', 'c4fe3e54eec243cf885814304bb95b13');
INSERT INTO `order_item` VALUES ('c529fab8c6774b2ebeaa7630eb959ac7', '1', '150', '80', 'bc42f70b97d544f691ebb91577df296d');
INSERT INTO `order_item` VALUES ('c9346ead2e524c6daf7fd78a333a9eb8', '1', '510', '81', 'b412efb721db4282ab82f36bf472324b');
INSERT INTO `order_item` VALUES ('deeecbb2331d437f8c07f5ce1d725285', '1', '120', '93', '91205fc144e741a29b7201e3e8f46397');
INSERT INTO `order_item` VALUES ('e01715426ab74c46bcb5f200c800986d', '1', '510', '81', 'd015ae41145a4074ae583d1f740b0a7b');
INSERT INTO `order_item` VALUES ('e529e394a80b4dffa59b824f1d2c6899', '1', '120', '95', 'd015ae41145a4074ae583d1f740b0a7b');
INSERT INTO `order_item` VALUES ('eb57db007a9b4d52840889ceb91c8436', '2', '300', '80', 'b412efb721db4282ab82f36bf472324b');
INSERT INTO `order_item` VALUES ('f19454eb53ef4daa99af67f0d7f78d8d', '1', '150', '80', '83937b9ff9a94a7bb52d89689197dfde');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(32) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('08fe4bb3c25a41fd803b659536ba1893', 'fdsadf', '123', 'aa', 'aaa@qq.com', 'adsaf', '2020-06-23', '女', '0', null);
INSERT INTO `user` VALUES ('373eb242933b4f5ca3bd43503c34668b', 'wc001', '888888', '旺财', 'bbb@store.com', '15723689921', '2015-11-04', '男', '0', '9782f3e837ff422b9aee8b6381ccf927bdd9d2ced10d48f4ba4b9f187edf7738');
INSERT INTO `user` VALUES ('4fba73fbb55342e6b93a5da6d100c3a5', 'ad', '123', 'ad', 'aaa@qq.com', null, '2020-10-09', '女', '0', 'mkaw3');
INSERT INTO `user` VALUES ('62145f6e66ea4f5cbe7b6f6b954917d3', 'xb001', '888888', '小宝', 'bbb@store.com', '15723689921', '2015-11-03', '男', '0', '19f100aa81184c03951c4b840a725b6a98097aa1106a4a38ba1c29f1a496c231');
