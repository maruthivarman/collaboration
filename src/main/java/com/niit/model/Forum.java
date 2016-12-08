package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Forumtable")
public class Forum {
	@Id
	@GeneratedValue
	private int forumid;
	private int userid;
	private String forumtitle;
	private String forumdetails;
	private String comment;
	private Date forumdate;
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getForumtitle() {
		return forumtitle;
	}
	public void setForumtitle(String forumtitle) {
		this.forumtitle = forumtitle;
	}
	public String getForumdetails() {
		return forumdetails;
	}
	public void setForumdetails(String forumdetails) {
		this.forumdetails = forumdetails;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getForumdate() {
		return forumdate;
	}
	public void setForumdate(Date forumdate) {
		this.forumdate = forumdate;
	}
	
	
}
