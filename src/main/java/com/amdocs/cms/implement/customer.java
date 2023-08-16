package com.amdocs.cms.implement;

public class customer {
private int cid;
private String cname;
private String address;
private String contact;
private int pid;
public customer(int cid, String cname, String address, String contact, int pid) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.address = address;
	this.contact = contact;
	this.pid = pid;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}

}
