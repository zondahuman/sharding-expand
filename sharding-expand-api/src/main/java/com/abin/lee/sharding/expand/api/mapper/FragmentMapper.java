package com.abin.lee.sharding.expand.api.mapper;

import com.abin.lee.sharding.expand.api.model.Fragment;
import com.abin.lee.sharding.expand.api.model.FragmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FragmentMapper {
    int countByExample(FragmentExample example);

    int deleteByExample(FragmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Fragment record);

    int insertSelective(Fragment record);

    List<Fragment> selectByExample(FragmentExample example);

    Fragment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Fragment record, @Param("example") FragmentExample example);

    int updateByExample(@Param("record") Fragment record, @Param("example") FragmentExample example);

    int updateByPrimaryKeySelective(Fragment record);

    int updateByPrimaryKey(Fragment record);
}