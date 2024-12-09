package com.zh.test;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement //开启事务
@MapperScan(basePackages = "com.zh.test.mapper")//开启mapper包扫描
@SpringBootConfiguration
public class TestApplicationStart {

    public static void main(String[] args) {
        SpringApplication.run(TestApplicationStart.class,args);
    }


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
