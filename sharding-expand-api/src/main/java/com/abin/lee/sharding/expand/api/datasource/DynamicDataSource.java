package com.abin.lee.sharding.expand.api.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    
	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceContextHolder.getDataSourceType();
	}
	
}