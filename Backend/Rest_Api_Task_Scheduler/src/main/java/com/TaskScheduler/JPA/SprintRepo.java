package com.TaskScheduler.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskScheduler.entites.Sprint;

@Repository
public interface SprintRepo extends JpaRepository<Sprint, Integer>{

}
