package com.niit.Services;

import java.util.List;


import com.niit.model.Forum;

public interface ForumDAO {
	public List<Forum> getAllForum();    
	 public Forum getForum(int forumid);
	 public void insertForum(Forum forum);
	 public Forum updateForum(int id,Forum forum);
	 public void deleteForum(int id);
}
