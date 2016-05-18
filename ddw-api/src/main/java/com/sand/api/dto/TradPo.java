package com.sand.api.dto;

/**
 * Created by Administrator on 2015/12/25.
 */
public class TradPo {

    private	int ztNum = 0;//自拓count
    private  double ztAmt = 0; //自拓atm;
    private  int dlsNum = 0;//代理商 count
    private  double dlsAmt = 0;//代理商金额
    private  double ztfee=0;
    private  double ztshyi=0;
    private  double dlsfee=0;
    private  double dlsshyi=0;
    private  String mid;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public int getZtNum() {
        return ztNum;
    }

    public void setZtNum(int ztNum) {
        this.ztNum = ztNum;
    }

    public double getZtAmt() {
        return ztAmt;
    }

    public void setZtAmt(double ztAmt) {
        this.ztAmt = ztAmt;
    }

    public int getDlsNum() {
        return dlsNum;
    }

    public void setDlsNum(int dlsNum) {
        this.dlsNum = dlsNum;
    }

    public double getDlsAmt() {
        return dlsAmt;
    }

    public void setDlsAmt(double dlsAmt) {
        this.dlsAmt = dlsAmt;
    }

    public double getZtfee() {
        return ztfee;
    }

    public void setZtfee(double ztfee) {
        this.ztfee = ztfee;
    }

    public double getZtshyi() {
        return ztshyi;
    }

    public void setZtshyi(double ztshyi) {
        this.ztshyi = ztshyi;
    }

    public double getDlsfee() {
        return dlsfee;
    }

    public void setDlsfee(double dlsfee) {
        this.dlsfee = dlsfee;
    }

    public double getDlsshyi() {
        return dlsshyi;
    }

    public void setDlsshyi(double dlsshyi) {
        this.dlsshyi = dlsshyi;
    }
}
