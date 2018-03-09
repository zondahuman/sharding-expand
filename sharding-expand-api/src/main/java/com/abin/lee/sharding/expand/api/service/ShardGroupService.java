package com.abin.lee.sharding.expand.api.service;

import com.abin.lee.sharding.expand.api.model.ShardGroup;

import java.util.List;

/**
 * Created by abin on 2018/3/9 16:49.
 * sharding-expand
 * com.abin.lee.sharding.expand.api.service
 */
public interface ShardGroupService {

    void add(ShardGroup model);

    void update(ShardGroup model);

    void delete(Long id);

    ShardGroup findById(Long id);

    List<ShardGroup> findAll();

    Long findByIdRange(Long id);



}
