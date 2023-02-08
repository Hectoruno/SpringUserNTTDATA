package com.example.practicaNTTDATA;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

	//@Value("${course.message}")
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}
}