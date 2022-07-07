package com.pojo;


import java.io.Serializable;

public class Stu implements Serializable {

    private int stuId;
    private String stuName;
    private int age;
    private int classId;
    /*  持有班级信息  */
    private Class aClass;

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", age=" + age +
                ", classId=" + classId +
                ", aClass=" + aClass +
                '}';
    }
}
