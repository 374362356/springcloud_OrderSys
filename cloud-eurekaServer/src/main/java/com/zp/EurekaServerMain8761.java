package com.zp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain8761 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain8761.class,args);
    }
}
