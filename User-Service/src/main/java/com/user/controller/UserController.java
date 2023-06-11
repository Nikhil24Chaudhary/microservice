package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.entity.User;
import com.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		System.out.println("createUser : " + user);
		User entity = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	// fetch all user
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		System.out.println("createUser");
		List<User> users = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	// fetch user by id - calling career service
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "userCareerServiceBreaker", fallbackMethod = "userCareerServiceFallback")
	public ResponseEntity<User> findUserProfileById(@PathVariable int userId) {
		System.out.println("findUserById : " + userId);
		User user = userService.findUserProfileById(userId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	public  ResponseEntity<User>  userCareerServiceFallback(int userId, Exception e) {
		System.out.println("Fallback Called - CareerService is down ");
		User user = new User();
		return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(user);
		
		
	}

}
