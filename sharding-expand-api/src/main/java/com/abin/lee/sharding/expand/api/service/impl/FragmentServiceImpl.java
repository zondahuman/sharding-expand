package com.abin.lee.sharding.expand.api.service.impl;

import com.abin.lee.sharding.expand.api.mapper.FragmentMapper;
import com.abin.lee.sharding.expand.api.model.Fragment;
import com.abin.lee.sharding.expand.api.model.FragmentExample;
import com.abin.lee.sharding.expand.api.model.Shard;
import com.abin.lee.sharding.expand.api.model.ShardExample;
import com.abin.lee.sharding.expand.api.service.FragmentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by abin on 2018/3/9 16:51.
 * sharding-expand
 * com.abin.lee.sharding.expand.api.service.impl
 */
@Service
@Slf4j
public class FragmentServiceImpl implements FragmentService {

    @Autowired
    FragmentMapper fragmentMapper;

    @Override
    public void add(Fragment model) {
        this.fragmentMapper.insert(model);
    }

    @Override
    public void update(Fragment model) {
        this.fragmentMapper.updateByPrimaryKey(model);

    }

    @Override
    public void delete(Long id) {
        this.fragmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Fragment findById(Long id) {
        String tableName = "";
        return this.fragmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Fragment> findAll() {
        FragmentExample example = new FragmentExample();
        List<Fragment> modelList = this.fragmentMapper.selectByExample(example);
        return modelList;
    }

    @Override
    public String findTableNameById(Long id, Long shardId) {
        FragmentExample example = new FragmentExample();
        example.createCriteria().andShardIdEqualTo(shardId).andStartIdLessThanOrEqualTo(id).andEndIdGreaterThanOrEqualTo(id);
        List<Fragment> modelList = this.fragmentMapper.selectByExample(example);
        if(CollectionUtils.isNotEmpty(modelList)){
            return modelList.get(0).getName() ;
        }else{
            return StringUtils.EMPTY ;
        }
    }
}
