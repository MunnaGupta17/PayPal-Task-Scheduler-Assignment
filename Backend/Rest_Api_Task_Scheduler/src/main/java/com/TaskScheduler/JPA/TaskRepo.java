package com.TaskScheduler.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskScheduler.entites.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer>{

}
