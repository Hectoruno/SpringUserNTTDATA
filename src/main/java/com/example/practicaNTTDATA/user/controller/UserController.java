package com.example.practicaNTTDATA.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.practicaNTTDATA.user.model.User;
import com.example.practicaNTTDATA.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
    private UserService us;
	
	@GetMapping("/users/{id}")
	User getUserById(@PathVariable(value="id")Long id) {
		return us.getId(id);
	}
	@PostMapping(path="/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User newUser){
		User user = new User();
		us.updateUser(user);
		return ResponseEntity.ok(user);
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User updateUser){
		User user = us.getId(id);
		user.setName(updateUser.getName());
		user.setBirthDate(updateUser.getBirthDate());
		us.updateUser(user);
		return ResponseEntity.ok(user);
	}
	@DeleteMapping(value="/users/{id}")
	public void deleteUser(@PathVariable Long id){
		us.deleteUser(id);
	}
	
	@ControllerAdvice
	public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

		@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
		protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
	
			String bodyOfResponse = "No has especificado la fecha de nacimiento o el nombre";
	
			return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	
		}
	}
}