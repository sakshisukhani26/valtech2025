package com.valtech.training.registerservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.registerservice.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{

	public List<User> findAllByKidTrue();
}
