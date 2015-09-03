package com.sputnik.service;

import javax.ejb.Singleton;

import com.sputnik.entity.UserEntity;

@Singleton
public class UserServiceImpl implements UserService{
	private UserEntity userEntity = new UserEntity();

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
}
