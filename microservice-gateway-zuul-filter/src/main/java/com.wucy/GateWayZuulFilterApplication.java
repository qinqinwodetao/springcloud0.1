package com.wucy;

import com.wucy.Filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by wucy on 2017/6/15.
 */


@SpringBootApplication
@EnableZuulProxy
public class GateWayZuulFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayZuulFilterApplication.class,args);
    }


    @Bean
    public PreRequestLogFilter getPreRequestLogFilter(){
        return new PreRequestLogFilter();
    }

}
