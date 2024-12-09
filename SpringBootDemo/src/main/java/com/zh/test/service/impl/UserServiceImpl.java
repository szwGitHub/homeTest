package com.zh.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zh.test.mapper.TestUserMapper;
import com.zh.test.model.request.UserDTO;
import com.zh.test.pojo.TestUser;
import com.zh.test.service.UserService;
import com.zh.test.util.JedisUtils;
import com.zh.test.util.RedissonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

   Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    TestUserMapper testUserMapper;

    @Autowired
    JedisUtils jedisUtils;

    @Autowired
    RedissonUtils redissonUtils;
    @Override
    public int insertUser(UserDTO userDTO) {
        logger.info("新增用户信息开始！！！！！！");
        TestUser testUser = new TestUser();
        testUser.setName(userDTO.getName());
        testUser.setGender(userDTO.getGender());
        testUser.setPassword(userDTO.getPassword());
        int insert = testUserMapper.insert(testUser);
        logger.info("新增用户信息结束！！！！！！"+insert);
        return insert;

    }

    @Override
    @Cacheable(value = "user", keyGenerator = "keyGenerator")
    public Map<String, Object> findUserByName(String name) {
        logger.info("查询数据开始！！！！！！！！！！！！！！！！！");
        List<TestUser> userList = testUserMapper.selectByName(name);
        logger.info("查询数据结束！！！！！！！！！！！！！！！！！"+userList);
        if (!CollectionUtils.isEmpty(userList)){
            Map<String, Object> map = new HashMap<>();
            map.put(name,userList);
            return map;
        }
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Object> findUserById(String id) {
        Map<String, Object> map = new HashMap<>();
        Jedis jedis = jedisUtils.getJedis();
        String value = jedis.get(id);
        if(StringUtils.hasText(value)){
            System.out.println("redis中的数据信息:"+value);
            TestUser testUser = JSONObject.parseObject(value, TestUser.class);
            map.put(id,testUser);
        }else {
            TestUser user = testUserMapper.selectByPrimaryKey(Integer.valueOf(id));
            if (!ObjectUtils.isEmpty(user)){
                jedis.set(id, JSON.toJSONString(user));
                map.put(id,user);
            }
        }
        jedisUtils.close(jedis);
        return map;
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        try {
            redissonUtils.getLock(String.valueOf(userDTO.getId()), 5);
            logger.info("上锁成功！！！！");
            TestUser testUser = new TestUser();
            BeanUtils.copyProperties(userDTO, testUser);
            testUserMapper.updateByPrimaryKeySelective(testUser);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("修改失败！！！！");
        }finally {
            redissonUtils.unLock(String.valueOf(userDTO.getId()));
            logger.info("解锁成功");
        }

    }
}
