package com.TaskScheduler.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TaskScheduler.entites.User;
import com.TaskScheduler.exceptions.UserException;

@Service
public interface UserServices {
	
	public User addUser(User user)throws UserException;
	
	public String deleteUser(Integer userId) throws UserException;
	
	public List<User> getAllUser()throws UserException;
	
	public User getUserById(Integer userId)throws UserException;

}
