## DDL数据库操作
## 创建数据库
CREATE DATABASE test01;

## 当指定名称不存在时创建数据库
CREATE DATABASE if not EXISTS xiangxuestudy;

## 创建数据库同时指定字符集
CREATE DATABASE if not EXISTS xiangxue CHARACTER set utf8;

## 修改数据库字符集
ALTER DATABASE xiangxuestudy character set utf8;

## 删除数据库
DROP DATABASE if EXISTS xiangxue;

## 切换数据库
use xiangxue;
use xiangxuestudy;

## DDL数据表操作
## 创建数据表
CREATE TABLE students(
	stu_num char(8) not null UNIQUE,
	stu_name varchar(20) not null,
	stu_gender char(2) not null,
	stu_age int not null,
	stu_tel char(11) not null unique,
	stu_qq varchar(11) unique
);

CREATE TABLE test(
	demo01 int not null
);

## 查询数据表
show TABLES;

## 查询表结构
DESC students;

## 删除数据表
DROP TABLE if EXISTS test;

## 修改数据表
## 修改表名
ALTER TABLE test RENAME to Test;

## 修改字符集
ALTER TABLE test CHARACTER set utf8;

## 添加字段（列）
ALTER TABLE test add new VARCHAR(200);

## 修改字段的列表和类型
ALTER TABLE test change new old int;

## 只修改字段的类型
ALTER TABLE test MODIFY old VARCHAR(200);

## 删除列
ALTER TABLE test DROP old;


## 字段约束
CREATE TABLE books(
	book_isbn char(4) PRIMARY key,
	book_name varchar(10) UNIQUE,
	book_author varchar(7) not null
	);

## 删除主键约束
ALTER TABLE books drop PRIMARY key;

## 添加主键约束
ALTER TABLE books MODIFY book_isbn char(4) PRIMARY key;

## 主键自动增长
CREATE TABLE types(
	type_id int PRIMARY key auto_increment,
	type_name varchar(20) not null
);
	
## 定义联合主键
CREATE TABLE grades(
	stu_num char(8),
	course_id int,
	score int,
	PRIMARY key(stu_num,course_id)
);





