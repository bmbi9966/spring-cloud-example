package com.friends.feignconsumer;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("RibbonClient")
public interface FeignConsumerService {
    @GetMapping("ribbonClient")
    String feignClient();
}
