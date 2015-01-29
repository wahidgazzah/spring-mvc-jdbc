package com.dihaw.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dihaw.entity.User;
import com.dihaw.repository.UserRepository;
import com.dihaw.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	
	public List<User> getAll() {
		return userRepository.getAll();
	}
	 
	public void addUser(User user) {
		userRepository.addUser(user);
	}
	
	public void insertData(User user) {
		userRepository.insertData(user);
	}

	public List<User> getUserList() {
		return userRepository.getUserList();
	}

	public void deleteData(String id) {
		userRepository.deleteData(id);
		
	}

	public User getUser(String id) {
		return userRepository.getUser(id);
	}

	public void updateData(User user) {
		userRepository.updateData(user);
		
	}

	public List<User> getAllByPageSize(Integer page, Integer size) {
		return userRepository.getAllByPageSize(page, size);
	}

	public int getUsersCount() {
		return userRepository.getUsersCount();
	}


	
}
