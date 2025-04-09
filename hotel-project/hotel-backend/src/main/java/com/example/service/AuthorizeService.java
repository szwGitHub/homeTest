package com.example.service;

import com.example.entity.HtUser;
import com.example.mapper.HtUserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthorizeService implements UserDetailsService {

    @Resource
    HtUserMapper htUserMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username)){
            throw new UsernameNotFoundException("用户名不能为空");
        }
        HtUser htUser = htUserMapper.findUserByUsernameOrEmail(username);
        if(htUser == null){
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return User.withUsername(username).password(htUser.getPassword()).roles("user").build();
    }
}
