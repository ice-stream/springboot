package com.tang.core.kit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.tang.entity.User;

/**
 * @ClassName: JsonKit
 * @Description: {@link JSON} 解析工具
 * @author (TangGoooo)
 * @date 2018年1月26日 下午4:00:31
 * @version V1.0
 */
public class JsonKit {
	
    private static Gson gson = null; 
	
	static{
		gson  = new Gson();//todo yyyy-MM-dd HH:mm:ss 
	}
	
	public static synchronized Gson newInstance(){
		if(gson == null){
			gson =  new Gson();
		}
		return gson;
	}

	public static String toJson(Object object) {
		return JSON.toJSONString(object);
	}

	public static <T> T parse(String text, Class<T> clazz) {
		return JSON.parseObject(text, clazz);
	}

	public static JSONObject parse(String text) {
		return JSON.parseObject(text);
	}
	public static <T> Map<String, T> toMap(String json,Class<T> clz){
		 Map<String, JsonObject> map = gson.fromJson(json, new TypeToken<Map<String,JsonObject>>(){}.getType());
		 Map<String, T> result = new HashMap<>();
		 for(String key:map.keySet()){
			 result.put(key,gson.fromJson(map.get(key),clz) );
		 }
		 return result;
	}
	
	public static Map<String, Object> toMap(String json){
		 Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String,Object>>(){}.getType());
		 return map;
	}
	
	public static <T> List<T> toList(String json,Class<T> clz){
		JsonArray array = new JsonParser().parse(json).getAsJsonArray();  
		List<T> list  = new ArrayList<>();
		for(final JsonElement elem : array){  
	         list.add(gson.fromJson(elem, clz));
	    }
	    return list;
	}

	public static void main(String[] args) {
		User user = new User(1L, "TangGoooo", 24L);
		String json = JsonKit.toJson(user);
		// System.out.println(json);
		User user2 = JsonKit.parse(json, User.class);
		System.out.println(user2.toString());
	}

}
