package com.order.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConf {

	/**
	 * 使RestTemplate具备负载均衡能力，依赖的是ribbon<br/>
	 * Ribbon将拦截RestTemplate发起的请求，并实现负载均衡<br/>
	 * 此时请求的url应该使用应用名称，如http://ftgo-user/user/validUser/
	 * 如果要请求注册中心之外的服务，需要再配置一个RestTemplate
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
