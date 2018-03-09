package com.abin.lee.sharding.expand.api.mapper;

import com.abin.lee.sharding.expand.api.model.ShardGroup;
import com.abin.lee.sharding.expand.api.model.ShardGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShardGroupMapper {
    int countByExample(ShardGroupExample example);

    int deleteByExample(ShardGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShardGroup record);

    int insertSelective(ShardGroup record);

    List<ShardGroup> selectByExample(ShardGroupExample example);

    ShardGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShardGroup record, @Param("example") ShardGroupExample example);

    int updateByExample(@Param("record") ShardGroup record, @Param("example") ShardGroupExample example);

    int updateByPrimaryKeySelective(ShardGroup record);

    int updateByPrimaryKey(ShardGroup record);
}