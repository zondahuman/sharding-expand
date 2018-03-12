package com.abin.lee.sharding.expand.api.service.impl;

import com.abin.lee.sharding.expand.api.mapper.ShardMapper;
import com.abin.lee.sharding.expand.api.model.Shard;
import com.abin.lee.sharding.expand.api.model.ShardExample;
import com.abin.lee.sharding.expand.api.service.ShardService;
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
public class ShardServiceImpl implements ShardService {

    @Autowired
    ShardMapper shardMapper;


    @Override
    public void add(Shard model) {
        this.shardMapper.insert(model);
    }

    @Override
    public void update(Shard model) {
        this.shardMapper.updateByPrimaryKey(model);

    }

    @Override
    public void delete(Long id) {
        this.shardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Shard findById(Long id) {
        String tableName = "";
        return this.shardMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Shard> findAll() {
        ShardExample example = new ShardExample();
        List<Shard> modelList = this.shardMapper.selectByExample(example);
        return modelList;
    }

    @Override
    public String findDbNameByGroupId(Long id, Long shardGroupId) {
        ShardExample examples = new ShardExample();
        examples.createCriteria().andGroupIdEqualTo(shardGroupId);
        List<Shard> dbList = this.shardMapper.selectByExample(examples);
        Integer avaliableDbCount = 0;
        if (CollectionUtils.isEmpty(dbList)) {
            throw new RuntimeException("db count is not null");
        } else {
            avaliableDbCount = dbList.size();
        }
        long hashValue = id & (avaliableDbCount - 1);
        ShardExample example = new ShardExample();
        example.createCriteria().andGroupIdEqualTo(shardGroupId);
        List<Shard> modelList = this.shardMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(modelList)) {
            for (Shard shard : modelList) {
                if (shard.getHashValue().contains(String.valueOf(hashValue)))
                    return shard.getName();
            }
        } else {
            return null;
        }
        return null;
    }


    @Override
    public Long findShardIdByGroupId(Long id, Long shardGroupId) {
        ShardExample examples = new ShardExample();
        examples.createCriteria().andGroupIdEqualTo(shardGroupId);
        List<Shard> dbList = this.shardMapper.selectByExample(examples);
        Integer avaliableDbCount = 0;
        if (CollectionUtils.isEmpty(dbList)) {
            throw new RuntimeException("db count is not null");
        } else {
            avaliableDbCount = dbList.size();
        }
        long hashValue = id & (avaliableDbCount - 1);
        ShardExample example = new ShardExample();
        example.createCriteria().andGroupIdEqualTo(shardGroupId);
        List<Shard> modelList = this.shardMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(modelList)) {
            for (Shard shard : modelList) {
                if (shard.getHashValue().contains(String.valueOf(hashValue)))
                    return shard.getId();
            }
        } else {
            return null;
        }
        return null;
    }


}
