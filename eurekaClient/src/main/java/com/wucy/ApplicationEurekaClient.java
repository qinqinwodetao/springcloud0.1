package com.wucy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wucy on 2017/5/26.
 */
@SpringBootApplication
@EnableEurekaClient
public class ApplicationEurekaClient {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationEurekaClient.class , args);


    }


}
