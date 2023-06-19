package com.TaskScheduler.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "weekDay")
	private Weekdays weekDay;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private TaskType type;

	@Column(name = "description")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private TaskStatus status;

	@ManyToOne
	@JoinColumn(name = "assignee_id")
	private User assignee;
	
	@ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;
	
	
//	public Task() {
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public Task(Integer id, String name, Weekdays weekDay, TaskType type, String description, TaskStatus status,
//			User assignee, Sprint sprint) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.weekDay = weekDay;
//		this.type = type;
//		this.description = description;
//		this.status = status;
//		this.assignee = assignee;
//		this.sprint = sprint;
//	}
//
//
//	public Integer getId() {
//		return id;
//	}
//
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public Weekdays getWeekDay() {
//		return weekDay;
//	}
//
//
//	public void setWeekDay(Weekdays weekDay) {
//		this.weekDay = weekDay;
//	}
//
//
//	public TaskType getType() {
//		return type;
//	}
//
//
//	public void setType(TaskType type) {
//		this.type = type;
//	}
//
//
//	public String getDescription() {
//		return description;
//	}
//
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//
//	public TaskStatus getStatus() {
//		return status;
//	}
//
//
//	public void setStatus(TaskStatus status) {
//		this.status = status;
//	}
//
//
//	public User getAssignee() {
//		return assignee;
//	}
//
//
//	public void setAssignee(User assignee) {
//		this.assignee = assignee;
//	}
//
//
//	public Sprint getSprint() {
//		return sprint;
//	}
//
//
//	public void setSprint(Sprint sprint) {
//		this.sprint = sprint;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Task [id=" + id + ", name=" + name + ", weekDay=" + weekDay + ", type=" + type + ", description="
//				+ description + ", status=" + status + ", assignee=" + assignee + ", sprint=" + sprint + "]";
//	}
//	
	

}
