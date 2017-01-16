package com.niit.Services;


import java.util.List;

import com.niit.model.FriendList;



public interface FriendListDAO {

	public List<FriendList> friendList(String userId);
	
	public List<FriendList> friendRequestList(String userId);
	
	public FriendList get(String friendId);
	
	public void saveOrUpdate(FriendList friendList);
		
	public void delete(String friendId);
	
	
}
