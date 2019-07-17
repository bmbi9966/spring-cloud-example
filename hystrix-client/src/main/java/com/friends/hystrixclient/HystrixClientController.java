package com.friends.hystrixclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
public class HystrixClientController {
    @Qualifier("eurekaRegistration")
    @Autowired
    private Registration registration;
    @GetMapping("getInstanceInfo")
    public String  getInstanceInfo(){
        String serviceId = registration.getServiceId();
        String host = registration.getHost();
        int port = registration.getPort();
        return serviceId+":"+port+";  "+"\nhost:"+host;
    }
    @GetMapping("getInstanceInfoOverTime")
    public String  getInstanceInfoOverTime() throws InterruptedException {
        int randomNumber = new Random().nextInt(300);
        Thread.sleep(randomNumber);
        System.out.println("sleepTime:"+ randomNumber);
        String serviceId = registration.getServiceId();
        String host = registration.getHost();
        int port = registration.getPort();
        return serviceId+":"+port+";  "+"\nhost:"+host;
    }


}
