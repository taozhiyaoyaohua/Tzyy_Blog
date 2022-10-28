package com.tzyy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tzyy.mappers")
public class TzyyAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(TzyyAdminApplication.class,args);
    }
}
