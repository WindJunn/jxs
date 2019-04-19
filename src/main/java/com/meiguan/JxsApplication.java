package com.meiguan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableCaching
public class JxsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JxsApplication.class, args);
    }

}
