package com.niit.Services;

import java.util.List;

import com.niit.model.Jobs;



public interface JobDAO {

	public List<Jobs> list();
	
	public Jobs get(int jid);
	
	public Jobs saveOrUpdate(Jobs jobs);
		
	public void delete(int jid);
}
