package com.xuke.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrder80Main {

    public static void main(String[] args) {
        SpringApplication.run(NacosOrder80Main.class);
    }
}
