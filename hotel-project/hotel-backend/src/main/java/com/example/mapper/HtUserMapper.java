package com.example.mapper;

import com.example.entity.HtUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HtUserMapper {

    /**
     * 用户名或者邮箱查询
     * @param test
     * @return
     */
    @Select("select * from ht_user where username = #{text} or email = #{text}")
    HtUser findUserByUsernameOrEmail(String test);
}
