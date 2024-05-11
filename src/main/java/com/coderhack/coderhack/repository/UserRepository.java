package com.coderhack.coderhack.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.coderhack.coderhack.entity.User;


public interface UserRepository extends MongoRepository<User,String>{

	
	

}
