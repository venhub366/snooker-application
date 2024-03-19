package com.snooker.user.app.service;

import com.snooker.user.app.entity.User;
import com.snooker.user.app.ro.UserRO;

public interface UserService {

	Integer addUser(UserRO user);

	UserRO getuserDetails(Integer userId);
	
	boolean deleteUser(UserRO user);

	Iterable<User> getAllUsers();

}
