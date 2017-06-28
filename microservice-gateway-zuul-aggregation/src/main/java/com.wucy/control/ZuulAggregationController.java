package com.wucy.control;

import com.google.common.collect.Maps;
import com.wucy.entity.User;
import com.wucy.service.AggregationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;


/**
 * Created by wucy on 2017/6/27.
 */

@RestController
public class ZuulAggregationController {

    public static final Logger logger = LoggerFactory.getLogger(ZuulAggregationController.class);

    @Autowired
    private AggregationService aggregationService;



    @GetMapping("/aggregate/{id}")
    public DeferredResult<HashMap<String , User>> aggregate(@PathVariable Integer id){
        Observable<HashMap<String,User>> result = this.aggregateObservable(id);
        return this.toDefferredResult(result);
    }


    public Observable<HashMap<String, User>> aggregateObservable(Integer id){

        return Observable.zip(this.aggregationService.getUserById(id),
                this.aggregationService.getConsumerUserById(id),
                (user, consumerUser) -> {
                    HashMap<String,User> map = Maps.newHashMap();
                    map.put("user",user);
                    map.put("consumerUser",consumerUser);
                    return  map;
                });
    }



    public  DeferredResult<HashMap<String,User>> toDefferredResult(Observable<HashMap<String,User>> details){

        DeferredResult<HashMap<String, User>> result = new DeferredResult<>();

        details.subscribe(new Observer<HashMap<String, User>>() {
            @Override
            public void onCompleted() {
                logger.info("完成...");
            }

            @Override
            public void onError(Throwable e) {
                logger.error("发生错误...", e);
            }

            @Override
            public void onNext(HashMap<String, User> stringUserHashMap) {
                result.setResult(stringUserHashMap);
            }
        });



        return result;

    }




}
