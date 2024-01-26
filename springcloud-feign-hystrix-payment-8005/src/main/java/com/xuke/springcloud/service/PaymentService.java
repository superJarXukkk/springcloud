package com.xuke.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    //正常访问的方法
    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfo_OK,id:  " + id + "\t" + "o(n_n)o哈哈·";
    }

    //超时访问的方法
    @HystrixCommand(fallbackMethod = "fallbackMethod",//超时回调方法)
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000")})//超时时间})
    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfo_Timeout,id:  " + id + "\t" + "o(n_n)o哈哈· 耗时" + timeNumber + "秒";
    }


    @HystrixCommand(fallbackMethod = "fallbackMethod",commandProperties ={
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    }) // 在10s内10次请求有60%失败 // 请求次数要先满足，再看百分比
    public String CircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("*****id 不为负数");
        }
        /**
         * huTool工具包的方法
         * 在自定义的cloud-api-commons里引入了
         */
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号： "+serialNumber;

    }

    public String fallbackMethod(Integer id){
        return "thread:" + Thread.currentThread().getName() + "fail";
    }
}