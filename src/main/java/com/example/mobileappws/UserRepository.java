package com.example.mobileappws;

import org.springframework.data.repository.CrudRepository;

import com.example.mobileappws.IO.Entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
