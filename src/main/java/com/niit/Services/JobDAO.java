package com.niit.Services;

import java.util.List;

import com.niit.model.Job;

public interface JobDAO {
	public List<Job> getAllJob();    
	 public Job getJob(int jobid);
	 public void insertJob(Job job);
	 public Job updateJob(int id,Job job);
	 public void deleteJob(int id);
}
