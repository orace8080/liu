package com.sand.api.param;

import java.util.Arrays;

import com.sand.api.dto.Page;

/**
 * RMI远程协议的参数对象
 * 所有方法调用皆通过该对象进行传递值
 */
public class Parameter implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1234589237458745L;

	/** 营业部编号 */
	private String[] comps;
	/** 商户号 */
	private String mid;
	/** 终端号 */
	private String tid;
	/** 开始日期 */
	private String startDate;
	/** 结束日期 */
	private String endDate;
	/** 交易类型 */
	private String transType;
	/** 卡号 */
	private String card;
	/** 状态 */
	private String status;

	/** 分页对象 */
	private Page page;

	public String[] getComps() {
		return comps;
	}

	public Parameter setComps(String[] comps) {
		this.comps = comps;
		return this;
	}

	public String getMid() {
		return mid;
	}

	public Parameter setMid(String mid) {
		this.mid = mid;
		return this;
	}

	public String getTid() {
		return tid;
	}

	@Deprecated
	public Parameter setTid(String tid) {
		this.tid = tid;
		return this;
	}

	public String getStartDate() {
		return startDate;
	}

	public Parameter setStartDate(String startDate) {
		this.startDate = startDate;
		return this;
	}

	public String getEndDate() {
		return endDate;
	}

	public Parameter setEndDate(String endDate) {
		this.endDate = endDate;
		return this;
	}

	public String getTransType() {
		return transType;
	}

	@Deprecated
	public Parameter setTransType(String transType) {
		this.transType = transType;
		return this;
	}

	public String getCard() {
		return card;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Deprecated
	public Parameter setCard(String card) {
		this.card = card;
		return this;
	}

	public Page getPage() {
		return page;
	}

	/**
	 * 设置分页对象.
	 * <p>
	 * 建议使用{@link #setPageNum} 和 {@link #setPageSize} 设置分页参数<br>
	 * 并通过 {@link #getPageNum} 和 {@link #getPageSize()} 获取分页参数
	 *
	 * @param page
	 * @return
	 */
	public Parameter setPage(Page page) {
		this.page = page;
		return this;
	}

	/**
	 * 获取当前页码
	 *
	 * @return
	 */
	public int getPageNum() {
		return page == null ? 0 : page.getPage();
	}

	/**
	 * 设置需要查询的页码数
	 *
	 * @param num
	 * @return
	 */
	public Parameter setPageNum(int num) {
		if (page == null)
			page = new Page(num);
		else
			page.setPage(num);
		return this;
	}

	/**
	 * 获取当前单页获取数量
	 *
	 * @return
	 */
	public int getPageSize() {
		return page == null ? 0 : page.getSize();
	}

	public Parameter setPageSize(int size) {
		if (page == null)
			page = new Page(1, size);
		else
			page.setSize(size);
		return this;
	}


	public String toTransKey() {
		String compsTemp = compsToString();
		return (compsTemp			== null ? "#" : compsTemp)
				+ "-" + (mid 		== null ? "#" : mid)
				+ "-" + (tid 		== null ? "#" : tid)
				+ "-" + (startDate 	== null ? "#" : startDate)
				+ "-" + (endDate 	== null ? "#" : endDate)
				+ "-" + (status == null ? "#" : status);
	}
	public String toBillKey(){
		return (mid 				== null ? "#" : mid)
				+ "-" + (startDate 	== null ? "#" : startDate)
				+ "-" + (endDate 	== null ? "#" : endDate);
	}

	public String toTransExpandKey(){
		String compsTemp = compsToString();
		return (compsTemp 			== null ? "#" : compsTemp)
				+ "-" + (startDate 	== null ? "#" : startDate)
				+ "-" +(comps       == null ? "#" : comps)
				+ "-" + (endDate 	== null ? "#" : endDate);
	}
	public String toTransProjectKey(){
		String compsTemp = compsToString();
		return (compsTemp 			== null ? "*" : compsTemp)
				+ "-" + (startDate 	== null ? "*" : startDate)
				+ "-" +(comps       == null ? "*" : comps)
				+ "-" + (endDate 	== null ? "*" : endDate);
	}
	public String compsToString() {
		if (comps == null || comps.length == 0)
			return null;

		StringBuilder b = new StringBuilder();
		for (int i = 0, len = comps.length; i < len; i++) {
			b.append(comps[i]).append("&");
		}
		return b.substring(0, b.length() - 1).toString();
	}

	@Override
	public String toString() {
		return "Parameter [comps=" + Arrays.toString(comps) + ", mid=" + mid + ", tid=" + tid + ", startDate="
				+ startDate + ", endDate=" + endDate + ", transType=" + transType + ", card=" + card + ", status="
				+ status + ", page=" + page + "]";
	}
}
