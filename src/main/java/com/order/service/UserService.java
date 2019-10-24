package com.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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
	@HystrixCommand(fallbackMethod = "validUserFallback")
	String validUser(String userId) {
		String url = String.format("http://%s/user/validUser/%s", userService,userId);
		String result = restTemplate.postForObject(url, null, String.class);
		logger.info(result);
		return result;
	}
	// 降级方法需要和目标方法参数和返回类型一致
	public String validUserFallback(String userId){
		logger.info("validUser fallback");
		return "validUser fallback";
	}
}
