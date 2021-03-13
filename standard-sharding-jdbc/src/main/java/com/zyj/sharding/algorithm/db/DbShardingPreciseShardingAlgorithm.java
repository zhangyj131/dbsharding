package com.zyj.sharding.algorithm.db;

import java.util.Collection;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

public class DbShardingPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
		Long value = shardingValue.getValue();	//分片键值
		for (String dbName : availableTargetNames) {
			String sharding = value % availableTargetNames.size() + "";
			if (dbName.endsWith(sharding)) {
				return dbName;
			}
		}
		throw new IllegalArgumentException();
//		return null;
	}

}
