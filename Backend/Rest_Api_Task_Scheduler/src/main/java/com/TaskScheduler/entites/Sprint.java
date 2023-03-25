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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "sprint")
@AllArgsConstructor
@NoArgsConstructor
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

}
