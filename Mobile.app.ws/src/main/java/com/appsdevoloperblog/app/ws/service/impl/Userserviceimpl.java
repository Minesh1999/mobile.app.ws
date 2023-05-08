package com.appsdevoloperblog.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdevoloperblog.app.ws.io.entity.UserEntity;
import com.appsdevoloperblog.app.ws.repo.UserRepository;
import com.appsdevoloperblog.app.ws.service.Userservice;
import com.appsdevoloperblog.app.ws.shared.Dto.UserDto;

@Service
public class Userserviceimpl implements Userservice {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto user) {
		
		
		if(userRepository.findByEmail(user.getEmail()) !=null) throw new RuntimeException ("Record already exists");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		userEntity.setEncryptedPassword("test");
		userEntity.setUserId("testUserId");

		UserEntity storedUserDetails = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);

		return returnValue;
	}

}
