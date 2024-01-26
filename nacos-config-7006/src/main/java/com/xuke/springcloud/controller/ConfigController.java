package com.xuke.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/config/getInfo")
    public String getInfo(){
        return info;
    }
}
