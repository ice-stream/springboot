package com.tang.core.result;

import com.tang.core.kit.JsonKit;

/**
 * @ClassName: Result
 * @Description: 统一的接口返回对象
 * @author (TangGoooo)
 * @date 2018年1月26日 下午3:11:11
 * @version V1.0
 */
public class Result {
	

	private String message; // 请求失败说明，请求成功可以忽略
	private Integer status; // 状态码
	private Object data; // 接口返回的具体内容（json格式），如果失败可以忽略

	/**
	 * 
	* @Title:  
	* @Description: TODO  
	* @param @param message 消息
	* @param @param status  状态
	* @param @param data    数据
	 */
	public Result(String message, Integer status, Object data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}
	
	public Result(String message, Integer status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JsonKit.toJson(this);
	}

}
