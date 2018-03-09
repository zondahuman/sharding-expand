package com.abin.lee.sharding.expand.api.mapper;

import com.abin.lee.sharding.expand.api.model.Shard;
import com.abin.lee.sharding.expand.api.model.ShardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShardMapper {
    int countByExample(ShardExample example);

    int deleteByExample(ShardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Shard record);

    int insertSelective(Shard record);

    List<Shard> selectByExample(ShardExample example);

    Shard selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Shard record, @Param("example") ShardExample example);

    int updateByExample(@Param("record") Shard record, @Param("example") ShardExample example);

    int updateByPrimaryKeySelective(Shard record);

    int updateByPrimaryKey(Shard record);
}