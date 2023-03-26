package com.TaskScheduler.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TaskScheduler.entites.Sprint;
import com.TaskScheduler.entites.Task;
import com.TaskScheduler.exceptions.SprintException;
import com.TaskScheduler.exceptions.TaskException;

@Service
public interface SprintServices {
	
    public Sprint createSprint(Sprint sprint)throws SprintException;
	
	public List<Sprint> getAllSprints() throws SprintException;
	

}
