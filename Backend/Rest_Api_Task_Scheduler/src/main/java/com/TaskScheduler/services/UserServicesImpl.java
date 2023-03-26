package com.TaskScheduler.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskScheduler.JPA.UserRepo;
import com.TaskScheduler.entites.User;
import com.TaskScheduler.exceptions.UserException;


@Service
public class UserServicesImpl implements UserServices{
	

	@Autowired
	private UserRepo userRepo;
	
    
	@Override
	public User addUser(User user) throws UserException{
		if(user == null) throw new UserException("user is null");
		User savedUser = userRepo.save(user);
		return savedUser;
	}

	@Override
	public String deleteUser(Integer userId) throws UserException {
		Optional<User> optionalUser =  userRepo.findById(userId);
		
		if(optionalUser.isPresent()) {
			userRepo.deleteById(userId);
			return "User deleted by id";
		}else {
			throw new UserException("User not available with id");
		}
	}

	@Override
	public List<User> getAllUser() throws UserException {
		List<User> userList =  userRepo.findAll();
		if(!userList.isEmpty()) {
			return userList;
		}else {
			throw new UserException("Users are not avilable");
		}
	}

	@Override
	public User getUserById(Integer userId) throws UserException {
		
		Optional<User> optionalUser =  userRepo.findById(userId);
		
		if(optionalUser.isPresent()) {
			return userRepo.findById(userId).get();
		}else {
			throw new UserException("User not available with this id");
		}
	}

}
