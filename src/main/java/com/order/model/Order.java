package com.order.model;

import java.util.Date;
/**
 * 订单类
 * @author Administrator
 *
 */
public class Order {

	/**
	 * 订单id
	 */
	private String id;
	/**
	 * 订单状态，准备，快递，支付
	 */
	private String status;
	
	/**
	 * 下单时间
	 */
	private Date createTime;
	/**
	 * 下单者Id
	 */
	private String userId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
