package com.TaskScheduler.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskScheduler.JPA.SprintRepo;
import com.TaskScheduler.JPA.TaskRepo;
import com.TaskScheduler.JPA.UserRepo;
import com.TaskScheduler.entites.Sprint;
import com.TaskScheduler.entites.Task;
import com.TaskScheduler.entites.TaskStatus;
import com.TaskScheduler.entites.User;
import com.TaskScheduler.exceptions.SprintException;
import com.TaskScheduler.exceptions.TaskException;
import com.TaskScheduler.exceptions.UserException;

@Service
public class TaskServicesImpl implements TaskServices{
	
	@Autowired
	private TaskRepo taskRepo;
	
	@Autowired
	private SprintRepo sprintRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public Task createTask(Task task)throws TaskException {
		if(task == null)throw new TaskException("task is null");
		Task savedTask = taskRepo.save(task);
		return savedTask;
	}

	@Override
	public List<Task> getAllTasksBySprint(Integer sprintId) throws TaskException, SprintException {
		
		Optional<Sprint> sprint =  sprintRepo.findById(sprintId);
		if(sprint.isPresent()) {
			
			List<Task>  taskList = taskRepo.findBySprint(sprintId);
			if(!taskList.isEmpty()) {
				return taskList;
			}else {
				throw new TaskException("There is no task available in a given sprint");
			}
			
		}else {
			throw new SprintException("There is no sprint with id");
		}
		
	}

	@Override
	public List<Task> getAllTasksByAssignee(Integer assigneeId) throws UserException, TaskException {
		Optional<User> optionalUser =  userRepo.findById(assigneeId);
		if(optionalUser.isPresent()) {
			
			List<Task> taskList =  taskRepo.findByAssignee(assigneeId);
			if(taskList.size()!=0) {
				return taskList;
			}else {
				throw new TaskException("There are no task Assigned to assignee with the given id");
			}
			
		}else {
			throw new UserException("There is No assignee with the given Id");
		}
	}

	@Override
	public Task updateTaskAssignee(Integer taskId, Integer assigneeId) throws UserException, TaskException {
		Optional<Task> optionalTask = taskRepo.findById(taskId);
		if(optionalTask.isPresent()) {
			Optional<User> optionalUser = userRepo.findById(assigneeId);
			if(optionalUser.isPresent()) {
				optionalTask.get().setAssignee(optionalUser.get());
				 Task task = taskRepo.save(optionalTask.get());
				 return task;
			}else {
				throw new UserException("There is no User with Id that you provided");
			}
		}else {
			throw new TaskException("There is no task with Id that you provided");
		}
	}

	@Override
	public Task updateTaskStatus(Integer taskId, TaskStatus status) throws TaskException {
		Optional<Task> optTask = taskRepo.findById(taskId);
		if(optTask.isPresent()) {
			optTask.get().setStatus(status);
			Task task =  taskRepo.save(optTask.get());
			return task;
		}else {
			throw new TaskException("There is no task with Id that you provided");
		}
	}
	@Override
	public List<Task> getAllTaskByWeekDays(String day) throws TaskException {
		List<Task> taskList =  taskRepo.findByWeekDay(day);
		if(taskList.size()!=0) {
			return taskList;
		}else {
			throw new TaskException("There are no Tasks for : "+day);
		}
	}

}
