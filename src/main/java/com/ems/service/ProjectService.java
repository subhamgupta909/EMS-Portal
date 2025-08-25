package com.ems.service;

import java.util.Date;
import java.util.List;

import com.ems.entity.Project;

public interface ProjectService {
	  public void addProject(Project project);
	  public List<Project>  getAllProjects();
	  public Project getProjectById(String projectId);
	  public void deleteProjectById(String projectId);
	  public void updateProject(Project project);
	  public Project getProjectByEmployeeId(String empId);
	  public Project  getAllEmployeesByProjectId(String projectId);
	  public List<Project>  getAllProjectsByClientId(String clientId);

	  public void updateEndDateOfProject(String projectId,Date newEndDate);

}
