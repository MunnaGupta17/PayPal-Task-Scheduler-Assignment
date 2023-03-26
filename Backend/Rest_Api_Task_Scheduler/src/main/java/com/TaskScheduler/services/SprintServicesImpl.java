package com.TaskScheduler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskScheduler.JPA.SprintRepo;
import com.TaskScheduler.entites.Sprint;
import com.TaskScheduler.entites.Task;
import com.TaskScheduler.exceptions.SprintException;
import com.TaskScheduler.exceptions.TaskException;

@Service
public class SprintServicesImpl implements SprintServices{
	
	@Autowired
	private SprintRepo sprintRepo;

	@Override
	public Sprint createSprint(Sprint sprint)throws SprintException {
		if(sprint == null)throw new SprintException("sprint is null that you provided");
		Sprint savedSprint = sprintRepo.save(sprint);
		return savedSprint;
	}

	@Override
	public List<Sprint> getAllSprints() throws SprintException {
		List<Sprint> sprintList = sprintRepo.findAll();
		if(sprintList.size()!=0) {
			return sprintList;
		}else {
			throw new SprintException("There are no Sprints");
		}
	}

	

}
