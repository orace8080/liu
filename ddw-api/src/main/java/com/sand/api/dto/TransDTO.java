package com.sand.api.dto;

public class TransDTO implements CacheObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 119273649172634L;

	/** 商户号 */
	private String mid;
	/** 商户名称 */
	private String mname;
	/** 终端号 */
	private String tid;
	/** 交易时间 */
	private String transTime;
	/** 交易类型 */
	private String type;
	/** 项目名称 */
	private String pname;
	/** 项目编号 */
	private String pid;
	/** mcc */
	private String mcc;

	/** 交易卡号 */
	private String cardNo;

	/** 退款标志位 */
	private String refundFlag;
	/** 撤销标志位 */
	private String cancelFlag;
	/** 冲正标志位 */
	private String reverseFlag;

	/** 交易金额 */
	private String transAmount;
	/** 交易手续费 */
	private String transFee;
	/** 结算金额 */
	private String settleAmount;

	/** 批次号 */
	private String batchNo;
	/** 流水号 */
	private String serial;

	/**
	 * 交易响应码<br>
	 * 
	 * 00 交易成功<br>
	 * 其他均为失败
	 */
	private String respCode;

	public String getMid() {
		return mid;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
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

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getRefundFlag() {
		return refundFlag;
	}

	public void setRefundFlag(String refundFlag) {
		this.refundFlag = refundFlag;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public String getReverseFlag() {
		return reverseFlag;
	}

	public void setReverseFlag(String reverseFlag) {
		this.reverseFlag = reverseFlag;
	}

	public String getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}

	public String getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(String settleAmount) {
		this.settleAmount = settleAmount;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getRespCode() {
		return respCode;
	}

	public String getTransFee() {
		return transFee;
	}

	public void setTransFee(String transFee) {
		this.transFee = transFee;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "TransDTO [mid=" + mid + ", mname=" + mname + ", tid=" + tid
				+ ", transTime=" + transTime + ", type=" + type + ", pname="
				+ pname + ", pid=" + pid + ", mcc=" + mcc + ", cardNo="
				+ cardNo + ", refundFlag=" + refundFlag + ", cancelFlag="
				+ cancelFlag + ", reverseFlag=" + reverseFlag
				+ ", transAmount=" + transAmount + ", transFee=" + transFee
				+ ", settleAmount=" + settleAmount + ", batchNo=" + batchNo
				+ ", serial=" + serial + ", respCode=" + respCode + "]";
	}

}
