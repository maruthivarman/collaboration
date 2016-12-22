package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Jobinfo")
public class Job {
	
	@Id
	@GeneratedValue
	private int jobid;
	private String jobname;
	private String jobdetails;
	private Date jobdate;
	private String skills;
	private int salary;
	private String location;
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getJobdetails() {
		return jobdetails;
	}
	public void setJobdetails(String jobdetails) {
		this.jobdetails = jobdetails;
	}
	public Date getJobdate() {
		return jobdate;
	}
	public void setJobdate(Date jobdate) {
		this.jobdate = jobdate;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
