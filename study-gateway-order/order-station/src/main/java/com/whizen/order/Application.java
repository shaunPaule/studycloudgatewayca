package com.whizen.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication(scanBasePackages="com.whizen")
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args){
        SpringApplication.run(com.whizen.order.Application.class,args);
    }
}

