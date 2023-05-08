package com.appsdevoloperblog.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdevoloperblog.app.ws.service.Userservice;
import com.appsdevoloperblog.app.ws.shared.Dto.UserDto;
import com.appsdevoloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdevoloperblog.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    @Autowired
	Userservice userService;

	@GetMapping
	public String getuser() {
		return "get user was called";

	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;

	}

	@PutMapping
	public String updateuser() {
		return "update user was called";
	}

	@DeleteMapping
	public String Deleteuser() {
		return "Delete user was called";
	}
}
