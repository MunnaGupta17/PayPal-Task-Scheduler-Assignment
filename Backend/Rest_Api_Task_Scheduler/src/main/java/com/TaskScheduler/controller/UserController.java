package com.TaskScheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TaskScheduler.entites.User;
import com.TaskScheduler.exceptions.UserException;
import com.TaskScheduler.services.UserServices;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServices userService;
	
	@PostMapping("/users/save")
	public ResponseEntity<User> addUserHandler(@RequestBody User user) throws UserException{
		User savedUser = userService.addUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/users/delete/{userId}")
	public ResponseEntity<String> deleteUserHandler(@PathVariable("userId") Integer userId) throws UserException{
		String message =  userService.deleteUser(userId);
		return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUserHandler() throws UserException{
		List<User> userList = userService.getAllUser();
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable("userId") Integer userId) throws UserException{
		User user = userService.getUserById(userId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
