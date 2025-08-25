package com.ems.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.ems.entity.Role;
import com.ems.entity.User;

public interface UserDAO {
	public User login(String email, String password) throws SQLException;

	public void addUser(User user);

	public List<User> getAllUsers();

	public List<User> findAllUsers(Role role);

	public User findUserById(String userId);

	public User findUserByEmail(String email);

	public List<User> findAllUsersByJoiningDateRange(Date start, Date end);

	public void deleteUserById(String userId);

	public void updateUser(User user);
    
	public List<User>  findAllEmployeesByProjectId(String projectId);
	public boolean assignProject(String userId, String projectId);

	public boolean removeProject(String userId, String projectId);

}
