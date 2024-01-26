package com.xuke.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//nacos自带负载均衡
public class NacosPayment8006Main {

    public static void main(String[] args) {
        SpringApplication.run(NacosPayment8006Main.class);
    }

}
