package com.abin.lee.sharding.expand.api.logic.impl;

import com.abin.lee.sharding.expand.api.logic.LocationService;
import com.abin.lee.sharding.expand.api.service.FragmentService;
import com.abin.lee.sharding.expand.api.service.ShardGroupService;
import com.abin.lee.sharding.expand.api.service.ShardService;
import com.abin.lee.sharding.expand.api.util.ShardingExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by abin on 2018/3/9 17:26.
 * sharding-expand
 * com.abin.lee.sharding.expand.api.logic.impl
 */
@Service
@Slf4j
public class LocationServiceImpl implements LocationService {

    @Resource
    FragmentService fragmentService;
    @Resource
    ShardGroupService shardGroupService;
    @Resource
    ShardService shardService;

    @Autowired
    ShardingExchange shardingExchange;




    @Override
    public String locationDb(Long id) {
        Long shardGroupId = this.shardGroupService.findByIdRange(id);
        String dbName = this.shardService.findDbNameByGroupId(id, shardGroupId);
        return dbName;
    }



    @Override
    public String locationTable(Long id) {
        Long shardGroupId = this.shardGroupService.findByIdRange(id);
        Long shardId = this.shardService.findShardIdByGroupId(id, shardGroupId);
        String tableName = this.fragmentService.findTableNameById(id, shardId);
        return tableName;
    }














}
