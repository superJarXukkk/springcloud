package com.xuke.springcloud.service;


import com.springcloud.pojo.CommonResult;
import com.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//
@Component
@FeignClient("cloud-payment-service")
public interface OpenfeignPaymentService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
