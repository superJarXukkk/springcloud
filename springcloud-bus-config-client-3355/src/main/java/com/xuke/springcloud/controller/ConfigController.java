package com.xuke.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//开启刷新
@RefreshScope
@RestController
@Slf4j
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/configInfo")
    public Object getInfo(){
        return configInfo;
    }
}
