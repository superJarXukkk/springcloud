package com.xuke.springcloud.service;


import com.springcloud.pojo.CommonResult;
import com.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentService {
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment);

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/discovery")
    public Object discovery();
}
