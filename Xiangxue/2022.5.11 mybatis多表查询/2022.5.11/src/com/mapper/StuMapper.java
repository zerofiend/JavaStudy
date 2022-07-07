package com.mapper;

import com.pojo.Stu;

import java.util.List;

public interface StuMapper {
    public List<Stu> selAll();

    public List<Stu> selAll2();

    public List<Stu> selAll3();

    public List<Stu> selByClassId(int classId);
}
