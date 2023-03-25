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
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Task")
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

}
