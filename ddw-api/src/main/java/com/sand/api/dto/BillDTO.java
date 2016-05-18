package com.sand.api.dto;

public class BillDTO implements CacheObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 交易日期
	 */
	private String date;
	/**
	 * 商户号
	 */
	private String mid;
	/**
	 * 商户名称
	 */
	private String mname;
	/**
	 * 商户结算金额
	 */
	private String totalAmt;

	public BillDTO(){
	}
	public BillDTO(String mid, String date, String totalAmt) {
		this.mid = mid;
		this.date = date;
		this.totalAmt = totalAmt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BillDTO{" +
				"date='" + date + '\'' +
				", mid='" + mid + '\'' +
				", mname='" + mname + '\'' +
				", totalAmt='" + totalAmt + '\'' +
				'}';
	}
}
