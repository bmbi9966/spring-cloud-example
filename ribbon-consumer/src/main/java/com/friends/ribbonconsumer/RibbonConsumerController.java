package com.friends.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class RibbonConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("ribbonClient")
    public  String ribbonClient(){
        return  restTemplate.getForObject("http://RibbonClient/ribbonClient",String.class);

    }

    @Autowired
    private LoadBalancerClient loadBalancer;
    public void doStuff() {
        ServiceInstance instance = loadBalancer.choose("stores");
        URI storesUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
        // ... do something with the URI
    }
}

