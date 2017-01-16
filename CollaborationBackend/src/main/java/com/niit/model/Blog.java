package com.niit.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "bloginfo")
@Component
public class Blog {

	@Id
	@Column(name="bid")
	@GeneratedValue
	private int bid;
	
	private String blogName;
	private String userId;
	
	private String userName;
	
	private String status;
	
	
	@Column
	private String description;

	
	@Column(length = 2000)
	private String content;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Generated(value = { "" })
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date ondate = new java.sql.Date(new java.util.Date().getTime());



	public Date getOndate() {
		return ondate;
	}
	public void setOndate(Date ondate) {
		this.ondate = ondate;
	}
	
	
	
}
