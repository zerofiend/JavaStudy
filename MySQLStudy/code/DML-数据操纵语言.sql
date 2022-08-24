## 插入数据
INSERT INTO students(stu_num,stu_name,stu_age,stu_gender,stu_tel,stu_qq)
VALUES('1001','张三',18,'男','12345678905','1234567890');

## 删除数据
DELETE FROM students WHERE stu_num = '1001';

## 修改数据
UPDATE students set stu_name = '李四' WHERE stu_num = '1001';