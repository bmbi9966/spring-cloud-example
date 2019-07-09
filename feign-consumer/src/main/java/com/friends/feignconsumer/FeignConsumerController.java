package com.friends.feignconsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignConsumerController {
    @Autowired
    private FeignConsumerService feignConsumerService;

    @GetMapping("feignClient")
    public  String ribbonClient(){
        return  feignConsumerService.feignClient();

    }
}
