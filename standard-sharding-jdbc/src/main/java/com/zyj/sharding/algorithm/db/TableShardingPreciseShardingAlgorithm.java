package com.zyj.sharding.algorithm.db;

import java.util.Collection;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

public class TableShardingPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
		Long value = shardingValue.getValue();	//分片键值
		for (String tableName : availableTargetNames) {
			//取模算法会导致数据分散不均衡，因此采用hash
			int ii = 2 & hash(value);
			String sharding = ii + "";
			if (tableName.endsWith(sharding)) {
				System.err.println("分片表="+tableName);
				return tableName;//返回分片表t_order_0 -> t_order_2
			}
		}
		throw new IllegalArgumentException();
	}

	int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
