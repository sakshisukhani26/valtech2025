package com.valtech.training.registerservice.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.UserVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	@Override
	public UserVO addUserToSubscription(UserVO vo,long id) {
//		User u = vo.to(subscriptionRepo.getReferenceById(vo.subscriptionId()));
		User u = vo.to(subscriptionRepo.getReferenceById(id));
		u = userRepo.save(u);
		return UserVO.from(u);
	}
	
	@Override
	public List<UserVO> getAllUser(){
		return userRepo.findAll().stream().map(u -> UserVO.from(u)).collect(Collectors.toList());
	}
	
	@Override
	public UserVO getById(Long id) {
		return UserVO.from(userRepo.getReferenceById(id));
	}
	
	@Override
	public UserVO registerUser(UserVO vo) {
		Subscription sc = new Subscription();
		sc.setAmount(1000);
		sc.setSubscriptionStart(LocalDate.now());
		sc.setSubscriptionEnd(LocalDate.now().plusYears(1));
		subscriptionRepo.save(sc);
		User u = vo.to(sc);
		sc.addUser(u);
		return UserVO.from(userRepo.save(u));
	}

	@Override
	public void deleteUserFromSubscription(long userId) {
//		User user = userRepo.getReferenceById(userId);
//		Subscription s = u.getSubscription();
//		s.removeUser(user);
		userRepo.deleteById(userId);
	}
}
