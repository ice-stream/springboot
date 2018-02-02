package com.tang.redis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.mockito.internal.configuration.injection.filter.FinalMockCandidateFilter;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.tang.core.kit.JsonKit;





@Service
public class RedisServiceImpl implements IRedisService {

	@Resource
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public boolean set(final String key,final String value) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				connection.set(serializer.serialize(key), serializer.serialize(value));
				return true;
			}

		});

		return result;
	}

	@Override
	public String get(final String key) {
		String result = redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte[] value = connection.get(serializer.serialize(key));
				return serializer.deserialize(value);
			}
		});
		return result;
	}

	@Override
	public boolean expire(final String key, final long expire) {
		return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
	}

	@Override
	public <T> boolean setList(String key, List<T> list) {
		String value = JSON.toJSONString(list);
		return set(key, value);
	}

	@Override
	public <T> List<T> getList(String key, Class<T> clz) {
		String json = get(key);  
        if(json!=null){  
            List<T> list = JsonKit.toList(json, clz);  
            return list;  
        }  
        return null;
	}

	@Override
	public long lpush(String key, Object obj) {
		final String value = JsonKit.toJson(obj);  
        long result = redisTemplate.execute(new RedisCallback<Long>() {  
            @Override  
            public Long doInRedis(RedisConnection connection) throws DataAccessException {  
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
                long count = connection.lPush(serializer.serialize(key), serializer.serialize(value));  
                return count;  
            }  
        });  
        return result;  
	}

	@Override
	public long rpush(String key, Object obj) {
		 final String value = JsonKit.toJson(obj);  
	        long result = redisTemplate.execute(new RedisCallback<Long>() {  
	            @Override  
	            public Long doInRedis(RedisConnection connection) throws DataAccessException {  
	                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
	                long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));  
	                return count;  
	            }  
	        });  
	        return result;  
	}

	@Override
	public String lpop(String key) {
		String result = redisTemplate.execute(new RedisCallback<String>() {  
            @Override  
            public String doInRedis(RedisConnection connection) throws DataAccessException {  
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
                byte[] res =  connection.lPop(serializer.serialize(key));  
                return serializer.deserialize(res);  
            }  
        });  
        return result;  
	}

}
