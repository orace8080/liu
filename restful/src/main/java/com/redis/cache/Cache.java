package com.redis.cache;

import java.util.List;



public interface Cache {

	public String get(String key);

	public <T> T get(String key, Class<T> clazz);

	public boolean put(byte[] key, byte[] value);

	public boolean putObj(String key, List<CacheObject> obj);

	public boolean putStr(String key, String value);
}
