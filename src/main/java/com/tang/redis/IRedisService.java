package com.tang.redis;

import java.util.List;

/**
 * 
 * @ClassName: IRedisService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author (TangGoooo)
 * @date 2018年2月2日 上午10:40:21
 * @version V1.0
 */
public interface IRedisService {

	public boolean set(String key, String value);

	public String get(String key);

	public boolean expire(String key, long expire);

	public <T> boolean setList(String key, List<T> list);

	public <T> List<T> getList(String key, Class<T> clz);

	public long lpush(String key, Object obj);

	public long rpush(String key, Object obj);

	public String lpop(String key);
}
