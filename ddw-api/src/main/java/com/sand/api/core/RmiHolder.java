package com.sand.api.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sand.api.consts.ServiceConsts;

public class RmiHolder {
	private static final Logger LOG = LoggerFactory.getLogger(RmiHolder.class);

	private static List<String> transServiceList = new ArrayList<String>();
	private static List<String> merchantServiceList = new ArrayList<String>();
	private static List<String> reportServiceList = new ArrayList<String>();
	public static void put(String serviceType, List<String> services) {

		if (ServiceConsts.TRANS.equals(serviceType)) {
			transServiceList = new ArrayList<String>(services);
		} else if (ServiceConsts.MERCHANT.equals(serviceType)) {
			merchantServiceList = new ArrayList<String>(services);
		} else if(ServiceConsts.REPORT.equals(serviceType)){
			reportServiceList=new ArrayList<String>(services);
		}else {
			LOG.warn("未找到对应的服务类型 -> [{}]", serviceType);
		}
	}

	public static String getRmiUrl(String type) {
		List<String> tmp = getUrls(type);
		if (tmp == null || tmp.size() == 0) {
			throw new RuntimeException("没有可用的rmi服务");
		} else if (tmp.size() == 1) {
			return tmp.get(0);
		} else {
			int randomIndex = ThreadLocalRandom.current().nextInt(tmp.size());
			return tmp.get(randomIndex);
		}
	}

	private static List<String> getUrls(String type) {
		if (ServiceConsts.TRANS.equals(type)) {
			return transServiceList;
		} else if (ServiceConsts.MERCHANT.equals(type)) {
			return merchantServiceList;
		} else if (ServiceConsts.REPORT.equals(type)){
			return reportServiceList;
		}else{
			return null;
		}

	}
}
