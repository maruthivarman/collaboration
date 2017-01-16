package com.niit.Services;

import java.util.List;

import com.niit.model.Blog;


public interface BlogDAO {

	public List<Blog> list();
	
	public Blog get(int bid);
	
	public Blog saveOrUpdate(Blog blog);
		
	public void delete(int id);


}
