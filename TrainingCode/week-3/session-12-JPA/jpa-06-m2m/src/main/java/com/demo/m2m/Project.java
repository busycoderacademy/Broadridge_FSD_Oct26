package com.demo.m2m;

import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.*;
@Entity
@Table(name = "p_table_y")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	
	private String projectName;

	@JoinTable(name = "e_p_jt",
	joinColumns = @JoinColumn(name = "pid_fk"),
	inverseJoinColumns = @JoinColumn(name = "eid_fk"))
	@ManyToMany
	private List<Employee> employees = new ArrayList<Employee>();

	//@LazyCollection(LazyCollectionOption.EXTRA)
//	public void addEmployeeToProject(Employee employee){
//		employees.add(employee);
//		employee.getProjects().add(this);
//	}
	public Project() {
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Project(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + "]";
	}

	
}
