package com.xuke.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    private final static String INVOKE_URL = "http://cloud-zookeeper-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/zk")
    public String getMes(){
        String res = restTemplate.getForObject(INVOKE_URL + "/payment/get/zk", String.class);
        return res;
    }
}
