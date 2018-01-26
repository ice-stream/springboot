package com.tang.core.kit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import com.tang.model.User;

/**
 * @ClassName: JsonKit
 * @Description: {@link JSON} 解析工具
 * @author (TangGoooo)
 * @date 2018年1月26日 下午4:00:31
 * @version V1.0
 */
public class JsonKit {

	public static String toJson(Object object) {
		return JSON.toJSONString(object);
	}

	public static <T> T parse(String text, Class<T> clazz) {
		return JSON.parseObject(text, clazz);
	}

	public static JSONObject parse(String text) {
		return JSON.parseObject(text);
	}

	public static void main(String[] args) {
		User user = new User(1, "TangGoooo", 24);
		String json = JsonKit.toJson(user);
		// System.out.println(json);
		User user2 = JsonKit.parse(json, User.class);
		System.out.println(user2.toString());
	}

}
