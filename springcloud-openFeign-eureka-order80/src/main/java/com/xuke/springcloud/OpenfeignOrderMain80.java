package com.xuke.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//打开Openfeign主启动类
@EnableFeignClients
@EnableEurekaClient
public class OpenfeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignOrderMain80.class);
    }
}
