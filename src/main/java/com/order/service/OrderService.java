package com.order.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.model.Order;
/**
 * 订单服务业务逻辑
 * @author Administrator
 *
 */
@Service
public class OrderService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;

	public Order createOrder(String orderId, String userId) {
		// 验证用户有效性
		String result = restTemplate.postForObject("http://ftgo-user/user/validUser/"+userId, null, String.class);
		logger.info(result);
		Order order = new Order();
		order.setId(orderId);
		order.setCreateTime(new Date());
		order.setStatus("CREATE");
		order.setUserId(userId);
		// 略去了入库操作和消息发布操作
		return order;
	}
	
	
}
