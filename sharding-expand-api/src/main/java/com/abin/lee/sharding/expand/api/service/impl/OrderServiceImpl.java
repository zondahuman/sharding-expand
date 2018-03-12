package com.abin.lee.sharding.expand.api.service.impl;

import com.abin.lee.sharding.expand.api.datasource.SelectIdentity;
import com.abin.lee.sharding.expand.api.enums.DataSourceType;
import com.abin.lee.sharding.expand.api.logic.LocationService;
import com.abin.lee.sharding.expand.api.mapper.OrderMapper;
import com.abin.lee.sharding.expand.api.model.Order;
import com.abin.lee.sharding.expand.api.model.OrderExample;
import com.abin.lee.sharding.expand.api.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by abin on 2018/2/25 0:12.
 * sharding-dbtable
 * com.abin.lee.sharding.dbtable.api.service.impl
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    LocationService locationService;


    @Override
    @SelectIdentity(source = DataSourceType.master)
//    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(Long userId, Order model) {
        String tableName = this.locationService.locationTable(userId);
        log.info("TABLENAME-------------= " + tableName);
        this.orderMapper.insert(tableName, model);
//        if(true)
//            throw new RuntimeException("throw an own define exception ! ");
    }

    @Override
    @SelectIdentity(source = DataSourceType.master)
//    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Long id, Order model) {
        String tableName = this.locationService.locationTable(id);
        log.info("TABLENAME-------------= " + tableName);
        Order order = this.orderMapper.selectByPrimaryKey(tableName, id);
        if (ObjectUtils.notEqual(null, order)) {
            order.setBusinessId(model.getBusinessId());
            order.setId(model.getId());
            order.setOrderName(model.getOrderName());
            order.setUpdateTime(model.getUpdateTime());
            order.setVersion(model.getVersion());
        }
        this.orderMapper.updateByPrimaryKey(tableName, order);

    }

    @Override
    @SelectIdentity(source = DataSourceType.master)
//    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        String tableName = this.locationService.locationTable(id);
        log.info("TABLENAME-------------= " + tableName);
        this.orderMapper.deleteByPrimaryKey(tableName, id);
    }

    @Override
    @SelectIdentity(source = DataSourceType.master)
//    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteByParams(Long id, String orderName) {
        String tableName = this.locationService.locationTable(id);
        log.info("TABLENAME-------------= " + tableName);
        OrderExample example = new OrderExample();
        String condition = "%" + orderName + "%";
        example.createCriteria().andOrderNameLike(condition);
        this.orderMapper.deleteByExample(tableName, example);

    }

    @Override
    @SelectIdentity(source = DataSourceType.slave)
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Order findById(Long id) {
        String tableName = this.locationService.locationTable(id);
        log.info("TABLENAME-------------= " + tableName);
        return this.orderMapper.selectByPrimaryKey(tableName, id);
    }


    /**
     * 严格来说这个方法不对，这里只是为了测试下使用方法，正常来说这个方法是通过ES或者Hive来实现
     *
     * @param id
     * @param orderName
     * @return
     */
    @Override
//    @ShardingCache(expiry=7200)//缓存2小时
    @SelectIdentity(source = DataSourceType.slave)
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Order> findByParams(Long id, String orderName) {
        String tableName = this.locationService.locationTable(id);
        log.info("TABLENAME-------------= " + tableName);
        OrderExample example = new OrderExample();
        String condition = "%" + orderName + "%";
        example.createCriteria().andOrderNameLike(condition);
        List<Order> list = this.orderMapper.selectByExample(tableName, example);
        return list;
    }

    /**
     * 严格来说这个方法不对，这里只是为了测试下使用方法，正常来说这个方法是通过ES或者Hive来实现
     *
     * @return
     */
    @Override
    @SelectIdentity(source = DataSourceType.slave)
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Order> findAll() {
        OrderExample example = new OrderExample();
        List<Order> businessList = this.orderMapper.selectByExample("", example);
        return businessList;
    }

    /**
     * 严格来说这个方法不对，这里只是为了测试下使用方法，正常来说这个方法是通过ES或者Hive来实现
     *
     * @param id
     * @param orderName
     * @return
     */
    @Override
    @SelectIdentity(source = DataSourceType.slave)
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public int countByParams(Long id, String orderName) {
        String tableName = this.locationService.locationTable(id);
        log.info("TABLENAME-------------= " + tableName);
        OrderExample example = new OrderExample();
        String condition = "%" + orderName + "%";
        example.createCriteria().andOrderNameLike(condition);
        Integer total = this.orderMapper.countByExample(tableName, example);
        return total;
    }


}
