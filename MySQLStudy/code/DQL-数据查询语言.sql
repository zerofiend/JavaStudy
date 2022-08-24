## 基础语法
SELECT * from students;
SELECT stu_num,stu_name,stu_age FROM students;

## 条件关系运算符
SELECT * FROM students WHERE stu_num = '1003';
SELECT * FROM students WHERE stu_age < 20;
## != 等价于 <>
SELECT * FROM students WHERE stu_name != '李四';
SELECT * FROM students WHERE stu_name <> '李四';
## BETWEEN AND
SELECT * FROM students WHERE stu_age BETWEEN 19 AND 20;

## like子句
SELECT * FROM students WHERE stu_name LIKE '%三';

## 设置查询的列
SELECT stu_gender FROM students WHERE stu_age >= 18;

## 计算列
SELECT stu_name,2022-stu_age AS 'stu_birth' FROM students;

## DISTINCT 消除重复行
SELECT DISTINCT stu_gender FROM students;

## ORDER BY 排序 升序
SELECT * FROM students ORDER BY stu_qq ASC;

## ORDER BY 排序 降序
SELECT * FROM students ORDER BY stu_qq DESC;

##聚合函数
## count()
SELECT COUNT(stu_num) FROM students WHERE stu_gender='男';

## max()
SELECT MAX(stu_num) FROM students;

## min()
SELECT min(stu_num) FROM students;

## sum()
SELECT sum(stu_age) FROM students;

## avg()
SELECT avg(stu_age) FROM students;

## 日期函数
ALTER TABLE students add stu_date VARCHAR(200);
UPDATE students set stu_date = now() WHERE stu_gender='男';
UPDATE students set stu_date = SYSDATE() WHERE stu_gender='女';

## 字符串函数
## CONCAT()
SELECT concat(stu_num,'-',stu_name,'-',stu_gender) AS 'concat()' FROM students;

## upper()
INSERT students(stu_num,stu_name,stu_gender,stu_age,stu_tel,stu_qq,stu_date) 
VALUE('1005','Alice','女',18,'15247856589','1625489953',SYSDATE());
SELECT UPPER(stu_name) FROM students WHERE stu_num='1005';

## LOWER()
SELECT LOWER(stu_name) FROM students WHERE stu_num='1005';

## SUBSTR()
SELECT SUBSTR(stu_name,1,1) AS 'substr()' FROM students;


## 分组查询 GROUP BY
SELECT stu_gender as '性别',AVG(stu_age) as '平均年龄' FROM students GROUP BY stu_gender;

SELECT stu_age as '年龄',COUNT(stu_gender) as '人数' FROM students GROUP BY stu_age;

## 分页查询
INSERT students(stu_num,stu_name,stu_gender,stu_age,stu_tel,stu_qq,stu_date) 
VALUE('1006','Ben','男',21,'14526587462','1564872254',SYSDATE());

INSERT students(stu_num,stu_name,stu_gender,stu_age,stu_tel,stu_qq,stu_date) 
VALUE('1007','Catty','女',19,'15248554963','1472305564',SYSDATE());

INSERT students(stu_num,stu_name,stu_gender,stu_age,stu_tel,stu_qq,stu_date) 
VALUE('1008','Davie','男',20,'15247841023','1230045678',SYSDATE());

INSERT students(stu_num,stu_name,stu_gender,stu_age,stu_tel,stu_qq,stu_date) 
VALUE('1009','Eiddy','男',18,'14745694020','1234567025',SYSDATE());

SELECT * FROM students LIMIT 0,3;

SELECT * FROM students LIMIT 3,3;

SELECT * FROM students LIMIT 6,3;








