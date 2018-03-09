package com.abin.lee.sharding.expand.api.mapper;

import com.abin.lee.sharding.expand.api.model.Order;
import com.abin.lee.sharding.expand.api.model.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mybatis 接口传入多个参数 xml怎么接收
 * https://www.cnblogs.com/yanlong300/p/7550546.html
 * http://hackpro.iteye.com/blog/1913652
 *
 */
public interface OrderMapper {
    int countByExample(@Param("tableName") String tableName, @Param("example") OrderExample example);

    int deleteByExample(@Param("tableName") String tableName, @Param("example") OrderExample example);

    int deleteByPrimaryKey(@Param("tableName") String tableName, @Param("id") Long id);

//    int insert(@Param("record") Order record);
    int insert(@Param("tableName") String tableName, @Param("record") Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(@Param("tableName") String tableName, @Param("example") OrderExample example);

    Order selectByPrimaryKey(@Param("tableName") String tableName, @Param("id") Long id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(@Param("tableName") String tableName, @Param("record") Order record);
}