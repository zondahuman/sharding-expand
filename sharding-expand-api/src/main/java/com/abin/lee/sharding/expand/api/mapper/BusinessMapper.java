package com.abin.lee.sharding.expand.api.mapper;

import com.abin.lee.sharding.expand.api.model.Business;
import com.abin.lee.sharding.expand.api.model.BusinessExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessMapper {
    int countByExample(BusinessExample example);

    int deleteByExample(BusinessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Business record);

    int insertSelective(Business record);

    List<Business> selectByExample(BusinessExample example);

    Business selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Business record, @Param("example") BusinessExample example);

    int updateByExample(@Param("record") Business record, @Param("example") BusinessExample example);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);
}