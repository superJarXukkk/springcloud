package com.xuk.springcloud.service;

import com.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
