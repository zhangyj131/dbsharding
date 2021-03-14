package com.zyj.sharding.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyj.sharding.mbg.mapper.TOrderItemMapper;
import com.zyj.sharding.mbg.mapper.TOrderMapper;
import com.zyj.sharding.mbg.model.TOrder;
import com.zyj.sharding.mbg.model.TOrderItem;
import com.zyj.sharding.service.DbShardingService;

@Service
public class DbShardingServiceImpl implements DbShardingService {

	@Autowired
	private TOrderMapper orderMapper;
	@Autowired
	private TOrderItemMapper orderItemMapper;
	
	@Override
	public void dbPreciseShardingInsert() {
		for (int i=0; i<2000; i++) {
			TOrder order = new TOrder();
			order.setOrderNo("A000" + i);
			order.setUserId(Long.parseLong(i + ""));
            order.setCreateName("订单-" + i);
            order.setPrice(new BigDecimal("" + i));
//            orderMapper.insert(order);
            orderMapper.insertSelective(order);
            
			TOrderItem orderItem = new TOrderItem();
			orderItem.setOrderId(order.getOrderId());
			orderItem.setOrderNo("A000" + i);
			orderItem.setItemName("订单-" + i);
			orderItem.setPrice(new BigDecimal("" + i));
//			orderItemMapper.insert(orderItem);
			orderItemMapper.insertSelective(orderItem);
		}
		
	}

}
