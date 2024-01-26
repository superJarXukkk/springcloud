package com.xuke.springcloud.controller;


import com.springcloud.pojo.CommonResult;
import com.springcloud.pojo.Payment;
import com.xuke.springcloud.service.OpenfeignPaymentService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OpenfeignPaymentService service;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        CommonResult<Payment> paymentById = service.getPaymentById(id);
        return paymentById;
    }
}
