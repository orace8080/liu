package com.util;

import java.util.List;

import com.redis.cache.CacheObject;

public class PageDTO<T> implements CacheObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3249567823457982341L;

	private int total;
	private List<T> data;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
