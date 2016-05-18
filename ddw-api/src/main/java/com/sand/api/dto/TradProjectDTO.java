package com.sand.api.dto;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2015/12/25.
 */
public class TradProjectDTO implements CacheObject{
    private  int id;
     private String  project_time;
    private String department;
    private int trans_total;
    private BigDecimal trans_totalRmb;
    private BigDecimal trans_totalfee;
    private BigDecimal trans_totalshyi;
    private int  trans_dsjlnum;
    private BigDecimal trans_dsljrmb;
    private BigDecimal trans_dsljfee;
    private BigDecimal trans_dsljshyi;
    private int  trans_dszhlNum;
    private BigDecimal trans_dszhlRmb;
    private BigDecimal trans_dszhlfee;
    private BigDecimal trans_dszhlshyi;
    private int trans_otherNum;
    private BigDecimal trans_otherRmb;
    private BigDecimal trans_otherfee;
    private BigDecimal trans_othershyi;

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

    public int getTrans_total() {
        return trans_total;
    }

    public void setTrans_total(int trans_total) {
        this.trans_total = trans_total;
    }

    public BigDecimal getTrans_totalRmb() {
        return trans_totalRmb;
    }

    public void setTrans_totalRmb(BigDecimal trans_totalRmb) {
        this.trans_totalRmb = trans_totalRmb;
    }

    public BigDecimal getTrans_totalfee() {
        return trans_totalfee;
    }

    public void setTrans_totalfee(BigDecimal trans_totalfee) {
        this.trans_totalfee = trans_totalfee;
    }

    public BigDecimal getTrans_totalshyi() {
        return trans_totalshyi;
    }

    public void setTrans_totalshyi(BigDecimal trans_totalshyi) {
        this.trans_totalshyi = trans_totalshyi;
    }

    public int getTrans_dsjlnum() {
        return trans_dsjlnum;
    }

    public void setTrans_dsjlnum(int trans_dsjlnum) {
        this.trans_dsjlnum = trans_dsjlnum;
    }

    public BigDecimal getTrans_dsljrmb() {
        return trans_dsljrmb;
    }

    public void setTrans_dsljrmb(BigDecimal trans_dsljrmb) {
        this.trans_dsljrmb = trans_dsljrmb;
    }

    public BigDecimal getTrans_dsljfee() {
        return trans_dsljfee;
    }

    public void setTrans_dsljfee(BigDecimal trans_dsljfee) {
        this.trans_dsljfee = trans_dsljfee;
    }

    public BigDecimal getTrans_dsljshyi() {
        return trans_dsljshyi;
    }

    public void setTrans_dsljshyi(BigDecimal trans_dsljshyi) {
        this.trans_dsljshyi = trans_dsljshyi;
    }

    public int getTrans_dszhlNum() {
        return trans_dszhlNum;
    }

    public void setTrans_dszhlNum(int trans_dszhlNum) {
        this.trans_dszhlNum = trans_dszhlNum;
    }

    public BigDecimal getTrans_dszhlRmb() {
        return trans_dszhlRmb;
    }

    public void setTrans_dszhlRmb(BigDecimal trans_dszhlRmb) {
        this.trans_dszhlRmb = trans_dszhlRmb;
    }

    public BigDecimal getTrans_dszhlfee() {
        return trans_dszhlfee;
    }

    public void setTrans_dszhlfee(BigDecimal trans_dszhlfee) {
        this.trans_dszhlfee = trans_dszhlfee;
    }

    public BigDecimal getTrans_dszhlshyi() {
        return trans_dszhlshyi;
    }

    public void setTrans_dszhlshyi(BigDecimal trans_dszhlshyi) {
        this.trans_dszhlshyi = trans_dszhlshyi;
    }

    public int getTrans_otherNum() {
        return trans_otherNum;
    }

    public void setTrans_otherNum(int trans_otherNum) {
        this.trans_otherNum = trans_otherNum;
    }

    public BigDecimal getTrans_otherRmb() {
        return trans_otherRmb;
    }

    public void setTrans_otherRmb(BigDecimal trans_otherRmb) {
        this.trans_otherRmb = trans_otherRmb;
    }

    public BigDecimal getTrans_otherfee() {
        return trans_otherfee;
    }

    public void setTrans_otherfee(BigDecimal trans_otherfee) {
        this.trans_otherfee = trans_otherfee;
    }

    public BigDecimal getTrans_othershyi() {
        return trans_othershyi;
    }

    public void setTrans_othershyi(BigDecimal trans_othershyi) {
        this.trans_othershyi = trans_othershyi;
    }

    @Override
    public String toString() {
        return "TradProjectDTO{" +
                "id=" + id +
                ", project_time='" + project_time + '\'' +
                ", department='" + department + '\'' +
                ", trans_total=" + trans_total +
                ", trans_totalRmb=" + trans_totalRmb +
                ", trans_totalfee=" + trans_totalfee +
                ", trans_totalshyi=" + trans_totalshyi +
                ", trans_dsjlnum=" + trans_dsjlnum +
                ", trans_dsljrmb=" + trans_dsljrmb +
                ", trans_dsljfee=" + trans_dsljfee +
                ", trans_dsljshyi=" + trans_dsljshyi +
                ", trans_dszhlNum=" + trans_dszhlNum +
                ", trans_dszhlRmb=" + trans_dszhlRmb +
                ", trans_dszhlfee=" + trans_dszhlfee +
                ", trans_dszhlshyi=" + trans_dszhlshyi +
                ", trans_otherNum=" + trans_otherNum +
                ", trans_otherRmb=" + trans_otherRmb +
                ", trans_otherfee=" + trans_otherfee +
                ", trans_othershyi=" + trans_othershyi +
                '}';
    }
}
