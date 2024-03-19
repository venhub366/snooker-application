package com.snooker.user.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.snooker.user.app.entity.User;
import com.snooker.user.app.ro.UserRO;
import com.snooker.user.app.service.UserService;

@Controller // (value = "/v1/users/")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(value = "/getUserDetails")
	public UserRO getUserDetails(@RequestParam(value = "userId") String userId) {
		return service.getuserDetails(Integer.parseInt(userId));

	}
	
	@GetMapping(value = "/listAllUsers")
	public String displayUsers(Model model) {
		List<User> list = (List<User>) service.getAllUsers();
		System.out.println(list.size());
		model.addAttribute("userList", list);
		return "displayUsers";
	}

	@PostMapping(value = "/addUser")
	public String addUserDetails(@RequestBody UserRO user) {
		Integer id = service.addUser(user);
		return "User created with" + id + "id.";
	}

	@GetMapping(value = "/welcome")
	public String welcome() {
		return "Welcome 2 Snooker App.!!!";
	}

}
