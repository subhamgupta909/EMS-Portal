package com.ems.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.ProjectDAO;
import com.ems.entity.Project;
import com.ems.service.ProjectService;
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDAO projectDao;
	
	@Override
	public void addProject(Project project) {
		projectDao.addProject(project);
		
	}

	@Override
	public List<Project> getAllProjects() {
	List<Project>	projectList=projectDao.getAllProjects();
		return projectList;
	}

	@Override
	public Project getProjectById(String projectId) {
		Project project=projectDao.getProjectById(projectId);
		return project;
	}

	@Override
	public void deleteProjectById(String projectId) {
		projectDao.deleteProjectById(projectId);
	}

	@Override
	public void updateProject(Project project) {
		projectDao.updateProject(project);
	}

	@Override
	public Project getProjectByEmployeeId(String empId) {
		Project project=projectDao.getProjectByEmployeeId(empId);
		return project;
	}

	@Override
	public Project getAllEmployeesByProjectId(String projectId) {
		return null;
	}

	@Override
	public void updateEndDateOfProject(String projectId, Date newEndDate) {
		
	}

	@Override
	public List<Project> getAllProjectsByClientId(String clientId) {
	List<Project>	projectList=projectDao.getAllProjectsByClientId(clientId);
		return projectList;
	}

}
