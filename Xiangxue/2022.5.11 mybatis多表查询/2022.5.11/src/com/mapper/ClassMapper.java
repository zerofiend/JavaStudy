package com.mapper;

import com.pojo.Class;

import java.util.List;

public interface ClassMapper {
    public Class selById(int classId);

    public List<Class> findAll();

    public List<Class> findAll2();

    public List<Class> findAll3();
}
