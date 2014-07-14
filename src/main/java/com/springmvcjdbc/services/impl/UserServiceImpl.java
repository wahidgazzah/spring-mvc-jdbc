package com.springmvcjdbc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcjdbc.dao.UserDao;
import com.springmvcjdbc.domain.User;
import com.springmvcjdbc.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	public void insertData(User user) {
		userdao.insertData(user);
	}

	public List<User> getUserList() {
		return userdao.getUserList();
	}

	public void deleteData(String id) {
		userdao.deleteData(id);
		
	}

	public User getUser(String id) {
		return userdao.getUser(id);
	}

	public void updateData(User user) {
		userdao.updateData(user);
		
	}


	
}
