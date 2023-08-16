package com.amdocs.cms.implement;

public class userlogin {
private int uid;
private String pass;
public userlogin(int uid, String pass) {
	super();
	this.uid = uid;
	this.pass = pass;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
}
