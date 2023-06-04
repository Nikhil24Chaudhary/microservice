package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {

	// create user
	public User createUser(User user);

	// fetch all user
	public  List<User> getAllUsers();

	// fetch user by id
	public User findUserProfileById(int userId);

	public User getUserById(int userId);
}
