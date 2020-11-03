package com.zp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
/*@EnableEurekaClient
@EnableDiscoveryClient      //重要*/
@MapperScan("com.zp.dao")
public class ProviderOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(ProviderOrderMain.class,args);
    }
}
