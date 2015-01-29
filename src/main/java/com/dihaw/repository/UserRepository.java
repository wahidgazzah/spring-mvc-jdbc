package com.dihaw.repository;

import java.util.List;

import com.dihaw.entity.User;

public interface UserRepository {
	public void insertData(User user);

	public List<User> getUserList();

	public void updateData(User user);

	public void deleteData(String id);

	public User getUser(String id);

	public List<User> findAllUsers();
	
	
	// JPA
	public List<User> getAll();

	public void addUser(User user);

	public List<User> getAllByPageSize(Integer page, Integer size);

	public int getUsersCount();

}
