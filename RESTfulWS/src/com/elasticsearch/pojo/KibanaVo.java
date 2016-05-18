package com.elasticsearch.pojo;

public class KibanaVo {
	
	private String message;
	
	private String request;
	
	private String date;
	
	

	public KibanaVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public KibanaVo(String message, String request, String date) {
		super();
		this.message = message;
		this.request = request;
		this.date = date;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
