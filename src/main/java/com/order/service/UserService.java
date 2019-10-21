package com.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${service.ftgo.user}")
	private String userService;
	
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 验证用户有效性
	 * 
	 * @param userId
	 * @return
	 */
	String validUser(String userId) {
		String url = String.format("http://%s/user/validUser/%s", userService,userId);
		String result = restTemplate.postForObject(url, null, String.class);
		logger.info(result);
		return result;
	}
}
