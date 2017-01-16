package com.niit.Services;


import java.util.List;

import com.niit.model.Chat;



public interface ChatDAO {

	public List<Chat> list();
	
	public Chat get(String sender);
	
	public void saveOrUpdate(Chat chat);
		
	public void delete(String sender);
}
