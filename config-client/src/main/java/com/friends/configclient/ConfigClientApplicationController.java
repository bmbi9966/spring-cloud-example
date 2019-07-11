package com.friends.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientApplicationController {
    @Value("${config}")
    private String configString;

    @GetMapping("configString")
    public String configString(){
        return configString;
    }

    @Value("${config-comm}")
    private String configCommString;

    @GetMapping("configCommString")
    public String configCommString(){
        return configCommString;
    }



}
