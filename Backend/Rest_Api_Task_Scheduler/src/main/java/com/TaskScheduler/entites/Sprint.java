package com.TaskScheduler.entites;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sprint")
public class Sprint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "start_date")
	private Date startingDate;
	@Column(name = "end_date")
	private Date endingDate;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Task> tasks;
	
	public Sprint() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Sprint(Integer id, Date startingDate, Date endingDate, List<Task> tasks) {
		super();
		this.id = id;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.tasks = tasks;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}



	@Override
	public String toString() {
		return "Sprint [id=" + id + ", startingDate=" + startingDate + ", endingDate=" + endingDate + ", tasks=" + tasks
				+ "]";
	}
	
	
	

}
