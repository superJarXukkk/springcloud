package com.xuke.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {


    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/get/{id}")
    public String getPort(@PathVariable("id") Integer id){
        if(id == 4){
            throw new RuntimeException("数据接受错误");
        }
        return "接收端口: " + port;
    }
}
