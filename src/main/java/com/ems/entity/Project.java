package com.ems.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="projects")
public class Project {
	@Id
	@GeneratedValue(generator = "projectId-gen")
	@GenericGenerator(name="projectId-gen",strategy = "com.ems.util.IDGenerator")
	@Column(name = "project_id")
	private String projectId;
	@Column(name="project_name")
	private String projectName;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="end_date")
	private Date endDate;
	@Column(name="extended_end_date")
	private Date extendedEndDate;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="client_id")
	private User client;
	@OneToMany(mappedBy = "project",cascade = {CascadeType.MERGE,CascadeType
			.PERSIST})
	private List<User> employees;

	public Project(String projectId, String projectName, Date startDate, Date endDate) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Project() {
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getExtendedEndDate() {
		return extendedEndDate;
	}

	public void setExtendedEndDate(Date extendedEndDate) {
		this.extendedEndDate = extendedEndDate;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public List<User> getEmployees() {
		return employees;
	}

	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", extendedEndDate=" + extendedEndDate + ", client=" + client
				+ ", employees=" + employees + "]";
	}


	
	

}
