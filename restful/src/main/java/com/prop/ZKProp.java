package com.prop;

import java.io.File;
import java.util.Map;

public class ZKProp extends BaseProp {
	
	
	public final static String HOSTS = "zk.host";
	
	private static Map<String, String> MAP = null;

	private static String resourceName = "prop/zk";
	
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
