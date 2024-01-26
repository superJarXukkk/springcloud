package com.xuke.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;



    @RequestMapping("/payment/get")
    public String getInfo(){

        return serverPort;
    }


}
