package com.tang.core.result;

/** 
* @ClassName: ResultStatus 
* @Description: 成功失败状态码
* @author (TangGoooo)  
* @date 2018年1月26日 下午3:23:53 
* @version V1.0 
*/
public enum ResultStatus {
	SUCCESS(0),
	FAIL(1);
	private int status;
	
	ResultStatus(int status){
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
