package com.wucy.main;


import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;

/**
 * Created by wucy on 2017/6/28.
 */
public class rxJava {


    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);




    }
}
