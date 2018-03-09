package com.abin.lee.sharding.expand.api;

import com.abin.lee.sharding.expand.api.datasource.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by abin on 2018/3/9 13:18.
 * sharding-expand
 * com.abin.lee.sharding.expand.api
 */
@SpringBootApplication
@Import({DynamicDataSourceRegister.class})
public class ShardingExpandApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingExpandApplication.class, args);
    }


}
