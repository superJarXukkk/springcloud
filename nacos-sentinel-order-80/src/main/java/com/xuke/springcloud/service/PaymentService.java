package com.xuke.springcloud.service;


import com.xuke.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "nacos-sentinel-payment" ,fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
    public String getPort(@PathVariable("id") Integer id);
}
