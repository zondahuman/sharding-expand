package com.abin.lee.sharding.expand.api.service.impl;

import com.abin.lee.sharding.expand.api.mapper.ShardGroupMapper;
import com.abin.lee.sharding.expand.api.model.ShardGroup;
import com.abin.lee.sharding.expand.api.model.ShardGroupExample;
import com.abin.lee.sharding.expand.api.service.ShardGroupService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by abin on 2018/3/9 16:50.
 * sharding-expand
 * com.abin.lee.sharding.expand.api.service.impl
 */
@Service
@Slf4j
public class ShardGroupServiceImpl implements ShardGroupService {


    @Autowired
    ShardGroupMapper shardGroupMapper;


    @Override
    public void add(ShardGroup model) {
        this.shardGroupMapper.insert(model);
    }

    @Override
    public void update(ShardGroup model) {
        this.shardGroupMapper.updateByPrimaryKey(model);

    }

    @Override
    public void delete(Long id) {
        this.shardGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ShardGroup findById(Long id) {
        String tableName = "";
        return this.shardGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ShardGroup> findAll() {
        ShardGroupExample example = new ShardGroupExample();
        List<ShardGroup> modelList = this.shardGroupMapper.selectByExample(example);
        return modelList;
    }


    @Override
    public Long findByIdRange(Long id) {
        ShardGroupExample example = new ShardGroupExample();
        example.createCriteria().andStartIdLessThanOrEqualTo(id).andEndIdGreaterThanOrEqualTo(id);
        List<ShardGroup> modelList = this.shardGroupMapper.selectByExample(example);
        if(CollectionUtils.isNotEmpty(modelList)){
            return modelList.get(0).getId() ;
        }else{
            return null ;

        }
    }





}
