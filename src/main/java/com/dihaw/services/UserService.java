package com.dihaw.services;

import java.util.List;

import com.dihaw.entity.User;

public interface UserService {
	public void insertData(User user);

	public List<User> getUserList();

	public void deleteData(String id);

	public User getUser(String id);

	public void updateData(User user);

	public List<User> getAll();
	public void addUser(User user);

	public List<User> getAllByPageSize(Integer page, Integer size);

	public int getUsersCount();
}
