package com.redis.cache;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prop.RedisProp;
import com.zook.api.conts.SystemConsts;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;





public class RedisCache implements Cache {

	
	private Logger LOG = LoggerFactory.getLogger(RedisCache.class);

	private final static int expireTime = 300;

	private JedisPool pool;

	{
		try {

			JedisPoolConfig config = new JedisPoolConfig();
//			config.setMaxActive(Integer.valueOf(RedisProp.getValue(RedisProp.MAX_ACTIVE)));
			config.setMaxIdle(Integer.valueOf(RedisProp.getValue(RedisProp.MAX_IDLE)));
//			config.setMaxWait(Long.valueOf(RedisProp.getValue(RedisProp.MAX_WAIT)));
			config.setTestOnBorrow(Boolean.valueOf(RedisProp.getValue(RedisProp.TEST_ON_BORROW)));
			config.setTestOnReturn(Boolean.valueOf(RedisProp.getValue(RedisProp.TEST_ON_RETURN)));
			
			pool = new JedisPool(config, RedisProp.getValue(RedisProp.IP),
					Integer.valueOf(RedisProp.getValue(RedisProp.PORT)));
			LOG.info("redis cache init over, -> {}", pool);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	private Jedis getResource() {
		try {
			Jedis j = this.pool.getResource();
			return j;
		} catch (Exception e) {
			return null;
		}
	}

	public String get(String key) {
		return get(key, String.class);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String key, Class<T> clazz) {
		if(!RedisProp.isCache()){
			return null;
		}
		Jedis jedis = getResource();

		try {
			if (jedis == null)
				return null;

			byte[] result = jedis.get(key.getBytes(SystemConsts.CHARSET));
			if (result == null) {
				return null;
			}
			return (T) SerializationUtils.deserialize(result);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			colse(jedis);
		}
		return null;
	}

	public boolean put(byte[] key, byte[] value) {
		if(!RedisProp.isCache()){
			return false;
		}
		Jedis jedis = getResource();

		try {
			if (jedis == null)
				return false;
			jedis.setex(key, expireTime, value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			colse(jedis);
		}
		return true;
	}

	public boolean putObj(final String key, final List<CacheObject> obj) {
		byte[] bt = SerializationUtils.serialize((ArrayList<CacheObject>) obj);
		try {
			put(key.getBytes(SystemConsts.CHARSET), bt);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean putStr(String key, String value) {
		try {
			return put(key.getBytes(SystemConsts.CHARSET), value.getBytes(SystemConsts.CHARSET));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void colse(Jedis jedis) {
		if (jedis != null)
			pool.returnResource(jedis);
	}
}
