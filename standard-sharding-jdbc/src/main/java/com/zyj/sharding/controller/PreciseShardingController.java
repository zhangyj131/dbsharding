package com.zyj.sharding.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyj.sharding.common.CommonResult;
import com.zyj.sharding.service.DbShardingService;

@RestController
@RequestMapping("/sharding")
public class PreciseShardingController {

	@Autowired
	private DbShardingService dbShardingService;
	
	/**
	 * 精准分库
	 * @return
	 */
	@RequestMapping(value = "/db/precise", method = RequestMethod.GET)
	public CommonResult<String> insertDb() {
		dbShardingService.dbPreciseShardingInsert();
		return CommonResult.success(null);
	}
	
	/**
	 * 精准分表
	 * @return
	 */
	@RequestMapping(value = "/table/precise", method = RequestMethod.GET)
	public CommonResult<String> insertTable() {
		dbShardingService.tablePreciseShardingInsert();
		return CommonResult.success(null);
	}
	
	/**
	 * 不分库分表，走默认库dbx
	 * @return
	 */
	@RequestMapping(value = "/none", method = RequestMethod.GET)
	public CommonResult<String> noneSharding() {
		dbShardingService.noneShardingInsert();
		return CommonResult.success(null);
	}
}
