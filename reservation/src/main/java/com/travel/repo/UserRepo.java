package com.travel.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.travel.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
	
	User findByUsername(String username);
	
}
