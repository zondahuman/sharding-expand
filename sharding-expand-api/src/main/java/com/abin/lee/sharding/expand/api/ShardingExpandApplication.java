package com.abin.lee.sharding.expand.api;

import com.abin.lee.sharding.expand.api.datasource.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * Created by abin on 2018/3/9 13:18.
 * sharding-expand
 * com.abin.lee.sharding.expand.api
 */
@SpringBootApplication
@Import({DynamicDataSourceRegister.class})
public class ShardingExpandApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(ShardingExpandApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ShardingExpandApplication.class, args);
    }


}
