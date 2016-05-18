package com.sand.api.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2015/12/22.
 */
public class TradExpandDTO implements CacheObject{

    private int id;
    /**时间*/
    private String project_time;
    /**营业部*/
    private String department;
    /**交易自拓（笔数）*/
    private int trans_self_count;
    /**交易代理商（笔数）*/
    private int trans_agent_count;
    /**交易小计（笔数）*/
    private int trans_subtotal_count;
    /**交易自拓（元）*/
    private BigDecimal trans_self_rmb;
    /**交易代理商（元）*/
    private BigDecimal trans_agent_rmb;
    /**交易小计（元）*/
    private BigDecimal trans_subtotal_rmb;
    /**商户手续费自拓（元）*/
    private BigDecimal business_self_rmb;
    /**商户手续费代理商（元）*/
    private BigDecimal business_agent_rmb;
    /**商户手续费小计（元）*/
    private BigDecimal business_subtotal_rmb;
    /**核定收单行收益自拓（元）*/
    private BigDecimal profit_self_rmb;
    /**核定收单行收益代理商（元）*/
    private BigDecimal profit_agent_rmb;
    /**核定收单行收益小计（元）*/
    private BigDecimal profit_subtotal_rmb;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject_time() {
        return project_time;
    }

    public void setProject_time(String project_time) {
        this.project_time = project_time;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getTrans_self_count() {
        return trans_self_count;
    }

    public void setTrans_self_count(int trans_self_count) {
        this.trans_self_count = trans_self_count;
    }

    public int getTrans_agent_count() {
        return trans_agent_count;
    }

    public void setTrans_agent_count(int trans_agent_count) {
        this.trans_agent_count = trans_agent_count;
    }

    public int getTrans_subtotal_count() {
        return trans_subtotal_count;
    }

    public void setTrans_subtotal_count(int trans_subtotal_count) {
        this.trans_subtotal_count = trans_subtotal_count;
    }

    public BigDecimal getTrans_self_rmb() {
        return trans_self_rmb;
    }

    public void setTrans_self_rmb(BigDecimal trans_self_rmb) {
        this.trans_self_rmb = trans_self_rmb;
    }

    public BigDecimal getTrans_agent_rmb() {
        return trans_agent_rmb;
    }

    public void setTrans_agent_rmb(BigDecimal trans_agent_rmb) {
        this.trans_agent_rmb = trans_agent_rmb;
    }

    public BigDecimal getTrans_subtotal_rmb() {
        return trans_subtotal_rmb;
    }

    public void setTrans_subtotal_rmb(BigDecimal trans_subtotal_rmb) {
        this.trans_subtotal_rmb = trans_subtotal_rmb;
    }

    public BigDecimal getBusiness_self_rmb() {
        return business_self_rmb;
    }

    public void setBusiness_self_rmb(BigDecimal business_self_rmb) {
        this.business_self_rmb = business_self_rmb;
    }

    public BigDecimal getBusiness_agent_rmb() {
        return business_agent_rmb;
    }

    public void setBusiness_agent_rmb(BigDecimal business_agent_rmb) {
        this.business_agent_rmb = business_agent_rmb;
    }

    public BigDecimal getBusiness_subtotal_rmb() {
        return business_subtotal_rmb;
    }

    public void setBusiness_subtotal_rmb(BigDecimal business_subtotal_rmb) {
        this.business_subtotal_rmb = business_subtotal_rmb;
    }

    public BigDecimal getProfit_self_rmb() {
        return profit_self_rmb;
    }

    public void setProfit_self_rmb(BigDecimal profit_self_rmb) {
        this.profit_self_rmb = profit_self_rmb;
    }

    public BigDecimal getProfit_agent_rmb() {
        return profit_agent_rmb;
    }

    public void setProfit_agent_rmb(BigDecimal profit_agent_rmb) {
        this.profit_agent_rmb = profit_agent_rmb;
    }

    public BigDecimal getProfit_subtotal_rmb() {
        return profit_subtotal_rmb;
    }

    public void setProfit_subtotal_rmb(BigDecimal profit_subtotal_rmb) {
        this.profit_subtotal_rmb = profit_subtotal_rmb;
    }

    @Override
    public String toString() {
        return "TradExpandDTO{" +
                "id=" + id +
                ", project_time='" + project_time + '\'' +
                ", department='" + department + '\'' +
                ", trans_self_count=" + trans_self_count +
                ", trans_agent_count=" + trans_agent_count +
                ", trans_subtotal_count=" + trans_subtotal_count +
                ", trans_self_rmb=" + trans_self_rmb +
                ", trans_agent_rmb=" + trans_agent_rmb +
                ", trans_subtotal_rmb=" + trans_subtotal_rmb +
                ", business_self_rmb=" + business_self_rmb +
                ", business_agent_rmb=" + business_agent_rmb +
                ", business_subtotal_rmb=" + business_subtotal_rmb +
                ", profit_self_rmb=" + profit_self_rmb +
                ", profit_agent_rmb=" + profit_agent_rmb +
                ", profit_subtotal_rmb=" + profit_subtotal_rmb +
                '}';
    }
}
