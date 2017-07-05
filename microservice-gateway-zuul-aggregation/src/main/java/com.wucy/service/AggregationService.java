package com.wucy.service;

/**
 * Created by wucy on 2017/6/27.
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wucy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;


/**
 * zuul 整合微服务
 */
@Service
public class AggregationService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserById(Integer id){


        return Observable.create(observer -> {
            User user = restTemplate.getForObject("http://microservice-client/user/{id}",User.class,id);
            observer.onNext(user);
            observer.onCompleted();
        });

    }



    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getConsumerUserById(Integer id){


        return Observable.create(observer -> {
            User user = restTemplate.getForObject("http://consumer-feign-hystrix-client/user/{id}",User.class,id);
            observer.onNext(user);
            observer.onCompleted();
        });

    }


    public User fallback(Integer id){
        User user = new User();
        user.setId(-1);
        user.setUserName("fallback");
        user.setPassword("********");
        return user;

    }


}
