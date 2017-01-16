package com.niit.Services;

import java.util.List;

import com.niit.model.User;



public interface UserDAO {

	public List list();
	public User get(Long id);
	public User getbyUsername(String username);
	public User create(User user);
	public void delete(Long id);
	public User update(User user);
}
