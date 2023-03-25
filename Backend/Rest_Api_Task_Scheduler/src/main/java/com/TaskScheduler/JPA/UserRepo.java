package com.TaskScheduler.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskScheduler.entites.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
