package com.prop;

import java.io.File;
import java.util.Map;

/**
 * @file	RedisProperties.java
 * @desc	redis配置文件
 * @date	2015年5月15日
 * @author	li.hg
 */
public class RedisProp extends BaseProp{

	public final static String SWITCH = "redis.switch";
	public final static String MAX_ACTIVE = "redis.pool.maxActive";
	public final static String MAX_IDLE = "redis.pool.maxIdle";
	public final static String MAX_WAIT = "redis.pool.maxWait";
	public final static String TEST_ON_BORROW = "redis.pool.testOnBorrow";
	public final static String TEST_ON_RETURN = "redis.pool.testOnReturn";
	public final static String IP = "redis.ip";
	public final static String PORT = "redis.port";

	private static String resourceName = "prop/redis";
	private static Map<String, String> MAP = null;

	/**
	 * 获取是否支持缓存状态
	 * @return
	 */
	public static boolean isCache(){
		return getValue(SWITCH)!=null && "true".equals(getValue(SWITCH))?true:false;
	}
	
	public static String getValue(String key) {
		try {
			if (MAP == null) {
				synchronized (RedisProp.class) {
					if(MAP == null){
						if (ENV_PATH != null) {
							MAP = reloadByEnvConf(ENV_PATH + File.separator + resourceName + SUFFIX);
						} else {
							MAP = reloadByLocalConf(resourceName);
						}
					}
				}
			}
			return MAP.get(key);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}
}
