package com.zp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zp.dao")
public class ProviderUserMain8040 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserMain8040.class,args);
    }
}
