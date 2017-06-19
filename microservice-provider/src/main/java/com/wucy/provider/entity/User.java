package com.wucy.provider.entity;

import javax.persistence.*;

/**
 * Created by wucy on 2017/6/15.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String userName;

    private String password;

    @ManyToOne
    @JoinColumn(name = "jedis_id")
    private Jedis jedis;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }
}
