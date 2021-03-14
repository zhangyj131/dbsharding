package com.zyj.sharding.algorithm.db;

import java.util.Collection;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

public class DbShardingPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
		Long value = shardingValue.getValue();	//分片键值
//		int size = availableTargetNames.size() - 1;
		for (String dbName : availableTargetNames) {
			//取模算法会导致数据分散不均衡，因此采用hash
//			String sharding = value % size + "";
			int ii = (availableTargetNames.size() - 2) & hash(value);//分片数据库必须是2^x个，我这里是db_0 -> db_3
			String sharding = ii + "";
			if (dbName.endsWith(sharding)) {
				System.err.println("分片库="+dbName);
				return dbName;//返回分片库db_0 -> db_3
			}
		}
		throw new IllegalArgumentException();
//		return null;
	}

	int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
