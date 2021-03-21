package com.zyj.sharding.algorithm.db;

import java.util.*;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

public class DbShardingComplexShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {
	
	int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

	@Override
	public Collection<String> doSharding(Collection<String> availableTargetNames,
			ComplexKeysShardingValue<Long> shardingValue) {
//		Map<String, Collection<Long>> map = shardingValue.getColumnNameAndShardingValuesMap();
//		Collection<Long> tOrderIdCollection = map.get("order_id");
//		Collection<Long> tOrderItemCollection = map.get("t_order_item");
		// 得到每个分片健对应的值
        Collection<Long> orderIdValues = this.getShardingValue(shardingValue, "order_id");
        Collection<Long> userIdValues = this.getShardingValue(shardingValue, "item_id");

        List<String> shardingSuffix = new ArrayList<>();
        // 对两个分片健同时取模的方式分库
        for (Long userId : userIdValues) {
            for (Long orderId : orderIdValues) {
//                String suffix = userId % 2 + "_" + orderId % 2;
                String suffix = userId % 2 + orderId % 2 +"";
                for (String databaseName : availableTargetNames) {
                    if (databaseName.endsWith(suffix)) {
                        shardingSuffix.add(databaseName);
                    }
                }
            }
        }
        return shardingSuffix;
	}
	private Collection<Long> getShardingValue(ComplexKeysShardingValue<Long> shardingValues, final String key) {
        Collection<Long> valueSet = new ArrayList<>();
        Map<String, Collection<Long>> columnNameAndShardingValuesMap = shardingValues.getColumnNameAndShardingValuesMap();
        if (columnNameAndShardingValuesMap.containsKey(key)) {
            valueSet.addAll(columnNameAndShardingValuesMap.get(key));
        }
        return valueSet;
    }
}
