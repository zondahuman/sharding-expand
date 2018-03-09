package com.abin.lee.sharding.expand.api.service;

import com.abin.lee.sharding.expand.api.model.Shard;

import java.util.List;

/**
 * Created by abin on 2018/3/9 16:49.
 * sharding-expand
 * com.abin.lee.sharding.expand.api.service
 */
public interface ShardService {

    void add(Shard model);

    void update(Shard model);

    void delete(Long id);

    Shard findById(Long id);

    List<Shard> findAll();

    String findDbNameByGroupId(Long id, Long shardGroupId);

    Long findShardIdByGroupId(Long id, Long shardGroupId);


}
