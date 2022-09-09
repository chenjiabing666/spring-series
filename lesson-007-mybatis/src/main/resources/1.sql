/*创建2个库：module1和module2，每个库中创建一个t_user表*/
DROP DATABASE IF EXISTS `module1`;
CREATE DATABASE `module1`;

DROP DATABASE IF EXISTS `module2`;
CREATE DATABASE `module2`;

/*创建表结构*/
DROP TABLE IF EXISTS module1.t_user;
CREATE TABLE module1.t_user (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键，用户id，自动增长',
  `name` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '姓名'
) COMMENT '用户表';

DROP TABLE IF EXISTS module2.t_user;
CREATE TABLE module2.t_user (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键，用户id，自动增长',
  `name` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '姓名'
) COMMENT '用户表';

SELECT * FROM module1.t_user;
SELECT * FROM module2.t_user;