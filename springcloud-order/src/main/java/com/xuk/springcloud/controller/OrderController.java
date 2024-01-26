package com.xuk.springcloud.controller;

import com.springcloud.pojo.CommonResult;
import com.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {
    //远程调用的地址
    public static final String PAYMENT_URL="http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",//请求地址
                payment,//请求参数
                CommonResult.class);//返回类型
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,//请求地址
                CommonResult.class);//返回类型
    }

    @GetMapping("/consumer/payment/discovery")
    public Object discovery(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/discovery",//请求地址
                DiscoveryClient.class);//返回类型
    }
}