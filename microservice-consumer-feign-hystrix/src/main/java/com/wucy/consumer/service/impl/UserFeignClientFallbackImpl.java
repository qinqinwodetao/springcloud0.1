package com.wucy.consumer.service.impl;

import com.wucy.consumer.entity.User;
import com.wucy.consumer.service.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * Created by wucy on 2017/6/22.
 */
@Component
public class UserFeignClientFallbackImpl implements UserFeignClient {

    @Override
    public User findUserById(Integer id) {
        User user = new User();
        user.setId(-1);
        user.setUserName("fallback");
        user.setPassword("88888888");
        return user;
    }
}
