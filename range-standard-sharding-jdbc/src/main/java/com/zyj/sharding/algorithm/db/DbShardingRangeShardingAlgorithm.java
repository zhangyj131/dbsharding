package com.zyj.sharding.algorithm.db;

import java.util.*;
import java.util.LinkedHashSet;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

public class DbShardingRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {

	int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

	@Override
	public Collection<String> doSharding(Collection<String> availableTargetNames,
			RangeShardingValue<Long> shardingValue) {
		Set<String> result = new LinkedHashSet<>();
        // between and 的起始值
        long lower = shardingValue.getValueRange().lowerEndpoint();
        long upper = shardingValue.getValueRange().upperEndpoint();
        // 循环范围计算分库逻辑
        for (long i = lower; i <= upper; i++) {
            for (String databaseName : availableTargetNames) {
                if (databaseName.endsWith(i % availableTargetNames.size() + "")) {
                    result.add(databaseName);
                }
            }
        }
        return result;
	}
}
