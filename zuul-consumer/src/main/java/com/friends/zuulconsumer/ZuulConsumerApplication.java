package com.friends.zuulconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringCloudApplication
@RestController
public class ZuulConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulConsumerApplication.class, args);
    }

    @Qualifier("eurekaRegistration")
    @Autowired
    private Registration registration;

    @GetMapping("getInstanceServiceIdAndPort")
    public String  getInstanceServiceIdAndPort(){
        String serviceId = registration.getServiceId();
        int port = registration.getPort();
        return serviceId+":"+port;
    }

    @GetMapping("getInstanceServiceIdAndPortWithThrowError")
    @HystrixCommand(fallbackMethod = "rollBack")
    public String  getInstanceServiceIdAndPortWithThrowError(){
        int port = registration.getPort();
       throw  new RuntimeException("go away!!"+"and  port is : "+port);
    }
    public String  rollBack(Throwable e){
        return "throw error is : "+e.getMessage();
    }

}
