package com.zh.test.service;

import com.zh.test.model.request.UserDTO;

import java.util.Map;

public interface UserService {
    /**
     * 新增用户信息
     * @param userDTO
     * @return
     */
    int insertUser(UserDTO userDTO);

    /**
     * 根据用户姓名查询用户信息
     * @param name
     * @return
     */
    Map<String, Object> findUserByName(String name);

    Map<String, Object> findUserById(String id);

    void updateUser(UserDTO userDTO);
}
