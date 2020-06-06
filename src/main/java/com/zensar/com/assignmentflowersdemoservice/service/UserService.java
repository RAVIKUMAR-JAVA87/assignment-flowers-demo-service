package com.zensar.com.assignmentflowersdemoservice.service;

import java.util.List;

import com.zensar.com.assignmentflowersdemoservice.bean.User;

public interface UserService {

	public List<User> getUsers();
	public List<User> getUniqueUsers();
	public User updateUserById(int id, String value);

}
