package com.xuke.springcloud.service.impl;

import com.xuke.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;


@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public String getPort(Integer id) {
        return "客户端输入数据有错误";
    }
}
