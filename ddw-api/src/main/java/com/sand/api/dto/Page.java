package com.sand.api.dto;

/**
 * 一个分页对象.
 */
public class Page implements CacheObject {

	/**
	 * 页码默认为1
	 */
	private static int DEFAULT_PAGE = 1;
	/**
	 * 每页数量默认为10
	 */
	private static int DEFAULT_SIZE = 10;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int page;
	private int size;

	public Page() {
		this.page = DEFAULT_PAGE;
		this.size = DEFAULT_SIZE;
	}

	public Page(int page, int size) {
		this.page = page;
		this.size = size;
	}

	public Page(int page) {
		this(page, DEFAULT_SIZE);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", size=" + size + "]";
	}
}
