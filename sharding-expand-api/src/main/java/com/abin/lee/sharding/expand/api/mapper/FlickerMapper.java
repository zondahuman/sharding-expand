package com.abin.lee.sharding.expand.api.mapper;

import com.abin.lee.sharding.expand.api.model.Flicker;

/**
 * Mybatis 接口传入多个参数 xml怎么接收
 * https://www.cnblogs.com/yanlong300/p/7550546.html
 * http://hackpro.iteye.com/blog/1913652
 *
 */
public interface FlickerMapper {


    Long insert(Flicker record);



}