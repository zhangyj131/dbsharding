package com.zyj.sharding.service;

public interface DbShardingService {
	public void dbPreciseShardingInsert();
	public void tablePreciseShardingInsert();
	public void noneShardingInsert();
}
