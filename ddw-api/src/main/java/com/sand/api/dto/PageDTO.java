package com.sand.api.dto;

import java.util.List;

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
