package com.sand.api.dto;

public class TransRecordFullDTO implements CacheObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 项目编号 */
	private String pcode;
	/** 商户号 */
	private String mid;
	/** 终端号 */
	private String tid;
	/** 卡交易号 */
	private String card;
	/** 交易日期 yyyyMMdd */
	private String transDate;
	/** 交易时间 yyyyMMdd */
	private String transTime;
	/** 交易类型 */
	private String transType;

	/** 交易金额 */
	private String transAmt;
	/** 结算金额 */
	private String stlAmt;
	/** 交易手续费 */
	private String fee;
	/** 交易结果标志 */
	private String result;

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getStlAmt() {
		return stlAmt;
	}

	public void setStlAmt(String stlAmt) {
		this.stlAmt = stlAmt;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
