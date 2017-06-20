package com.wucy.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by wucy on 2017/6/15.
 */


@SpringBootApplication
@EnableEurekaClient
public class ConsumerRibbonApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApplication.class,args);


    }


}
