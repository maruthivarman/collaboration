package com.niit.Services;

import java.util.List;

import com.niit.model.Forum;



public interface ForumDAO {

	
	public List<Forum> list();
	
	public Forum get(int fid);
	
	public Forum saveOrUpdate(Forum forum);
		
	public void delete(int fid);
}
