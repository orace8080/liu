package com.prop;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @file	BaseProp.java
 * @desc	加载配置文件基类
 * @date	2015年6月16日
 * @author	li.hg
 */
public abstract class BaseProp {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseProp.class);

	protected static final String SUFFIX = ".properties";

	protected static String ENV_PATH = null;

	public static void setEnvPath(String envPath) {
		ENV_PATH = envPath;
	}

	/**
	 * 读取本地配置文件
	 * @param resourceName
	 * @return
	 * @throws Exception 
	 */
	protected static final Map<String, String> reloadByLocalConf(
			String resourceName) throws Exception {
		Map<String, String> result = null;
		try {
			ResourceBundle RESOURCE_BUNDLE = ResourceBundle
					.getBundle(resourceName);
			Set<String> keys = RESOURCE_BUNDLE.keySet();
			result = new HashMap<String, String>();
			for (String key : keys) {
				result.put(key, RESOURCE_BUNDLE.getString(key));
			}
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	/**
	 * 读取环境变量中的配置文件
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	protected static final Map<String, String> reloadByEnvConf(
			String filePath) throws Exception {
		Map<String, String> result = null;
		if (filePath != null) {
			InputStream in = null;
			try {
				in = new BufferedInputStream(new FileInputStream(filePath));
				Properties prop = new Properties();
				prop.load(in);
				result = new HashMap<String, String>();
				Set<Object> keys = prop.keySet();
				for (Object object : keys) {
					String key = object.toString();
					result.put(key, prop.getProperty(key));
				}

			} catch (Exception e) {
				throw e;
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					throw e;
				}
			}
		}
		return result;
	}
}
