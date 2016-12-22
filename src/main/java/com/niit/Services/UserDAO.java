package com.niit.Services;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {
	public List<User> getAllUsers();    
	 public User getUser(int userid);
	 public void insertUser(User user);
	 public User updateUser(int id,User user);
	 public void deleteUser(int id);
	 public void deleteAllUser(User user);
	 public User authenticate(User user);
	 
}
