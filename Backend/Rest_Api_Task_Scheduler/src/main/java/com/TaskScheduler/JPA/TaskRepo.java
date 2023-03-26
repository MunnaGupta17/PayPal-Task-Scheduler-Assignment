package com.TaskScheduler.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TaskScheduler.entites.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

	List<Task> findBySprint(Integer sprintId);

	List<Task> findByAssignee(Integer assigneeId);
	
	List<Task> findByWeekDay(String day);

}
