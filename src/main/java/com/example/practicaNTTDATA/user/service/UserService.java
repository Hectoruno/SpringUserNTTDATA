package com.example.practicaNTTDATA.user.service;

import com.example.practicaNTTDATA.user.model.User;

public interface UserService {
	
	public User createUser(User user);
    public User getId(Long id);
    public User updateUser(User user);
    public void deleteUser(Long id);

}
