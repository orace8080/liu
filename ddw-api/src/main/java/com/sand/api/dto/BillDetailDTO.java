package com.sand.api.dto;

public class BillDetailDTO implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商户号
	 */
	private String mid;
	/**
	 * 终端号
	 */
	private String tid;
	/**
	 * 交易名称
	 */
	private String mname;
	/**
	 * 交易卡号
	 */
	private String cardNo;
	/**
	 * 交易类型
	 */
	private String type;
	/**
	 * 交易结算金额
	 */
	private String settleAmount;

	/**
	 * 交易时间
	 */
	private String transTime;

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

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(String settleAmount) {
		this.settleAmount = settleAmount;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	@Override
	public String toString() {
		return "BillDetailDTO{" +
				"mid='" + mid + '\'' +
				", tid='" + tid + '\'' +
				", mname='" + mname + '\'' +
				", cardNo='" + cardNo + '\'' +
				", type='" + type + '\'' +
				", settleAmount='" + settleAmount + '\'' +
				", transTime='" + transTime + '\'' +
				'}';
	}
}
