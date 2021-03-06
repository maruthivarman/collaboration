package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bloggers")

public class User {
@Id
@GeneratedValue
private int userid;
private String username;
private String password;
private String emailid;
private Date DOB;
private String address;
private Long mobilenumber;
private String role;
/*private boolean enabled;
private boolean isOnline;*/


public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public Date getDOB() {
	return DOB;
}
public void setDOB(Date dOB) {
	DOB = dOB;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Long getMobilenumber() {
	return mobilenumber;
}
public void setMobilenumber(Long mobilenumber) {
	this.mobilenumber = mobilenumber;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
/*public boolean isStatus() {
	return enabled;
}
public void setStatus(boolean status) {
	this.enabled = status;
}
public boolean isOnline() {
	return isOnline;
}
public void setOnline(boolean isOnline) {
	this.isOnline = isOnline;
}
@Override
public String toString() {
	return this.username + " " + this.emailid + " " + this.role + "\n";
}*/


}
