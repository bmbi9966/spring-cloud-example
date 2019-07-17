package com.friends.hystrixclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HystrixClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixClientApplication.class, args);
    }
}
