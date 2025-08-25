package com.ems.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ems.dao.ProjectDAO;
import com.ems.entity.Project;
import com.ems.entity.User;
@Repository
public class ProjectDAOImpl implements ProjectDAO {
	
	@Autowired
	HibernateTemplate  hTemplate;
	
	@Override
	public void addProject(Project project) {
		hTemplate.save(project);
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project>  projectList=hTemplate.loadAll(Project.class);
		return projectList;
		
	}

	@Override
	public Project getProjectById(String projectId) {
		Project project=hTemplate.get(Project.class, projectId);
		return project;
	}

	@Override
	public void deleteProjectById(String projectId) {
		Project  project=hTemplate.get(Project.class, projectId);
		if(project!=null)
			hTemplate.delete(project);
	}

	@Override
	public void updateProject(Project project) {
	    Project existingProject = hTemplate.get(Project.class, project.getProjectId());
	    if (existingProject != null) {
	    	existingProject.setProjectName(project.getProjectName());
	    	existingProject.setEndDate(project.getEndDate() );
	    	existingProject.setExtendedEndDate(project.getExtendedEndDate());
	        hTemplate.update(existingProject);
	    }

	}

	@Override
	public Project getProjectByEmployeeId(String empId) {
	    User employee = hTemplate.get(User.class, empId);  
	    if (employee != null) {
	        return employee.getProject(); 
	    }
	    return null;
	}

	@Override
	public void updateEndDateOfProject(String projectId, Date newEndDate) {

	}

	@Override
	public List<Project> getAllProjectsByClientId(String clientId) {
	    return hTemplate.execute(session -> {
	        String hql = "SELECT DISTINCT p FROM Project p " +
	                     "LEFT JOIN FETCH p.employees " +
	                     "WHERE p.client.id = :clientId";
	        return session.createQuery(hql, Project.class)
	                      .setParameter("clientId", clientId)
	                      .getResultList();
	    });
	}

}
