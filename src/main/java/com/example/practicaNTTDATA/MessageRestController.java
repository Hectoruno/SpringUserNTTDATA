package com.example.practicaNTTDATA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {
	
	@Autowired
	private MessageService ms;
	
	public MessageRestController(MessageService ms) {
		this.ms = ms;
    }
	
	@GetMapping("api/v1/message")
	public String getMessage() {
		return this.ms.getMessage();
	}

}
