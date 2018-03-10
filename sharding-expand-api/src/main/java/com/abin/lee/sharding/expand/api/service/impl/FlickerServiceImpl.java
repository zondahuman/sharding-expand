package com.abin.lee.sharding.expand.api.service.impl;

import com.abin.lee.sharding.expand.api.datasource.LocationIdentity;
import com.abin.lee.sharding.expand.api.enums.DefaultDataType;
import com.abin.lee.sharding.expand.api.mapper.FlickerMapper;
import com.abin.lee.sharding.expand.api.mapper.ShardMapper;
import com.abin.lee.sharding.expand.api.model.Flicker;
import com.abin.lee.sharding.expand.api.model.Shard;
import com.abin.lee.sharding.expand.api.model.ShardExample;
import com.abin.lee.sharding.expand.api.service.FlickerService;
import com.abin.lee.sharding.expand.api.util.ShardingExchange;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by abin on 2018/3/9 16:50.
 * sharding-expand
 * com.abin.lee.sharding.expand.api.service.impl
 */
@Service
@Slf4j
public class FlickerServiceImpl implements FlickerService {

    @Autowired
    FlickerMapper flickerMapper;


    @Override
    @LocationIdentity(source = DefaultDataType.dataSource)
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public Long insert(Flicker model) {
        this.flickerMapper.insert(model);
        Long id = model.getId() ;
        return id;
    }

    @Override
    @LocationIdentity(source = DefaultDataType.dataSource)
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public Long add(Flicker model) {
        this.flickerMapper.add(model);
        Long id = model.getId() ;
        return id;
    }

    @Override
    @LocationIdentity(source = DefaultDataType.dataSource)
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public Long generate(Flicker model) {
        this.flickerMapper.generate(model);
        Long id = model.getId() ;
        return id;
    }





}
