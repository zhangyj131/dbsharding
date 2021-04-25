package com.zyj.sharding.hook;

import java.util.Map;

import org.apache.shardingsphere.core.execute.hook.SQLExecutionHook;
import org.apache.shardingsphere.core.metadata.datasource.DataSourceMetaData;
import org.apache.shardingsphere.core.route.RouteUnit;

public class CustomShardingSQLExecutionHook implements SQLExecutionHook {

	@Override
	public void start(RouteUnit routeUnit, DataSourceMetaData dataSourceMetaData, boolean isTrunkThread,
			Map<String, Object> shardingExecuteDataMap) {
		// TODO Auto-generated method stub
		System.err.println("start");
	}

	@Override
	public void finishSuccess() {
		// TODO Auto-generated method stub
		System.err.println("finishSuccess");

	}

	@Override
	public void finishFailure(Exception cause) {
		// TODO Auto-generated method stub
		System.err.println("finishFailure");

	}

}
