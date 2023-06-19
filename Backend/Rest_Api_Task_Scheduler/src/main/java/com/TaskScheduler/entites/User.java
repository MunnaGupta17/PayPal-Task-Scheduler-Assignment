package com.TaskScheduler.entites;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@NotEmpty(message = "Please Enter User Name")
	@NotNull(message = "User Name Should not be null")
	private String userName;

	@Email(message = "Invalid Email...")
	@NotEmpty(message = "Email Required... Please Enter Email")
	private String email;
	@OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
	private List<Task> tasks;
	
//	public User() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public User(Integer userId,
//			@NotEmpty(message = "Please Enter User Name") @NotNull(message = "User Name Should not be null") String userName,
//			@Email(message = "Invalid Email...") @NotEmpty(message = "Email Required... Please Enter Email") String email,
//			List<Task> tasks) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.email = email;
//		this.tasks = tasks;
//	}
//
//	public Integer getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public List<Task> getTasks() {
//		return tasks;
//	}
//
//	public void setTasks(List<Task> tasks) {
//		this.tasks = tasks;
//	}
//
//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", tasks=" + tasks + "]";
//	}
	
	

}
