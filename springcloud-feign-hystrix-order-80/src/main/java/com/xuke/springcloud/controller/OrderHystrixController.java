package com.xuke.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xuke.springcloud.service.FeignPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
/*
hystrix服务降级方法2：进行全局配置，并对方法加上HystrixCommand注解；
 */
@DefaultProperties(defaultFallback = "global_fallbackMethod")
public class OrderHystrixController {

    @Resource
    private FeignPaymentService service;


    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = service.paymentInfo_OK(id);
        return result;
    }


    /*
    hystrix操作方式一，对特定方法进行特定fallback处理
    缺点：每个业务都需要一个特定的fallbackMethod，代码膨胀
     */
    @HystrixCommand(fallbackMethod = "fallbackMethod",//超时回调方法)
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",
                            value="1500")})//超时时间})
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = service.paymentInfo_TimeOut(id);
        return result;
    }

    public String fallbackMethod(Integer id){
        return "thread:" + Thread.currentThread().getName() + "fail";
    }

    public String global_fallbackMethod(){
        return "请稍后在尝试";
    }


}
