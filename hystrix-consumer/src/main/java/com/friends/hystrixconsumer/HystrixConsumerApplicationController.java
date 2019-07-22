package com.friends.hystrixconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HystrixConsumerApplicationController {

   @Autowired
    HystrixConsumerApplicationServer hystrixConsumerApplicationServer;

    @GetMapping("getInstanceInfo")
    public String  getInstanceInfoxx(){
       return hystrixConsumerApplicationServer.getInstanceInfo();
    }

    @GetMapping("getInstanceInfoOverTime")
    public String  getInstanceInfoOverTime(){
        return hystrixConsumerApplicationServer.getInstanceInfoOverTime();
    }

    @GetMapping("hystrixHandleException")
    public String  hystrixHandleException(String name){
        return hystrixConsumerApplicationServer.hystrixHandleException(name);
    }

    @Autowired
    private FeignConsumerService feignConsumerService;
    @GetMapping("getInstanceInfoFromFeign")
    public String  getInstanceInfoFromFeign(){
         return feignConsumerService.getInstanceInfoFromFeign();
    }

  @Service
  class HystrixConsumerApplicationServer{
      @Autowired
      private RestTemplate restTemplate;
      @HystrixCommand(fallbackMethod = "rollBack")
      public String  getInstanceInfo(){
          return restTemplate.getForObject("http://hystrixClient/getInstanceInfo",String.class);
      }
      @HystrixCommand(fallbackMethod = "rollBack")
      public String  getInstanceInfoOverTime(){
          return restTemplate.getForObject("http://hystrixClient/getInstanceInfoOverTime",String.class);
      }
      public String rollBack(){
          return  "降级处理";
      }
      @HystrixCommand(fallbackMethod = "rollBackException",ignoreExceptions = {NullPointerException.class})
      public String hystrixHandleException(String name) {
          throw new RuntimeException("throw hystrixHandleException");
      }
      public String rollBackException(String name,Throwable t){
          return  name+":   "+t.getMessage();
      }
  }

}
