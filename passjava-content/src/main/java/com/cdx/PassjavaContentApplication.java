package com.cdx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.cdx.passjava.content.dao")
public class PassjavaContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassjavaContentApplication.class, args);
    }

}
