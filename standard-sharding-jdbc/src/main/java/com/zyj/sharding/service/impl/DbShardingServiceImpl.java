package com.zyj.sharding.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyj.sharding.mbg.mapper.TOrderItemMapper;
import com.zyj.sharding.mbg.mapper.TOrderMapper;
import com.zyj.sharding.mbg.mapper.TUserMapper;
import com.zyj.sharding.mbg.model.TOrder;
import com.zyj.sharding.mbg.model.TOrderItem;
import com.zyj.sharding.mbg.model.TUser;
import com.zyj.sharding.service.DbShardingService;

@Service
public class DbShardingServiceImpl implements DbShardingService {

	@Autowired
	private TOrderMapper orderMapper;
	
	@Autowired
	private TOrderItemMapper orderItemMapper;
	
	@Autowired
	private TUserMapper tUserMapper;
	
	@Override
	public void dbPreciseShardingInsert() {
		for (int i=0; i<1; i++) {
			TOrder order = new TOrder();
			order.setOrderNo("A000" + i);
			order.setUserId(Long.parseLong(i + ""));
            order.setCreateName("订单-" + i);
            order.setPrice(new BigDecimal("" + i));
//            orderMapper.insert(order);
            orderMapper.insertSelective(order);//添加useGeneratedKeys="true" keyProperty="orderId" 这样插入返回主键，如此都用order_id分库，t_order和t_order_item落在同一库
            return;
		}
		for (int i=0; i<3; i++) {
			TOrder order = new TOrder();
			order.setOrderNo("A000" + i);
			order.setUserId(Long.parseLong(i + ""));
			order.setCreateName("订单-" + i);
			order.setPrice(new BigDecimal("" + i));
//            orderMapper.insert(order);
			orderMapper.insertSelective(order);//添加useGeneratedKeys="true" keyProperty="orderId" 这样插入返回主键，如此都用order_id分库，t_order和t_order_item落在同一库
			
			TOrderItem orderItem = new TOrderItem();
			orderItem.setOrderId(order.getOrderId());
			orderItem.setOrderNo("A000" + i);
			orderItem.setItemName("订单-" + i);
			orderItem.setPrice(new BigDecimal("" + i));
//			orderItemMapper.insert(orderItem);
			orderItemMapper.insertSelective(orderItem);
		}
		
	}

	@Override
	public void tablePreciseShardingInsert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void noneShardingInsert() {
		TUser tUser = new TUser();
		tUser.setAddress("浦东");
		tUser.setAge(11);
		tUser.setName("zhangsan");
//		tUser.setUserId(userId);
		tUserMapper.insert(tUser);
		
	}

}
