package com.tang.core.result;

import com.tang.core.kit.JsonKit;

/**
 * @ClassName: ResultGnerator
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author (TangGoooo)
 * @date 2018年1月26日 下午3:47:12
 * @version V1.0
 */
public class ResultGenerator {

    public static Result successs(){
		return  new Result("", ResultStatus.SUCCESS.getStatus());
	}
    
	public static Result successWithData(Object data) {
		return new Result("", ResultStatus.SUCCESS.getStatus(), data);
	}
	
	public Result fail(String message){
		return new Result(message,ResultStatus.FAIL.getStatus());
	}

	
	
}
