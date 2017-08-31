package com.ybh;

import org.apache.ibatis.annotations.Select;

public interface MybatisTest {
    @Select("select * from Y_TEST where goodsid= #{id}")
public User selectUser(int id);
}
