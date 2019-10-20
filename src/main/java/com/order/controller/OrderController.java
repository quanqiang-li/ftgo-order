package com.order.controller;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Order;
import com.order.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

	public static ConcurrentHashMap<String, Order> OrderMap = new ConcurrentHashMap<>();
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("createOrder")
	public String createOrder(String orderId,String userId) {
		if(OrderMap.containsKey(orderId)) {
			//return "不能重复创建订单" + orderId;
		}
		Order order = orderService.createOrder(orderId, userId);
		OrderMap.put(orderId, order);
		return "创建订单成功"+orderId;
	}
}
