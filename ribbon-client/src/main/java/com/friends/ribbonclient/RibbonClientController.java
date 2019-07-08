package com.friends.ribbonclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonClientController {

    @Value("${server.port}")
    private String port;

    @GetMapping("ribbonClient")
    public  String ribbonClient(){
        return "I'm ribbonClient: port is "+port;
    }
}
