package org.cocky.lab.dao;

import java.util.List;

import org.cocky.lab.entity.User;

public interface UserDao {

	public User findByName(String name);
	
	public User findByUserId(String  userId);
	
	public List<User> findAll();

	public List<User> findUserById(String userName);

	public User findUserBeforeAdd(String userId);

	public int addUser(User user);

	public User findAdminByName(String username);
	
}
