package com.wucy.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by wucy on 2017/6/15.
 */


@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboardApplication.class,args);
    }


}
