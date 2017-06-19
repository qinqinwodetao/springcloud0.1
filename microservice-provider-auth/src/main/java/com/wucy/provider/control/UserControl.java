package com.wucy.provider.control;

import com.wucy.provider.dao.UserDao;
import com.wucy.provider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wucy on 2017/6/16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserControl {

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Integer id){
        return userDao.findOne(id);

    }

    @GetMapping(value = "/getAll")
    public List<User> getAll(){
        return userDao.findAll();

    }

}
