package com.xuke.springcloud.service;


import org.springframework.stereotype.Component;

@Component
/*
下面解决业务逻辑混乱在一起的问题（解耦）：我们改在service层进行服务降级



 */
public class FallbackService implements FeignPaymentService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK ------fail";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut-----------fail";
    }
}
