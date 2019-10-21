package com.order.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.model.Order;

/**
 * 订单服务业务逻辑
 * 
 * @author Administrator
 *
 */
@Service
public class OrderService {

	@Autowired
	private UserService userService;

	public Order createOrder(String orderId, String userId) {
		// 验证用户有效性
		String validUser = userService.validUser(userId);
		Order order = new Order();
		order.setId(orderId);
		order.setCreateTime(new Date());
		order.setStatus("CREATE");
		order.setUserId(userId);
		order.setRemark(validUser);
		// 略去了入库操作和消息发布操作
		return order;
	}

}
