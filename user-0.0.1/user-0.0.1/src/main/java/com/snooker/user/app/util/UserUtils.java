package com.snooker.user.app.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snooker.user.app.entity.User;
import com.snooker.user.app.ro.UserRO;

@Component
public class UserUtils {

	private final ObjectMapper mapper = new ObjectMapper();

	public User mapRotoEntity(UserRO ro) {
		return mapper.convertValue(ro, User.class);
	}

	public UserRO mapEntitytoRO(User entity) {
		return mapper.convertValue(entity, UserRO.class);
	}
}
