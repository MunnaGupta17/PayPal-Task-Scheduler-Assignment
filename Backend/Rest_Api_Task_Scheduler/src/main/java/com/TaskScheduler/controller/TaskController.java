package com.TaskScheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TaskScheduler.entites.Task;
import com.TaskScheduler.entites.TaskStatus;
import com.TaskScheduler.exceptions.SprintException;
import com.TaskScheduler.exceptions.TaskException;
import com.TaskScheduler.exceptions.UserException;
import com.TaskScheduler.services.TaskServices;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskServices taskService;
	
	
	
	@PostMapping("/save")
	public ResponseEntity<Task> addTaskHandler(@RequestBody Task task) throws TaskException{
		Task savedTask = taskService.createTask(task);
		return new ResponseEntity<>(savedTask,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/sprint/{sprintId}")
	public ResponseEntity<List<Task>> getAllTasksBySprintHandler(@PathVariable("sprintId") Integer sprintId) throws TaskException, SprintException{
		List<Task> taskList = taskService.getAllTasksBySprint(sprintId);
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);
	}
	
	@GetMapping("/{assigneeId}")
	public ResponseEntity<List<Task>> getAllTasksByAssigneeHandler(@PathVariable("assigneeId") Integer assigneeId) throws UserException, TaskException{
		List<Task> taskList = taskService.getAllTasksByAssignee(assigneeId);
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);
	}
	
	@PutMapping("/{taskId}/{assigneeId}")
	public ResponseEntity<Task> updateTaskAssigneeHandler(@PathVariable("taskId") Integer taskId, @PathVariable("assigneeId") Integer assigneeId) throws UserException, TaskException {
		Task task = taskService.updateTaskAssignee(taskId, assigneeId);
		return new ResponseEntity<>(task,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{taskId}")
	public ResponseEntity<Task> updateTaskStatusHandler(@PathVariable("taskId") Integer taskId, TaskStatus status) throws TaskException{
		Task task = taskService.updateTaskStatus(taskId, status);
		return new ResponseEntity<>(task,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/weekdayTasks/{day}")
	public ResponseEntity<List<Task>> getAllTaskByWeekDays(@PathVariable("day") String day) throws TaskException{
		List<Task> taskList = taskService.getAllTaskByWeekDays(day);
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);
	}

}
