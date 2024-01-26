package com.xuke.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
public class OrderController {
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;
    @Resource
    private RestTemplate template;

    @GetMapping("/customer/payment/get")
    public String get(){
        return template.getForObject(serviceUrl + "/payment/get",String.class);
    }

}
