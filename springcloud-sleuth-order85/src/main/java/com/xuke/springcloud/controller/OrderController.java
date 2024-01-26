package com.xuke.springcloud.controller;


import com.springcloud.pojo.CommonResult;
import com.springcloud.pojo.Payment;
import com.xuke.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private PaymentService service;

    @PostMapping(value = "/customer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        CommonResult commonResult = service.create(payment);
        return commonResult;
    }

    @GetMapping(value = "/customer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return service.getPaymentById(id);
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        return service.discovery();
    }


}
