package com.xuk.springcloud.service.impl;

import com.springcloud.pojo.Payment;
import com.xuk.springcloud.dao.PaymentDao;
import com.xuk.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }



    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
