package com.wucy.consumer.configuration;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wucy on 2017/6/16.
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public Contract feginContract(){
        return new feign.Contract.Default();
    }

}
