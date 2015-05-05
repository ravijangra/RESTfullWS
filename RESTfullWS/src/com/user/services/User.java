package com.user.services;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	String userid;
	String email;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
