package com.meiguan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.meiguan.dao")
public class JxsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JxsApplication.class, args);
    }

}
