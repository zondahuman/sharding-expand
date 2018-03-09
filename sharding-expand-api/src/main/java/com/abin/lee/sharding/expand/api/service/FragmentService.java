package com.abin.lee.sharding.expand.api.service;

import com.abin.lee.sharding.expand.api.model.Business;
import com.abin.lee.sharding.expand.api.model.Fragment;

import java.util.List;

public interface FragmentService {

    void add(Fragment model);

    void update(Fragment model);

    void delete(Long id);

    Fragment findById(Long id);

    List<Fragment> findAll();

    String findTableNameById(Long id, Long shardId);


}