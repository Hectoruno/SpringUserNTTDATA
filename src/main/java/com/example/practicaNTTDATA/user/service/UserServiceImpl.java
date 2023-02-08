package com.example.practicaNTTDATA.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practicaNTTDATA.user.model.User;
import com.example.practicaNTTDATA.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(User user) {
		if (user.getName()==null && user.getBirthDate() == null){
            throw new IllegalArgumentException("Necesitas introducir nombre y fecha de nacimiento");
        }else if (user.getName()==null) {
            throw new IllegalArgumentException("Debes introducir el nombre");
        } else if (user.getBirthDate() == null){
            throw new IllegalArgumentException("Debes introducir la fecha de nacimiento");
        }
		return userRepo.save(user);
				
	}
	@Override
	public User getId(Long id) {
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
		
	}

}
