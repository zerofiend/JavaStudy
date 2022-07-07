package com.mapper;

import com.pojo.Users;
import com.pojo.Users2;
import org.apache.ibatis.annotations.*;

import java.util.List;

@CacheNamespace/*开启二级缓存（不能再xml文件内放入<cache/>标签）*/
public interface UserMapper {
    @Select("select * from t_user where pwd=#{pwd}")
    public List<Users> selBy(Users users);

    @Delete("delete from t_user where id=#{id}")
    public int delete(int id);

    @Insert("insert into t_user values(null,#{uname},#{pwd})")
    public int insert(Users users);

    @Update("update t_user set pwd=#{pwd} where uname=#{uname}")
    public int update(Users users);

    public List<Users2> selBy2(Users2 users2);
}
