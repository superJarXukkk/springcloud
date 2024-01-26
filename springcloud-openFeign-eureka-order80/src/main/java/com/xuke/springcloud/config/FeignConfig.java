package com.xuke.springcloud.config;


import feign.Logger;
import org.springframework.context.annotation.Configuration;

/*
openfeign打开日志管理的步骤：
    1.开启配置项并设定日志级别；
    2.在yml文件中设定feign日志以什么级别监控哪个接口

 */

@Configuration
public class FeignConfig {

    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
