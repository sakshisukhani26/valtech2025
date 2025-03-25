package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.UserVO;

public interface UserService {

	UserVO registerUser(UserVO vo);

	List<UserVO> getAllUser();

	UserVO getById(Long id);

	UserVO addUserToSubscription(UserVO vo,long id);

	void deleteUserFromSubscription(long userId);

}