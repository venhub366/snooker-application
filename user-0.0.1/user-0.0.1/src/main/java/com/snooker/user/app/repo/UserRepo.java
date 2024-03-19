package com.snooker.user.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.snooker.user.app.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

}
