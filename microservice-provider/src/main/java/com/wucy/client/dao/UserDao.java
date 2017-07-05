package com.wucy.client.dao;

import com.wucy.client.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wucy on 2017/6/15.
 */
public interface UserDao extends JpaRepository<User,Integer>{

}
