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
@Table(name = "Foruminfo")
@Component
public class Forum {

	@Id
	@Column(name="fid")
	@GeneratedValue
	private int fid;
	private String forumTitle;
	private String forumContent;
	private String userId;
	private String userName;
	
	
	@Generated(value = { "" })
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date ondate = new java.sql.Date(new java.util.Date().getTime());
	
	
	public String getForumTitle() {
		return forumTitle;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}
	public String getForumContent() {
		return forumContent;
	}
	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}
	
	public Date getOndate() {
		return ondate;
	}
	public void setOndate(Date ondate) {
		this.ondate = ondate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	
	
	
}
