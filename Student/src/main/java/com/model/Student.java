package com.model;

public class Student {
	private int sid;
	private String sname;
	private String scity;
	private double sper;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public double getSper() {
		return sper;
	}
	public void setSper(double sper) {
		this.sper = sper;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", scity=" + scity + ", sper=" + sper + "]";
	}
	

}
