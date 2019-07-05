package com.friends.eurekaserverpeerawareness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerPeerAwarenessApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerPeerAwarenessApplication.class, args);
    }

}
