package com.zyj.sharding.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyj.sharding.mbg.mapper.OrderItemMapper;
import com.zyj.sharding.mbg.mapper.OrderMapper;
import com.zyj.sharding.mbg.model.Order;
import com.zyj.sharding.mbg.model.OrderItem;
import com.zyj.sharding.service.DbShardingService;

@Service
public class DbShardingServiceImpl implements DbShardingService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderItemMapper orderItemMapper;
	
	@Override
	public void dbPreciseShardingInsert() {
		for (int i=0; i<5; i++) {
			Order order = new Order();
			order.setOrderNo("A000" + i);
			order.setUserId(Long.parseLong(i + ""));
            order.setCreateName("订单 " + i);
            order.setPrice(new BigDecimal("" + i));
            orderMapper.insert(order);
			
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderId(order.getOrderId());
			orderItem.setOrderNo("A000" + i);
			orderItem.setItemName("订单 " + i);
			orderItem.setPrice(new BigDecimal("" + i));
			orderItemMapper.insert(orderItem);
		}
		
	}

}
