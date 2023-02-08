package com.example.practicaNTTDATA.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practicaNTTDATA.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
