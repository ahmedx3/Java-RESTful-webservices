package com.example.mobileappws.Service.Impl;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mobileappws.UserRepository;
import com.example.mobileappws.IO.Entity.UserEntity;
import com.example.mobileappws.Service.UserService;
import com.example.mobileappws.Shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("testPass");
        userEntity.setUserId(UUID.randomUUID().toString());
        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }

}
