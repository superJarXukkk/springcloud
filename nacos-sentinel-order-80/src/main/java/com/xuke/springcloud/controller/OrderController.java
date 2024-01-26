package com.xuke.springcloud.controller;


import com.xuke.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {


    @Resource
    private PaymentService service;


    @GetMapping("/order/payment/get/{id}")
    public String get(@PathVariable("id") Integer id){
        return service.getPort(id);
    }

}
