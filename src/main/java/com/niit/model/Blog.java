package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Bloginfo")
public class Blog {
	@Id
	@GeneratedValue
	private int blogid;
	private String blogname;
	private String blogdetails;
	private Date blogdate;
	
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogname() {
		return blogname;
	}
	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}
	public String getBlogdetails() {
		return blogdetails;
	}
	public void setBlogdetails(String blogdetails) {
		this.blogdetails = blogdetails;
	}
	public Date getBlogdate() {
		return blogdate;
	}
	public void setBlogdate(Date blogdate) {
		this.blogdate = blogdate;
	}
	
}
