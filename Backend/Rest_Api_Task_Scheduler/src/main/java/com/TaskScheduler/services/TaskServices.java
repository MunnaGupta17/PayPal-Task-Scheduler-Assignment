package com.TaskScheduler.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TaskScheduler.entites.Task;
import com.TaskScheduler.entites.TaskStatus;
import com.TaskScheduler.exceptions.SprintException;
import com.TaskScheduler.exceptions.TaskException;
import com.TaskScheduler.exceptions.UserException;

@Service
public interface TaskServices {
	

	public Task createTask(Task task)throws TaskException;
	
	public List<Task> getAllTasksBySprint(Integer sprintId) throws TaskException, SprintException;
	
	public List<Task> getAllTasksByAssignee(Integer assigneeId) throws UserException, TaskException;
	
	public Task updateTaskAssignee(Integer taskId, Integer assigneeId) throws UserException, TaskException;
	
	public Task updateTaskStatus(Integer taskId, TaskStatus status) throws TaskException;

	public List<Task> getAllTaskByWeekDays(String day) throws TaskException;

}
