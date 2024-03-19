package com.snooker.user.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snooker.user.app.entity.User;
import com.snooker.user.app.repo.UserRepo;
import com.snooker.user.app.ro.UserRO;
import com.snooker.user.app.util.UserUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserUtils userUtils;

	@Override
	public Integer addUser(UserRO user) {

		User entity = userUtils.mapRotoEntity(user);
		entity = userRepo.save(entity);
		return entity.getId();
	}

	@Override
	public UserRO getuserDetails(Integer userId) {

		Optional<User> ro = userRepo.findById(userId);
		return userUtils.mapEntitytoRO(ro.get());
	}

	@Override
	public boolean deleteUser(UserRO user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();

	}

}
