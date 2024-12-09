package com.zh.test.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RedissonConfig {
    private Logger logger =  LoggerFactory.getLogger(RedissonConfig.class);

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        //指定编码，默认编码为org.redisson.codec.JsonJacksonCodec
        //config.setCodec(new org.redisson.client.codec.StringCodec());
        config.useSingleServer()
                .setAddress("redis://" + host +":"+port)
                .setConnectionPoolSize(50)
                .setIdleConnectionTimeout(10000)
                .setConnectTimeout(3000)
                .setTimeout(3000)
                .setDatabase(5);
        RedissonClient redissonClient = Redisson.create(config);
        logger.info("redisson连接成功！！！");
        return redissonClient;
    }
}
