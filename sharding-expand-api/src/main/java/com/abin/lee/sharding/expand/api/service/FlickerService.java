package com.abin.lee.sharding.expand.api.service;

import com.abin.lee.sharding.expand.api.model.Flicker;
import com.abin.lee.sharding.expand.api.model.Shard;

import java.util.List;

/**
 * Created by abin on 2018/3/9 16:49.
 * sharding-expand
 * com.abin.lee.sharding.expand.api.service
 */
public interface FlickerService {

    Long add(Flicker model);

    Long insert(Flicker model);


    Long generate(Flicker model);


}
