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
public class DbShardingController {

	@Autowired
	private DbShardingService dbShardingService;
	
	@RequestMapping(value = "/dbPrecise", method = RequestMethod.GET)
	public CommonResult<String> insert() {
		dbShardingService.dbPreciseShardingInsert();
		return CommonResult.success(null);
	}
}
