package com.TaskScheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TaskScheduler.entites.Sprint;
import com.TaskScheduler.entites.Task;
import com.TaskScheduler.exceptions.SprintException;
import com.TaskScheduler.exceptions.TaskException;
import com.TaskScheduler.services.SprintServices;

@RestController
@RequestMapping("/sprints")
public class SprintController {
	
	@Autowired
	private SprintServices sprintService;

	@PostMapping("/sprints/save")
	public ResponseEntity<Sprint> addSprintHandler(@RequestBody Sprint sprint) throws SprintException{
		Sprint savedSprint = sprintService.createSprint(sprint);
		return new ResponseEntity<>(savedSprint,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/sprints")
	public ResponseEntity<List<Sprint>> getAllSprintsHandler() throws SprintException{
		List<Sprint> sprintList = sprintService.getAllSprints();
		return new ResponseEntity<List<Sprint>>(sprintList,HttpStatus.OK);
	}
	
	
	
}
