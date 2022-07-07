package com.pojo;


import java.io.Serializable;
import java.util.List;

public class Class implements Serializable {

    private int classId;
    private String className;
    private String room;

    /*  持有学生    */
    private List<Stu> stus;

    public List<Stu> getStus() {
        return stus;
    }

    public void setStus(List<Stu> stus) {
        this.stus = stus;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", room='" + room + '\'' +
                ", stus=" + stus +
                '}';
    }
}
