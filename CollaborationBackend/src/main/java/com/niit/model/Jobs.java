package com.niit.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "jobsinfo")
@Component
public class Jobs {

	@Id
	@Column(name="jid")
	@GeneratedValue
	private int jid;
	
	private String jobName;
	private String companyName;
	private String technologiesExpected;
	private String address;
	
	public int getJid() {
		return jid;
	}
	public void setJid(int jid) {
		this.jid = jid;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTechnologiesExpected() {
		return technologiesExpected;
	}
	public void setTechnologiesExpected(String technologiesExpected) {
		this.technologiesExpected = technologiesExpected;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
